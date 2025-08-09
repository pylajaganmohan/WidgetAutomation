package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class ButtonWidget {

	private Page page;

	private String button = "button#testControl";
	private String buttonText = "button#testControl span.xrx-button-text";
	private String buttonCustomIcon = "button#testControl span.xrx-button-icon.cap_on_48";
	private String buttonGlyphIcon = "button#testControl span#testControl-glyph";
	private String gearIcon = "button#config";
	private String refresh = "button#refresh";
	private String home = "button#home";
	private String icons = "select#iconsOptions";
	private String textCheckBox = "input#textOptions.checkbox";
	private String okButton = "//span[text()='OK' and @id='ui-id-1-text']/parent::button";
	private String disabledOption = "input#disabledOptions";
	private String widgetSize = "select#sizeOptions";
	private String toggleOption = "input#toggleOptions";
	private String borderless ="input#borderlessOptions";

	public ButtonWidget(Page page) {
		this.page = page;
	}

	public void clickOnGear() {
		page.click(gearIcon);
	}

	public void refresh() {
		page.click(refresh);
	}

	public HomePage gotoHomePage() {
		page.click(home);
		return new HomePage(page);
	}

	public boolean isButtonVisible() {
		return page.isVisible(button) && page.textContent(buttonText).contentEquals("Default");
	}

	public boolean ID_106540() {
		page.click(gearIcon);
		if (!page.locator(textCheckBox).isChecked()) {
			page.click(textCheckBox);
		}
		page.locator(icons).scrollIntoViewIfNeeded();
		page.waitForSelector(icons);

		page.locator(icons).selectOption("none");
		page.click(okButton);
		boolean text = page.textContent(buttonText).contentEquals("A");
		return text;

	}

	public boolean ID_106541() {
		page.click(refresh);
		boolean text = page.textContent(buttonText).contentEquals("Default");
		return text;
	}

	public boolean ID_106542() {
		page.click(gearIcon);
		if (!page.locator(textCheckBox).isChecked()) {
			page.click(textCheckBox);
		}
		page.locator(icons).scrollIntoViewIfNeeded();
		page.waitForSelector(icons);

		page.locator(icons).selectOption("custom");
		page.click(okButton);
		boolean text = page.isVisible(buttonCustomIcon) && page.isVisible(buttonText);
		return text;
	}

	public boolean ID_106543() {
		page.click(gearIcon);
		if (!page.locator(textCheckBox).isChecked()) {
			page.click(textCheckBox);
		}
		page.locator(icons).scrollIntoViewIfNeeded();
		page.waitForSelector(icons);

		page.locator(icons).selectOption("glyph");
		page.click(okButton);
		boolean text = page.isVisible(buttonGlyphIcon) && page.isVisible(buttonText);
		return text;
	}

	public boolean ID_106544() {
		page.click(gearIcon);
		if (page.locator(textCheckBox).isChecked()) {
			page.click(textCheckBox);
		}
		page.locator(icons).scrollIntoViewIfNeeded();
		page.waitForSelector(icons);

		page.locator(icons).selectOption("custom");
		page.click(okButton);
		boolean text = page.isVisible(buttonCustomIcon) && !page.isVisible(buttonText);
		return text;
	}

	public boolean ID_106545() {
		page.click(gearIcon);
		if (page.locator(textCheckBox).isChecked()) {
			page.click(textCheckBox);
		}
		page.locator(icons).scrollIntoViewIfNeeded();
		page.waitForSelector(icons);

		page.locator(icons).selectOption("glyph");
		page.click(okButton);
		boolean text = page.isVisible(buttonGlyphIcon) && !page.isVisible(buttonText);
		return text;
	}

	public boolean ID_106546() {
		page.click(gearIcon);
		page.locator(disabledOption).scrollIntoViewIfNeeded();
		page.click(disabledOption);
		page.click(okButton);
		return page.locator(button).isDisabled();
	}

	public boolean ID_106547() {
		page.click(gearIcon);
		page.locator(disabledOption).scrollIntoViewIfNeeded();
		page.click(disabledOption);
		page.click(okButton);
		boolean isDiabled = page.locator(button).isDisabled();
		page.click(refresh);
		return page.isEnabled(button) && isDiabled;
	}

	public boolean ID_106548() {
		page.click(gearIcon);
		page.locator(widgetSize).selectOption("xrx-small");
		page.click(okButton);
		return page.locator(button).getAttribute("class").contains("xrx-small");
	}

	public boolean ID_106549() {
		page.click(gearIcon);
		page.locator(widgetSize).selectOption("xrx-small");
		page.click(okButton);
		boolean isSizeChanged = page.locator(button).getAttribute("class").contains("xrx-small");
		page.click(refresh);
		boolean text = page.textContent(buttonText).contentEquals("Default");
		return text && isSizeChanged;
	}
	
	public boolean ID_106550() {
		page.click(gearIcon);
		page.locator(toggleOption).scrollIntoViewIfNeeded();
		page.locator(toggleOption).click();
		page.click(okButton);
		
		while(!page.textContent(buttonText).contains("Normal")) {
			page.click(button);
		}
		
		return page.textContent(buttonText).contains("Normal");
	}
	
	public boolean ID_106551() {
		page.click(gearIcon);
		page.locator(borderless).scrollIntoViewIfNeeded();
		page.click(borderless);
		page.click(okButton);
		return page.locator(button).getAttribute("class").contains("borderless");
	}

}
