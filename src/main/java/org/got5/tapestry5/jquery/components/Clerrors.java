/*
 * Copyright 2012 GOT5.
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
package org.got5.tapestry5.jquery.components;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author bitterman
 */
@Import(stylesheet = {"${assets.path}/components/clerrors/clerrors.css"})
public class Clerrors {
    
    @Inject
    private Messages messages;
    
    /**
     * The banner message displayed above the errors.
     */
    @Parameter("message:default-banner")
    private String banner;

    @Parameter(name = "wrapperclass")
    private String wrapperClassName = "tjq-clerrors";
    
    @Parameter(name = "class")
    private String className = CSSClassConstants.ERROR;
    
    public void contributeValidationMessagesSource(Configuration<String> configuration) {
        configuration.add("path/to/your/package/ValidationMessages.properties");
    }
    
    void beginRender(MarkupWriter writer){
        String formId = writer.getElement().getAttribute("id");
        
        Element el_wrapper = writer.element("div", "class", wrapperClassName);
        el_wrapper.forceAttributes("id", "wrap_clerrors_"+formId);
        
            Element el_body = writer.element("div", "class", className);
            el_body.forceAttributes("id", "clerrors_"+formId);

                Element el_banner = writer.element("div", "class", "t-banner");
                el_banner.forceAttributes("id", "banner_clerrors_"+formId);
                writer.write(banner);
                writer.end();            

            writer.end();
            
        writer.end();
    }
}
