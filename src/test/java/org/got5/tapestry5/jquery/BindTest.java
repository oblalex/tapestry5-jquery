package org.got5.tapestry5.jquery;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

public class BindTest extends SeleniumTestCase{
	
	@Test
    public void testBind(){
		open("/Bind");
		
		assertSourcePresent("jqbind","eventType","\"click\",");       
	}
	
	@Test
	public void testEvent() {
		open("/Bind");
    
		click("//div[@id='clickHere']");
        
        new Wait()
        {
            @Override
            public boolean until()
            {
                return isTextPresent("click OK");
            }
        }.wait("element not found", JQueryTestConstants.TIMEOUT);
        
        assertEquals(getText("identifier=clickZone"), "click OK");
	}

}
