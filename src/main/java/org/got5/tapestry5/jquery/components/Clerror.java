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

/**
 *
 * @author bitterman
 */
@Import(stylesheet = {"${assets.path}/components/clerror/clerror.css"})
public class Clerror {

    /**
     * The for parameter is used to identify the {@link Field} to present errors of.
     */
    @Parameter(name = "for", required = true, allowNull = false, defaultPrefix = BindingConstants.COMPONENT)
    private Field field;
    
    @Parameter(name = "class")
    private String className = "t-invisible";
    
    void beginRender(final MarkupWriter writer) {        
        Element element = writer.element("div", "class", className);
        updateElement(element);
        writer.end();
    }

    @HeartbeatDeferred
    private void updateElement(final Element element) {
        element.forceAttributes("id", "clerror_"+field.getClientId());
    }
}
