package org.got5.tapestry5.jquery.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.ioc.annotations.Inject;

public class ProgressiveDisplay {

	@Inject
	private Block testBlock;
	
	@OnEvent(EventConstants.PROGRESSIVE_DISPLAY)
	public Object returnBlock() throws InterruptedException{
		Thread.sleep(2000);
		return testBlock;
	}
}
