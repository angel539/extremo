package at.ac.tuwien.big.xmltext.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


public class MyEcoreUtil {

	public static Collection<EStructuralFeature.Setting> getReferences(EObject obj) {
		Resource res = obj.eResource();
		if (res != null) {
			ResourceSet set = res.getResourceSet();
			if (set != null) {
				return EcoreUtil.UsageCrossReferencer.find(obj,set);
			}
			return EcoreUtil.UsageCrossReferencer.find(obj,res);
		}
		return EcoreUtil.UsageCrossReferencer.find(obj,EcoreUtil.getRootContainer(obj));
		
	}
	

	public static List<EObject> allInstances(EObject context, EClass cl) {
		Resource res = context.eResource();
		List<Resource> resources = new ArrayList<Resource>();
		if (res != null)  {
			ResourceSet set = res.getResourceSet();
			if (set != null) {
				resources.addAll(set.getResources());
			} else {
				resources.add(res);
			}
		}
		List<EObject> ret = new ArrayList<EObject>();
		Iterator<EObject> iter = resources.isEmpty()?EcoreUtil.getRootContainer(context,true).eAllContents():
			IteratorUtils.multiIterator(IteratorUtils.convert(resources.iterator(), (r)->r.getAllContents()));
		for (EObject eobj: ((Iterable<EObject>)(()->iter))) {
			if (eobj.eClass() == cl) {
				ret.add(eobj);
			}
		}
		return ret;
	}
	
