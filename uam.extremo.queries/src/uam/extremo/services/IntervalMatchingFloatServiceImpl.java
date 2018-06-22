package uam.extremo.services;

import org.apache.commons.lang3.StringUtils;

import semanticmanager.impl.ExtensibleServiceImpl;

public class IntervalMatchingFloatServiceImpl extends ExtensibleServiceImpl {
	@Override
	public boolean matches(String expression, String value) {
		if(value.matches("[0-9]*..[0-9]*")){
			String[] splittedStrings = StringUtils.splitByWholeSeparator(value, "..");
			
			float intMinValue = Float.parseFloat((String) splittedStrings[0]);
			float intMaxValue = Float.parseFloat((String) splittedStrings[1]);
			
			if(intMinValue > intMaxValue) return false;
			
			float intExpressionValue = Float.parseFloat((String) expression);
			
			if((intMinValue <= intExpressionValue) && (intExpressionValue >= intMaxValue)){
				return true;
			}
		}
		
		return false;
	}
}
