package com.base;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.pages.ActionBarWidget;
import com.pages.ButtonWidget;
import com.pages.HomePage;
import com.pages.SpinBoxWidget;
import com.pages.ToggleSwitchWidget;
import com.pages.TumblerWidget;

public class BaseTest {

	PlaywrightFactory factory;
	Page page;

	protected Properties prop;
	protected HomePage homePage;
	protected ActionBarWidget actionBarPage;
	protected ButtonWidget button;
	protected SpinBoxWidget spinBox;
	protected ToggleSwitchWidget toggle;
	protected TumblerWidget tumbler;
	
	protected SoftAssert softAssert;

	@BeforeMethod
	public void setUp() {
		factory = new PlaywrightFactory();
		prop = factory.init_prop();
		page = factory.initBrowser(prop);
		homePage = new HomePage(page);
	}
	
	@AfterMethod
	public void tearDown() {
		page.context().browser().close();
	}
	
	
}
