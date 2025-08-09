package com.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseTest;

@Listeners(com.listeners.ExtentReportListener.class)
public class ButtonTest extends BaseTest {

	static boolean TC_ID_106540 = false;
	static boolean TC_ID_106541 = false;
	static boolean TC_ID_106542 = false;
	static boolean TC_ID_106543 = false;
	static boolean TC_ID_106544 = false;
	static boolean TC_ID_106545 = false;

	@Test(description = "106538")
	public void TC_ID_106538() {
		button = homePage.openButtonWidget();
		Assert.assertTrue(button.isButtonVisible());
	}

	@Test(description = "106539", dependsOnMethods = { "TC_ID_106540", "TC_ID_106541", "TC_ID_106542", "TC_ID_106543",
			"TC_ID_106544", "TC_ID_106545" })
	public void TC_ID_106539() {
		Assert.assertTrue(TC_ID_106540 && TC_ID_106541 && TC_ID_106542 && TC_ID_106543 && TC_ID_106544 && TC_ID_106545);
	}

	@Test(description = "106540")
	public void TC_ID_106540() {
		button = homePage.openButtonWidget();
		TC_ID_106540 = button.ID_106540();
		Assert.assertTrue(button.ID_106540());
	}

	@Test(description = "106541")
	public void TC_ID_106541() {
		button = homePage.openButtonWidget();
		TC_ID_106541 = button.ID_106541();
		Assert.assertTrue(button.ID_106541());
	}

	@Test(description = "106542")
	public void TC_ID_106542() {
		button = homePage.openButtonWidget();
		TC_ID_106542 = button.ID_106542();
		Assert.assertTrue(button.ID_106542());
	}

	@Test(description = "106543")
	public void TC_ID_106543() {
		button = homePage.openButtonWidget();
		TC_ID_106543 = button.ID_106543();
		Assert.assertTrue(button.ID_106543());
	}

	@Test(description = "106544")
	public void TC_ID_106544() {
		button = homePage.openButtonWidget();
		TC_ID_106544 = button.ID_106544();
		Assert.assertTrue(button.ID_106544());
	}

	@Test(description = "106545")
	public void TC_ID_106545() {
		button = homePage.openButtonWidget();
		TC_ID_106545 = button.ID_106545();
		Assert.assertTrue(button.ID_106545());
	}
	
	@Test(description = "106546")
	public void TC_ID_106546() {
		button = homePage.openButtonWidget();
		Assert.assertTrue(button.ID_106546());
	}
	
	@Test(description = "106547")
	public void TC_ID_106547() {
		button = homePage.openButtonWidget();
		Assert.assertTrue(button.ID_106547());
	}
	
	@Test(description = "106548")
	public void TC_ID_106548() {
		button = homePage.openButtonWidget();
		Assert.assertTrue(button.ID_106548());
	}
	
	@Test(description = "106549")
	public void TC_ID_106549() {
		button = homePage.openButtonWidget();
		Assert.assertTrue(button.ID_106549());
	}
	
	@Test(description = "106550")
	public void TC_ID_106550() {
		button = homePage.openButtonWidget();
		Assert.assertTrue(button.ID_106550());
	}
	
	@Test(description = "106551")
	public void TC_ID_106551() {
		button = homePage.openButtonWidget();
		Assert.assertTrue(button.ID_106551());
	}
	

}
