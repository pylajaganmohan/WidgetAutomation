package com.pages;

import java.nio.file.Paths;

import com.constants.AppConstants;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SpinBoxWidget {

	private Page page;

	private String gearIcon = "button#config";
	private String refresh = "button#refresh";
	private String home = "button#home";
	private String okButton = "//span[text()='OK' and @id='ui-id-1-text']/parent::button";
	private String disabledOption = "input#disabledOptions";
	private String spinBox = "span.xrx-spinbox";
	private String layouts = "select#layoutTypeOptions";

	//Constructor
	public SpinBoxWidget(Page page) {
		this.page = page;
	}
	
	//Getter Methods
	public String getGearIcon() {
		return gearIcon;
	}
	
	public String getOkButton() {
		return okButton;
	}
	
	public String getSpinBox() {
		return spinBox;
	}
	
	public String getRefresh() {
		return refresh;
	}
	
	public String getLayouts() {
		return layouts;
	}
	
	// Action Methods	
	public boolean ID_106553() {
		page.click(gearIcon);
		if (!page.locator(disabledOption).isChecked()) {
			page.click(disabledOption);
		}
		page.click(okButton);

		return page.locator(spinBox).getAttribute("class").contains("ui-state-disabled");
	}

	public boolean ID_106554() {
		page.click(gearIcon);
		if (!page.locator(disabledOption).isChecked()) {
			page.click(disabledOption);
		}
		page.click(okButton);
		boolean disabled = page.locator(spinBox).getAttribute("class").contains("ui-state-disabled");
		page.click(refresh);
		boolean enabled = !page.locator(spinBox).getAttribute("class").contains("ui-state-disabled");

		return disabled && enabled;
	}
	
	public String validateLayout(String layout) {
		page.locator(gearIcon).click();
		page.locator(layouts).selectOption(layout);
		page.click(okButton);
		
		String path = "screenshot/actualSpinBoxLayouts/actual-"+layout+".png";
		page.locator(spinBox).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get(path)));
		return path;
	}
	
	public String validateDefaultLayout() {
		page.locator(gearIcon).click();
		page.locator(layouts).selectOption(AppConstants.VERTICAL_LEFT);
		page.click(okButton);
		page.click(refresh);
		
		String path = "screenshot/actualSpinBoxLayouts/actual-horizontal-left.png";
		page.locator(spinBox).screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get(path)));
		return path;
	}
	
	
}
