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

package org.springmodules.validation.bean.conf.loader;

import org.springmodules.validation.bean.conf.BeanValidationConfiguration;
import org.springmodules.validation.bean.conf.BeanValidationConfigurationLoader;

/**
 * A composite {@link org.springmodules.validation.bean.conf.BeanValidationConfigurationLoader} implementation that
 * loads bean validation configuration using multiple sub-loaders.
 *
 * @author Uri Boness
 */
public class PrioritizedBeanValidationConfigurationLoader implements BeanValidationConfigurationLoader {

    private BeanValidationConfigurationLoader[] loaders;

    public PrioritizedBeanValidationConfigurationLoader() {
        this(new BeanValidationConfigurationLoader[0]);
    }

    public PrioritizedBeanValidationConfigurationLoader(BeanValidationConfigurationLoader[] loaders) {
        this.loaders = loaders;
    }

    public BeanValidationConfiguration loadConfiguration(Class clazz) {
        for (int i=0; i<loaders.length; i++) {
            if (loaders[i].supports(clazz)) {
                BeanValidationConfiguration config = loaders[i].loadConfiguration(clazz);
                if (config != null) {
                    return config;
                }
            }
        }
        return null;
    }


    public boolean supports(Class clazz) {
        for (int i=0; i<loaders.length; i++) {
            if (loaders[i].supports(clazz)) {
                return true;
            }
        }
        return false;
    }


    //=============================================== Setter/Getter ====================================================

    public void setLoaders(BeanValidationConfigurationLoader[] loaders) {
        this.loaders = loaders;
    }

    public BeanValidationConfigurationLoader[] getLoaders() {
        return loaders;
    }

}