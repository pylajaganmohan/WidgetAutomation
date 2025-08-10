package com.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.constants.AppConstants;
import com.utilities.ImageComparator;

@Listeners(com.listeners.ExtentReportListener.class)
public class TumblerTest extends BaseTest {

	@Test(description = "106583")
	public void TC_ID_106583() {
		tumbler = homePage.openTumblerWidget();
		Assert.assertTrue(tumbler.ID_106583());
	}
	
	@Test(description = "106584")
	public void TC_ID_106584() {
		tumbler = homePage.openTumblerWidget();
		Assert.assertTrue(tumbler.ID_106584());
	}
	
	@Test(description = "106585")
	public void TC_ID_106585() throws InterruptedException {
		tumbler = homePage.openTumblerWidget();
		Assert.assertEquals(tumbler.scrollToMax("2.1"),"2.10");
	}
	
	@Test(description = "106586")
	public void TC_ID_106586() throws InterruptedException {
		tumbler = homePage.openTumblerWidget();
		Assert.assertEquals(tumbler.scrollToMax(""),"1.00");
	}
	
	@Test(description = "106587")
	public void TC_ID_106587() throws InterruptedException {
		tumbler = homePage.openTumblerWidget();
		Assert.assertEquals(tumbler.scrollToMin("-1"),"-1.00");
	}
	
	@Test(description = "106588")
	public void TC_ID_106588() throws InterruptedException {
		tumbler = homePage.openTumblerWidget();
		Assert.assertEquals(tumbler.scrollToMin(""),"0.00");
	}
	
	@Test(description = "106589")
	public void TC_ID_106589() throws InterruptedException {
		tumbler = homePage.openTumblerWidget();
		Assert.assertEquals(tumbler.ID_106589("2"),"2.00");
	}
	
	@Test(description = "106590")
	public void TC_ID_106590() throws InterruptedException {
		tumbler = homePage.openTumblerWidget();
		Assert.assertEquals(tumbler.ID_106590(),"0.50");
	}
	
	@Test(description = "106591")
	public void TC_ID_106591() throws InterruptedException {
		tumbler = homePage.openTumblerWidget();
		Assert.assertEquals(tumbler.scrollToMin(""),"0.00");
	}
	
	@Test(description = "106592")
	public void TC_ID_106592() {
		tumbler = homePage.openTumblerWidget();
		boolean isSame = false;
		try {
			isSame = ImageComparator.compareImages(tumbler.validateOrientation(AppConstants.ORIENTATION_VERTICAL),
					AppConstants.TUMBLER_VERTICAL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(isSame);
	}
	
	@Test(description = "106593")
	public void TC_ID_106593() {
		tumbler = homePage.openTumblerWidget();
		boolean isSame = false;
		try {
			isSame = ImageComparator.compareImages(tumbler.validateOrientation(AppConstants.ORIENTATION_HORIZONTAL),
					AppConstants.TUMBLER_HORIZONTAL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(isSame);
	}
	
}
