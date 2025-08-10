package com.pages;

import com.microsoft.playwright.Page;

public class ToggleSwitchWidget {

	private Page page;

	private String gearIcon = "button#config";
	private String refresh = "button#refresh";
	private String okButton = "//span[text()='OK' and @id='ui-id-1-text']/parent::button";
	private String disabledOption = "input#disabledOptions";
	private String toggleSwitch = "div.xrx-toggleswitch";
	private String toggleSwitchControl = "div.xrx-toggleswitch div#testControl";
	private String inputValue ="input#initialValueOptions";
	private String toggleSwitchSlider = "div#testControl span.ui-slider-handle";
	private String sizeOptions = "select#sizeOptions";

	public ToggleSwitchWidget(Page page) {
		this.page = page;
	}

	public boolean ID_106576() {
		page.click(gearIcon);
		if (!page.locator(disabledOption).isChecked()) {
			page.click(disabledOption);
		}
		page.click(okButton);

		return page.locator(toggleSwitchControl).getAttribute("class").contains("ui-state-disabled");
	}

	public boolean ID_106577() {
		page.click(gearIcon);
		if (!page.locator(disabledOption).isChecked()) {
			page.click(disabledOption);
		}
		page.click(okButton);

		boolean isDisabled = page.locator(toggleSwitchControl).getAttribute("class").contains("ui-state-disabled");
		page.click(refresh);

		page.click(gearIcon);

		boolean isUnchecked = !page.locator(disabledOption).isChecked();

		return isDisabled && isUnchecked;
	}
	
	public boolean ID_106578() {
		page.click(gearIcon);
		if (!page.locator(inputValue).isChecked()) {
			page.click(inputValue);
		}
		
		page.click(okButton);
		return page.locator(toggleSwitchSlider).getAttribute("style").contentEquals("right: -1px;");
		//return page.locator(toggleSwitchSlider).getAttribute("style");
	}
	
	public boolean ID_106579() {
		page.click(gearIcon);
		if (page.locator(inputValue).isChecked()) {
			page.click(inputValue);
		}
		
		page.click(okButton);
		return page.locator(toggleSwitchSlider).getAttribute("style").contentEquals("right: 59px;");
		//return page.locator(toggleSwitchSlider).getAttribute("style");
	}
	
	public boolean widgetSize(String size) {
		page.click(gearIcon);
		page.locator(sizeOptions).scrollIntoViewIfNeeded();
		page.locator(sizeOptions).selectOption("xrx-"+size);
		page.click(okButton);
			
		switch (size) {
		case "small":
			return page.locator(toggleSwitch).getAttribute("class").contains("xrx-small");
		case "medium":
			return page.locator(toggleSwitch).getAttribute("class").contains("xrx-medium");
		case "large":
			return page.locator(toggleSwitch).getAttribute("class").contains("xrx-large");
		default:
			return false;
		}
	}

}
