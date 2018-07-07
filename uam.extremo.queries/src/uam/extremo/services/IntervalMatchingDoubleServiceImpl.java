package uam.extremo.services;

import org.apache.commons.lang3.StringUtils;

import uam.extremo.core.impl.ExtensibleServiceImpl;

public class IntervalMatchingDoubleServiceImpl extends ExtensibleServiceImpl {
	@Override
	public boolean matches(String expression, String value) {
		if(value.matches("[0-9]*..[0-9]*")){
			String[] splittedStrings = StringUtils.splitByWholeSeparator(value, "..");
			
			double intMinValue = Double.parseDouble((String) splittedStrings[0]);
			double intMaxValue = Double.parseDouble((String) splittedStrings[1]);
			
			if(intMinValue > intMaxValue) return false;
			
			double intExpressionValue = Double.parseDouble((String) expression);
			
			if((intMinValue <= intExpressionValue) && (intExpressionValue >= intMaxValue)){
				return true;
			}
		}
		
		return false;
	}
}
