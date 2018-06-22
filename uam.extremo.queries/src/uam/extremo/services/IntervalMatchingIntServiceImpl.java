package uam.extremo.services;

import org.apache.commons.lang3.StringUtils;

import semanticmanager.impl.ExtensibleServiceImpl;

public class IntervalMatchingIntServiceImpl extends ExtensibleServiceImpl {
	@Override
	public boolean matches(String expression, String value) {
		if(value.matches("[0-9]*..[0-9]*")){
			String[] splittedStrings = StringUtils.splitByWholeSeparator(value, "..");
			
			int intMinValue = Integer.parseInt((String) splittedStrings[0]);
			int intMaxValue = Integer.parseInt((String) splittedStrings[1]);
			
			if(intMinValue > intMaxValue) return false;
			
			int intExpressionValue = Integer.parseInt((String) expression);
			
			if((intMinValue <= intExpressionValue) && (intExpressionValue >= intMaxValue)){
				return true;
			}
		}
		
		return false;
	}
}
