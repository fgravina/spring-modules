/*
 * Copyright 2004-2005 the original author or authors.
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
 */ 
package org.springmodules.validation.functions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.util.Assert;

public class ResolveFunction extends AbstractFunction {

	public ResolveFunction(Function[] arguments, int line, int column) {
		super(arguments, line, column);
	}

	protected Object doGetResult(Object target) throws Exception {
		Assert.notEmpty(getArguments(), "Resolve function requires one argument " + getTemplate().getAtLineString() + "!");
		Assert.isTrue(getArguments().length == 1, "Resolve function does not accept more than one argument " + getTemplate().getAtLineString() + "!");
		Object value = getArguments()[0].getResult(target);
		Assert.isInstanceOf(String.class, value, "Argument of resolve method must be a string value or return a string value " + getTemplate().getAtLineString() + "!");
		return new DefaultMessageSourceResolvable((String)value);
	}

}