	public static boolean addValue(EObject This, EStructuralFeature feat, Object value) {
		try {
		if (FeatureMapUtil.isMany(This, feat)) {
			return ((Collection)This.eGet(feat)).add(value);
		} else {
			if (!This.eIsSet(feat)) {
				This.eSet(feat, value);
				return true;
			}
			return false;
		}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public static void addValue(EObject This, EStructuralFeature feat, int index, Object value) {
		if (FeatureMapUtil.isMany(This, feat)) {
			((List)This.eGet(feat)).add(index,value);
		} else {
			if (!This.eIsSet(feat)) {
				This.eSet(feat, value);
			}
		}
	}
	
	public static void removeValue(EObject This, EStructuralFeature feat, Object value) {
		if (FeatureMapUtil.isMany(This, feat)) {
			((Collection)This.eGet(feat)).remove(value);
		} else {
			Object cur = This.eGet(feat);
			if (cur != null && cur.equals(value)) {
				This.eSet(feat, null);
			}
		}
	}
	

	public static void removeValueAtIndex(EObject This, EStructuralFeature feat, int index) {
		if (FeatureMapUtil.isMany(This, feat)) {
			((List)This.eGet(feat)).remove(index);
		} else {
			Object cur = This.eGet(feat);
			This.eUnset(feat);
		}
	}
	
	
	public static int removeValueGetIndex(EObject This, EStructuralFeature feat, Object value) {
		if (FeatureMapUtil.isMany(This, feat)) {
			List l  =((List)This.eGet(feat));
			int ret = l.indexOf(value);
			if (ret != -1) {
				l.remove(ret);
			}
			return ret;
		} else {
			Object cur = This.eGet(feat);
			if (cur != null && cur.equals(value)) {
				This.eUnset(feat);
				return 0;
			}
			return -1;
		}
	}
	
	public static EObject newInstance(EClass from) {
		EObject ret = null;
		if (from.getInstanceClass() != null) {
			Class<?> cl = from.getInstanceClass();
			try {
				Constructor<?> con = cl.getDeclaredConstructor();
				con.setAccessible(true);
				ret = (EObject)con.newInstance();
			} catch (NoSuchMethodException e) {
				//Try to adapt class
				try {
					Class<?> otherclass = cl.getClassLoader().loadClass(cl.getCanonicalName().substring(0,cl.getCanonicalName().lastIndexOf("."))+".impl."+cl.getSimpleName()+"Impl");
					if (otherclass != null) {
						from.setInstanceClass(otherclass);
						return newInstance(from);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} else {
			ret = new DynamicEObjectImpl(from);
		}
		return ret;
	}
	
	public static EObject newInstance(EObject from) {
		EObject ret = null;
		if (from instanceof DynamicEObjectImpl) {
			ret = new DynamicEObjectImpl(from.eClass());
		} else {
			Class<?> cl = from.getClass();
			try {
				Constructor<?> con = cl.getDeclaredConstructor();
				con.setAccessible(true);
				ret = (EObject)con.newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return ret;
	}
	
	
	public static EObject nearCopy(EObject from, Map<EObject,EObject> map) {
		EObject ret = map.get(from);
		if (from == null) {
			return ret;
		}
		if (ret == null) {
			ret = newInstance(from);
			map.put(from,ret);
			EObject cont = from.eContainer();
			if (cont != null) {
				EReference cfeat = (EReference)from.eContainingFeature();
				List l = (List)MyEcoreUtil.getAsCollection(cont, cfeat);
				int myInd = l.indexOf(from);
				if (myInd != -1) {
					EObject retCont = nearCopy(cont, map);
					//Da werden automatisch auch die Referenzen mitkopiert
				}
			}
			if (ret == null) {
				throw new RuntimeException("Cannot copy EObject " + from);
			}
			for (EAttribute attr: from.eClass().getEAllAttributes()) {
				if (from.eIsSet(attr)) {
					if (FeatureMapUtil.isMany(from, attr)) {
						List l = (List)from.eGet(attr);
						((Collection)ret.eGet(attr)).addAll(l);
					} else {
						ret.eSet(attr,from.eGet(attr));
					}
				}
			}
			for (EReference ref: from.eClass().getEAllReferences()) {
				if (from.eIsSet(ref)) {
					if (FeatureMapUtil.isMany(from, ref)) {
						List l = (List)from.eGet(ref);
						for (EObject eo: ((Collection<EObject>)ret.eGet(ref))) {
							l.add(nearCopy(eo, map));
						};
					} else {
						EObject cur = (EObject)from.eGet(ref);
						if (cur != null) {
							ret.eSet(ref,nearCopy(cur, map));
						}
					}
				}
			}
		}
		return ret;
	}
	
	public static interface Converter<T,U> {
		public U get(T t);
	}

	public static Map<Class<?>,Map<Class<?>, Converter<?,?>>> converters = new HashMap<>();
	static {
		addConverter(Integer.class, Long.class, (x)->(long)(int)x);
		addConverter(Long.class, Integer.class, (x)->(int)(long)x);
		addConverter(BigInteger.class, Integer.class, (x)->x.intValue());
		addConverter(BigInteger.class, Long.class, (x)->x.longValue());
		addConverter(BigInteger.class, Double.class, (x)->x.doubleValue());
		addConverter(Integer.class, BigInteger.class, (x)->BigInteger.valueOf((int)x));
		addConverter(Long.class, BigInteger.class, (x)->BigInteger.valueOf((long)x));
		addConverter(Double.class, BigInteger.class, (x)->BigInteger.valueOf((long)(double)x));
	}
	
	public static<T,U> void addConverter(Class<T> from, Class<U> to, Converter<T,U> conv) {
		Map<Class<?>, Converter<?,?>> map = converters.get(from);
		if (map == null) {
			converters.put(from, map = new HashMap<Class<?>, MyEcoreUtil.Converter<?,?>>());
		}
		map.put(to, conv);
	}
	
	
	public static <T,U> Converter<T, U> getConverter(Class<T> from, Class<U> to) {
		Map<Class<?>, Converter<?,?>> convMap = converters.getOrDefault(from,Collections.emptyMap());
		return (Converter)convMap.get(to);
	}

	public static<T extends Number> T getNumber(Class<T> targetClass, Number curValue) {
		if (curValue == null) {
			return null;
		}
		if (curValue.getClass() == targetClass) {
			return (T)curValue;
		}
		Converter<?,T> converter = getConverter(curValue.getClass(), targetClass);
		if (converter != null) {
			return (T)((Converter)converter).get(curValue);
		}
		return null;
	}
	
	public static Collection asCollection(Object o) {
		if (o == null) {
			return Collections.emptyList();
		} else {
			if (o instanceof Collection) {
				return (Collection)o;
			} else {
				return Collections.singletonList(o);
			}
		}
	}


	public static Collection toCollection(Object o) {
		if (o == null) {
			return Collections.emptyList();
		} else {
			return Collections.singletonList(o);
		}
	}


	public static boolean isMany(EStructuralFeature ecoreAttr) {
		return ecoreAttr.getUpperBound()>1 || ecoreAttr.getUpperBound() == -1;
	}

	
	public static Collection getAsCollection(EObject eobj, EStructuralFeature esf) {
		if (FeatureMapUtil.isMany(eobj, esf)) {
			return ((Collection)(eobj.eGet(esf)));
		} else {
			try {
				Object ret = eobj.eGet(esf);
				if (ret == null) {
					return Collections.emptyList();
				} else {
					return Collections.singletonList(ret);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new ArrayList();
			}
		}
	}
	

	public static void setAsCollectionBasic(EObject ret, EStructuralFeature attr, Collection c) {
		if (FeatureMapUtil.isMany(ret, attr)) {
			Collection cur = (Collection)ret.eGet(attr);
			cur.clear();
			cur.addAll(c);
		} else {
			if (c.isEmpty()) {
				ret.eSet(attr, null);
			} else {
				ret.eSet(attr, c.iterator().next());
			}
		}
	}


	public static String getEObjName(EObject eobj) {
		if (eobj == null) {
			return "null";
		}
		if (eobj.eResource() != null) {
			return ((eobj.eClass() != null)?(eobj.eClass().getName()+" "):"")+eobj.eResource().getURIFragment(eobj);
		}
		return String.valueOf(eobj);
	}


	public static String getEObjName(EObject eobj, String contextUri) {
		if (eobj == null || eobj.eResource() == null) {
			return getEObjName(eobj);
		}
		String myUrl = eobj.eResource().getURI()+"+"+eobj.eResource().getURIFragment(eobj);
		if (myUrl.equals(contextUri)) {
			return "self";
		}
		String otherUrl = contextUri;
		String[] myUrlSpl = myUrl.split("/");
		String[] contextUrlSpl = otherUrl.split("/");
		int i = 0;
		for (; i < Math.min(myUrlSpl.length, contextUrlSpl.length); ++i) {
			if (myUrlSpl[i].equals(contextUrlSpl[i])) {
				
			}
		}
		//Jetzt ist es ungleich
		StringBuilder ret = new StringBuilder();
		if (i == 0 || (myUrlSpl.length-i)*2+contextUrlSpl.length-i > myUrlSpl.length*2) {
			return myUrl;
		}
		boolean first = true;
		
		for (int j = i; j < contextUrlSpl.length; ++j) {
			if (first) {first = false;} else {ret.append("/");}
			ret.append("..");
		}
		for (int j = i; j < myUrlSpl.length; ++j) {
			if (first) {first = false;} else {ret.append("/");}
			ret.append(myUrlSpl[j]);
		}
		return ret.toString();
	}
	
	public static String getEObjName(EObject eobj, EObject context) {
		if (eobj == null || context == null || eobj.eResource() == null || context.eResource() == null) {
			return getEObjName(eobj);
		}
		if (eobj.equals(context)) {
			return "self";
		}
		String myUrl = eobj.eResource().getURI()+"+"+eobj.eResource().getURIFragment(eobj);
		String otherUrl = context.eResource().getURI()+"+"+context.eResource().getURIFragment(context);
		String[] myUrlSpl = myUrl.split("/");
		String[] contextUrlSpl = otherUrl.split("/");
		int i = 0;
		for (; i < Math.min(myUrlSpl.length, contextUrlSpl.length); ++i) {
			if (myUrlSpl[i].equals(contextUrlSpl[i])) {
				
			}
		}
		//Jetzt ist es ungleich
		StringBuilder ret = new StringBuilder();
		if (i == 0 || (myUrlSpl.length-i)*2+contextUrlSpl.length-i > myUrlSpl.length*2) {
			return myUrl;
		}
		boolean first = true;
		
		for (int j = i; j < contextUrlSpl.length; ++j) {
			if (first) {first = false;} else {ret.append("/");}
			ret.append("..");
		}
		for (int j = i; j < myUrlSpl.length; ++j) {
			if (first) {first = false;} else {ret.append("/");}
			ret.append(myUrlSpl[j]);
		}
		return ret.toString();
	}


	public static int getAsCollectionSize(EObject eobj, EStructuralFeature feature) {
		return getAsCollection(eobj, feature).size();			
	}


	public static String getEObjName(Object value) {
		if (value instanceof EObject) {
			return getEObjName((EObject)value);
		}
		return String.valueOf(value);
	}


	public static EObject fakeCast(EObject targetEl, EObject srcEl) {
		EObject ret = newInstance(srcEl);
		//Copy same features
		for (EStructuralFeature esf: srcEl.eClass().getEAllStructuralFeatures()) {
			//You can copy the feature if the new class has existed in the old class
			if (esf.getEContainingClass().isSuperTypeOf(targetEl.eClass())) {
				ret.eSet(esf,targetEl.eGet(esf));
			}
		}
		return ret;
	}


	public static EObject createInstanceStatic(EClass targetType) {
		EcoreFactory fact = EcoreFactory.eINSTANCE;
		EObject eobj = null;
		if (targetType.getInstanceClass() != null) {
			if (targetType.getInstanceClass().isInterface()) {
				//try to find real
				String tryName = targetType.getInstanceClass().getCanonicalName();
				int lind = tryName.lastIndexOf(".");
				String mainName = tryName.substring(lind+1);
				String packageName = tryName.substring(0,lind);
				String wohleName = packageName+".impl."+mainName+"Impl";
				Class<?> realClass;
				try {
					realClass = targetType.getInstanceClass().getClassLoader().loadClass(wohleName);
					realClass.getDeclaredConstructor().setAccessible(true);
					if (realClass != null) {
						targetType.setInstanceClass(realClass);
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			try {
				Constructor c = targetType.getInstanceClass().getDeclaredConstructor();
				c.setAccessible(true);
				eobj = (EObject)c.newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		if (eobj == null) {
			eobj = new DynamicEObjectImpl(targetType);
		}
		return eobj;
	}


	public static Resource loadEcore(String fileName) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();
		return rs.getResource(rs.getURIConverter().normalize(URI.createFileURI(fileName)),true);
	}


	public static String getName(EStructuralFeature esf) {
		return esf.getEContainingClass().getName()+"."+esf.getName();
	}




}

