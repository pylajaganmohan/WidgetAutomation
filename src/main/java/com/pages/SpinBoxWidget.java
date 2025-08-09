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
	private String initialValue = "input#initialValueOptions";
	private String spinboxValue = "input.xrx-spinbox-input";
	private String inputDisabled = "input#inputDisabledOptions";
	private String min = "input#minOptions";
	private String max = "input#maxOptions";
	private String downIcon = "//span[@class='xrx-icon down-icon']/parent::a";
	private String upIcon = "//span[@class='xrx-icon up-icon']/parent::a";
	private String numberFormat = "input#numberFormatOptions";
	private String step = "input#stepOptions";

	// Constructor
	public SpinBoxWidget(Page page) {
		this.page = page;
	}

	// Getter Methods
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

		String path = "screenshot/actualSpinBoxLayouts/actual-" + layout + ".png";
		page.locator(spinBox).screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(path)));
		return path;
	}

	public String validateDefaultLayout() {
		page.locator(gearIcon).click();
		page.locator(layouts).selectOption(AppConstants.VERTICAL_LEFT);
		page.click(okButton);
		page.click(refresh);

		String path = "screenshot/actualSpinBoxLayouts/actual-horizontal-left.png";
		page.locator(spinBox).screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(path)));
		return path;
	}

	public boolean ID_106561_and_ID_106562(int num) {
		page.locator(gearIcon).click();
		page.locator(initialValue).scrollIntoViewIfNeeded();
		page.fill(initialValue, String.valueOf(num));
		page.click(okButton);
		boolean isTen = page.locator(spinboxValue).getAttribute("aria-valuenow").contentEquals(String.valueOf(num));
		page.click(refresh);
		boolean isZero = page.locator(spinboxValue).getAttribute("aria-valuenow").contentEquals("0");

		return isTen && isZero;

	}

	public boolean ID_106563() {
		page.locator(gearIcon).click();
		;
		if (!page.locator(inputDisabled).isChecked()) {
			page.click(inputDisabled);
		}

		page.click(okButton);
		return page.locator(spinboxValue).getAttribute("class").contains("xrx-readonly");

	}

	public boolean ID_106565() {
		page.click(gearIcon);
		page.locator(min).scrollIntoViewIfNeeded();
		page.fill(min, "-2");
		page.click(okButton);
		int i = 2;
		while (i > 0) {
			page.click(downIcon);
			i--;
		}
		return page.locator(spinBox).getAttribute("class").contains("min-range");
	}

	public boolean ID_106566() {
		int i = 20;
		boolean noMin = false;
		while (i > 0) {
			page.click(downIcon);
			i--;
			if (i == 1) {
				noMin = true;
			}
		}

		int j = 20;
		page.click(refresh);
		boolean noMax = false;
		while (j > 0) {
			page.click(upIcon);
			j--;
			if (j == 1) {
				noMax = true;
			}
		}

		return noMin && noMax;
	}

	public boolean ID_106567() {
		page.click(gearIcon);
		page.locator(max).scrollIntoViewIfNeeded();
		page.fill(max, "2");
		page.click(okButton);
		int i = 2;
		while (i > 0) {
			page.click(upIcon);
			i--;
		}
		return page.locator(spinBox).getAttribute("class").contains("max-range");
	}

	public boolean numberFormatting(String format) {
		page.click(gearIcon);
		page.locator(numberFormat).scrollIntoViewIfNeeded();
		page.fill(numberFormat, format);
		page.click(okButton);
		
		page.click(upIcon);
		
		switch (format) {
		case "n1":
			return page.locator(spinboxValue).inputValue().contentEquals("1.0");
		case "n2":
			return page.locator(spinboxValue).inputValue().contentEquals("1.00");
		case "n3":
			return page.locator(spinboxValue).inputValue().contentEquals("1.000");
		default:
			return false;
		}
	}
	
	public boolean ID_106571() {
		page.click(gearIcon);
		page.locator(step).scrollIntoViewIfNeeded();
		page.fill(step, "2");
		page.click(okButton);
		
		page.click(upIcon);
		return page.locator(spinboxValue).inputValue().contentEquals("2");
	}

}
