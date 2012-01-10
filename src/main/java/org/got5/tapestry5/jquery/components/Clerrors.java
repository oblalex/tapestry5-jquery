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

/**
 *
 * @author bitterman
 */
@Import(stylesheet = {"${assets.path}/components/clerrors/clerrors.css"})
public class Clerrors {    
    
    /**
     * The banner message displayed above the errors.
     */
    @Parameter("message:default-banner")
    private String banner;

    @Parameter(name = "wrapperclass")
    private String wrapperClassName = "t-invisible";
    
    @Parameter(name = "class")
    private String className = CSSClassConstants.ERROR;

    void beginRender(MarkupWriter writer){
        String formId = writer.getElement().getAttribute("id");
        
        writer.element("div", "class", wrapperClassName, "id", "wrap_clerrors_"+formId);        
            writer.element("div", "class", className, "id", "clerrors_"+formId);
                writer.element("div", "class", "t-banner", "id", "banner_clerrors_"+formId);
                writer.write(banner);
                writer.end();            
            writer.end();            
        writer.end();
    }
}
