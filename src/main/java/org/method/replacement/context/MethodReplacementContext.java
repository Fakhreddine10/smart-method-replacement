/*

 * Copyright 2018 the original author or authors.

 *

 * Licensed under the Apache License, Version 2.0 (the "License");

 * you may not use this file except in compliance with the License.

 * You may obtain a copy of the License at

 *

 *      http://www.apache.org/licenses/LICENSE-2.0

 *

 * Unless required by applicable law or agreed to in writing, software

 * distributed under the License is distributed on an "AS IS" BASIS,

 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

 * See the License for the specific language governing permissions and

 * limitations under the License.
 * */

package org.method.replacement.context;

import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * 
 * This class is used as context in order to determine when a method should be
 * replaced by the new implementation defined by the developer.
 * 
 * @author Belgaied Fakhreddine
 * 
 * @version $Id:MethodReplacementContext.java, v 1.0 2018/02/02 fbelgaied Exp $
 * 
 * 
 */
public class MethodReplacementContext {

	private String className;

	private String methodName;
	private Parameter[] argumentList;
	private String returnedtype;
	private int modifier;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Parameter[] getArgumentList() {
		return argumentList;
	}

	public void setArgumentList(Parameter[] argumentList) {
		this.argumentList = argumentList;
	}

	public String getReturnedtype() {
		return returnedtype;
	}

	public void setReturnedtype(String returnedtype) {
		this.returnedtype = returnedtype;
	}
	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(argumentList);
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
		result = prime * result + modifier;
		result = prime * result + ((returnedtype == null) ? 0 : returnedtype.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MethodReplacementContext other = (MethodReplacementContext) obj;
		if (!Arrays.equals(argumentList, other.argumentList))
			return false;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (methodName == null) {
			if (other.methodName != null)
				return false;
		} else if (!methodName.equals(other.methodName))
			return false;
		if (modifier != other.modifier)
			return false;
		if (returnedtype == null) {
			if (other.returnedtype != null)
				return false;
		} else if (!returnedtype.equals(other.returnedtype))
			return false;
		return true;
	}


}
