/*
 * Copyright 2002-2005 the original author or authors.
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

package org.springmodules.template.providers.xslt;

import java.util.*;

import javax.xml.transform.*;

/**
 * A strategy to convert a Map model to a {@link Source} object.
 *
 * @author Uri Boness
 */
public interface ModelToSourceConverter {

    /**
     * Converts the given Map model to a {@link Source}.
     *
     * @param model The model to convert.
     * @return The source that was created out of the given model.
     * @throws ModelToSourceConversionException When the convertion fails.
     */
    public Source convert(Map model) throws ModelToSourceConversionException;

}