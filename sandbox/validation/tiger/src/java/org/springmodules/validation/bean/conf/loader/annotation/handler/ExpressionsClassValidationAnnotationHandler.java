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

package org.springmodules.validation.bean.conf.loader.annotation.handler;

import java.lang.annotation.Annotation;

import org.springmodules.validation.bean.conf.MutableBeanValidationConfiguration;
import org.springmodules.validation.util.cel.ConditionExpressionBased;
import org.springmodules.validation.util.cel.ConditionExpressionParser;
import org.springmodules.validation.util.fel.FunctionExpressionBased;
import org.springmodules.validation.util.fel.FunctionExpressionParser;

/**
 *
 * @author Uri Boness
 */
public class ExpressionsClassValidationAnnotationHandler implements ClassValidationAnnotationHandler, 
    ConditionExpressionBased, FunctionExpressionBased {

    ExpressionClassValidationAnnotationHandler expressionHandler;

    public ExpressionsClassValidationAnnotationHandler() {
        expressionHandler = new ExpressionClassValidationAnnotationHandler();
    }

    public boolean supports(Annotation annotation, Class clazz) {
        return Expressions.class.isInstance(annotation);
    }

    public void handleAnnotation(Annotation annotation, Class clazz, MutableBeanValidationConfiguration configuration) {
        Expressions expressions = (Expressions)annotation;
        Expression[] expressionAnnotations = expressions.value();
        for (int i=0; i<expressionAnnotations.length; i++) {
            expressionHandler.handleAnnotation(expressionAnnotations[i], clazz, configuration);
        }
    }


    //=============================================== Setter/Getter ====================================================

    /**
     * @see ConditionExpressionBased#setConditionExpressionParser(org.springmodules.validation.util.cel.ConditionExpressionParser)
     */
    public void setConditionExpressionParser(ConditionExpressionParser conditionExpressionParser) {
        expressionHandler.setConditionExpressionParser(conditionExpressionParser);
    }

    /**
     * @see FunctionExpressionBased#setFunctionExpressionParser(org.springmodules.validation.util.fel.FunctionExpressionParser)
     */
    public void setFunctionExpressionParser(FunctionExpressionParser functionExpressionParser) {
        expressionHandler.setFunctionExpressionParser(functionExpressionParser);
    }
}
