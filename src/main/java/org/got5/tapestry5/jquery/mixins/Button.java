//
// Copyright 2010 GOT5 (GO Tapestry 5)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.got5.tapestry5.jquery.mixins;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.got5.tapestry5.jquery.ImportJQueryUI;
import org.got5.tapestry5.jquery.utils.JQueryUtils;

/**
 * The Button mixin improve the form of traditional elements like button, submit, reset ...
 * 
 * @see <a href="http://jqueryui.com/demos/button/">http://jqueryui.com/demos/button/</a>
 * 
 * @tapestrydoc
 */
@ImportJQueryUI({ "jquery.ui.widget", "jquery.ui.core", "jquery.ui.button" })
@Import(library = { "${assets.path}/mixins/button/button.js" })
public class Button
{
    /**
     * The field component to which this mixin is attached.
     */
    @InjectContainer
    private ClientElement element;

    @Environmental
    private JavaScriptSupport javaScriptSupport;

    static final String TYPE_BUTTON = "button";
	static final String TYPE_BUTTONSET = "buttonset";

	/**
	 * The type parameter indicates wich constructor you want to use. 
	 * Available Parameter values : button or buttonset
	 */
	@Parameter(defaultPrefix = BindingConstants.LITERAL, value = TYPE_BUTTON)
	private String type;

	/**
	 * The Button parameters you want to override.
	 */
	@Parameter
    private JSONObject params;

    /**
     * Mixin afterRender phrase occurs after the component itself. This is where we write the
     * &lt;div&gt; element and
     * the JavaScript.
     */
	void afterRender()
    {
        String id = element.getClientId();

        JSONObject data = new JSONObject("id", id, "type", type);
        
        JSONObject defaults = new JSONObject("type", type);
        
        if (params == null)
            params = new JSONObject();

        JQueryUtils.merge(defaults, params);
        data.put("params", defaults);

        javaScriptSupport.addInitializerCall("button", data);
    }

}
