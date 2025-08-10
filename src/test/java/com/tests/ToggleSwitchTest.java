package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTest;

public class ToggleSwitchTest extends BaseTest{

	@Test(description = "106576")
	public void TC_ID_106576() {
		toggle = homePage.openToggleSwitchWidget();
		Assert.assertTrue(toggle.ID_106576());
	}
	
	@Test(description = "106577")
	public void TC_ID_106577() {
		toggle = homePage.openToggleSwitchWidget();
		Assert.assertTrue(toggle.ID_106577());
	}
	
	@Test(description = "106578")
	public void TC_ID_106578() {
		toggle = homePage.openToggleSwitchWidget();
		Assert.assertTrue(toggle.ID_106578());
		
	}
	
	@Test(description = "106579")
	public void TC_ID_106579() {
		toggle = homePage.openToggleSwitchWidget();
		Assert.assertTrue(toggle.ID_106579());
		
	}
	
	@Test(description = "106580")
	public void TC_ID_106580() {
		toggle = homePage.openToggleSwitchWidget();
		softAssert = new SoftAssert();
		softAssert.assertTrue(toggle.widgetSize("small"));
		softAssert.assertTrue(toggle.widgetSize("medium"));
		softAssert.assertTrue(toggle.widgetSize("large"));
		softAssert.assertAll();
		
	}
	@Test(description = "106581")
	public void TC_ID_106581() {
		toggle = homePage.openToggleSwitchWidget();
		softAssert = new SoftAssert();
		softAssert.assertTrue(toggle.widgetSize("small"));
		softAssert.assertTrue(toggle.widgetSize("medium"));
		softAssert.assertTrue(toggle.widgetSize("large"));
		softAssert.assertAll();
		
	}
}
