package org.got5.tapestry5.jquery;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

public class AjaxFormLoopTest extends SeleniumTestCase{
	
	@Test
    public void testAjaxFormLoop(){
    	
    	open("/AjaxFormLoop");
    	
    	click("//a[@id='addrowlink']");
    	
    	new Wait()
        {
            @Override
            public boolean until()
            {
                return getXpathCount("//div[contains(@id,'rowInjector_')]").equals(1);
            }
        }.wait("We should have just one row.", JQueryTestConstants.TIMEOUT);
        
        new Wait()
        {
            @Override
            public boolean until()
            {
                return getAttribute("//div[@id='testCallback']@class").equalsIgnoreCase("added");
            }
        }.wait("The Added event has not been triggered.", JQueryTestConstants.TIMEOUT);
        
        click("//a[@id='addrowlink']");
    	
    	new Wait()
        {
            @Override
            public boolean until()
            {
                return getXpathCount("//div[contains(@id,'rowInjector_')]").equals(2);
            }
        }.wait("A New row should be present.", JQueryTestConstants.TIMEOUT);
        
        click("//a[contains(@id,'removerowlink_')][1]");
    	
    	new Wait()
        {
            @Override
            public boolean until()
            {
                return getXpathCount("//div[contains(@id,'rowInjector_')]").equals(1);
            }
        }.wait("The first row should be deleted.", JQueryTestConstants.TIMEOUT);
    	
        new Wait()
        {
            @Override
            public boolean until()
            {
                return getAttribute("//div[@id='testCallback']@class").equalsIgnoreCase("removed");
            }
        }.wait("The Removed event has not been triggered.", JQueryTestConstants.TIMEOUT);
    }
}
