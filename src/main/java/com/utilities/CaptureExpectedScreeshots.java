package com.utilities;

import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.AppConstants;
import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.pages.HomePage;
import com.pages.SpinBoxWidget;
import com.pages.TumblerWidget;

public class CaptureExpectedScreeshots {
	PlaywrightFactory factory;
	Properties prop;
	Page page;

	HomePage homePage;
	SpinBoxWidget spinBox;
	TumblerWidget tumbler;

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
				.setPath(Paths.get(AppConstants.SPINBOX_HORIZONTAL_LEFT)));
		page.click(spinBox.getRefresh());

		// horizontal-top
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("horizontal-top");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get(AppConstants.SPINBOX_HORIZONTAL_TOP)));
		page.click(spinBox.getRefresh());

		// vertical-left
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("vertical-left");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get(AppConstants.SPINBOX_VERTICAL_LEFT)));
		page.click(spinBox.getRefresh());

		// vertical-top
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("vertical-top");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get(AppConstants.SPINBOX_VERTICAL_TOP)));
		page.click(spinBox.getRefresh());

		// horizontalarrow-left
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("horizontalarrow-left");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get(AppConstants.SPINBOX_HORIZONTALARROW_LEFT)));
		page.click(spinBox.getRefresh());

		// horizontalarrow-top
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("horizontalarrow-top");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get(AppConstants.SPINBOX_HORIZONTALARROW_TOP)));
		page.click(spinBox.getRefresh());

		// verticalarrow-left
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("verticalarrow-left");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get(AppConstants.SPINBOX_VERTICALARROW_LEFT)));
		page.click(spinBox.getRefresh());

		// verticalarrow-top
		page.locator(spinBox.getGearIcon()).click();
		page.locator(spinBox.getLayouts()).selectOption("verticalarrow-top");
		page.click(spinBox.getOkButton());
		page.locator(spinBox.getSpinBox()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get(AppConstants.SPINBOX_VERTICALARROW_TOP)));
		page.click(spinBox.getRefresh());

	}
	
	@Test
	public void TumblerOrientation() {
		tumbler = homePage.openTumblerWidget();
		//Vertical
		page.locator(tumbler.getGearIcon()).click();
		page.locator(tumbler.getOrientation()).selectOption(AppConstants.ORIENTATION_VERTICAL);
		page.click(tumbler.getOkButton());
		page.locator(tumbler.getTumblerCanvas()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get(AppConstants.TUMBLER_VERTICAL)));
		page.click(spinBox.getRefresh());
		
		//Horizontal
		page.locator(tumbler.getGearIcon()).click();
		page.locator(tumbler.getOrientation()).selectOption(AppConstants.ORIENTATION_HORIZONTAL);
		page.click(tumbler.getOkButton());
		page.locator(tumbler.getTumblerCanvas()).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get(AppConstants.TUMBLER_HORIZONTAL)));
		page.click(spinBox.getRefresh());
	}

}
