package com.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.pages.ActionBarWidget;
import com.pages.HomePage;

public class BaseTest {

	PlaywrightFactory factory;
	Page page;

	protected Properties prop;
	protected HomePage homePage;
	protected ActionBarWidget actionBarPage;

	@BeforeTest
	public void setUp() {
		factory = new PlaywrightFactory();
		prop = factory.init_prop();
		page = factory.initBrowser(prop);
		homePage = new HomePage(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	
	
}
