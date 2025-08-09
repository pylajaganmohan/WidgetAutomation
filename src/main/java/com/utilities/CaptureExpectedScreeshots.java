package com.utilities;

import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.pages.HomePage;
import com.pages.SpinBoxWidget;

public class CaptureExpectedScreeshots {
	PlaywrightFactory factory;
	Properties prop;
	Page page;

	HomePage homePage;
	SpinBoxWidget spinBox;

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

	@Test
	public void SpinBoxLayouts() {
		spinBox = homePage.openSpinBoxWidget();
		// horizontal-left
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("horizontal-left");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("screenshot/expectedSpinBoxLayouts/expected-horizontal-left.png")));
		page.click(spinBox.getRefresh());

		// horizontal-top
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("horizontal-top");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("screenshot/expectedSpinBoxLayouts/expected-horizontal-top.png")));
		page.click(spinBox.getRefresh());

		// vertical-left
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("vertical-left");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("screenshot/expectedSpinBoxLayouts/expected-vertical-left.png")));
		page.click(spinBox.getRefresh());

		// vertical-top
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("vertical-top");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("screenshot/expectedSpinBoxLayouts/expected-vertical-top.png")));
		page.click(spinBox.getRefresh());

		// horizontalarrow-left
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("horizontalarrow-left");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("screenshot/expectedSpinBoxLayouts/expected-horizontalarrow-left.png")));
		page.click(spinBox.getRefresh());

		// horizontalarrow-top
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("horizontalarrow-top");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("screenshot/expectedSpinBoxLayouts/expected-horizontalarrow-top.png")));
		page.click(spinBox.getRefresh());

		// verticalarrow-left
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("verticalarrow-left");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("screenshot/expectedSpinBoxLayouts/expected-verticalarrow-left.png")));
		page.click(spinBox.getRefresh());

		// verticalarrow-top
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("verticalarrow-top");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("screenshot/expectedSpinBoxLayouts/expected-verticalarrow-top.png")));
		page.click(spinBox.getRefresh());

	}

}
