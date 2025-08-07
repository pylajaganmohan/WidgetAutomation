package com.pages;

import com.microsoft.playwright.Page;

public class ActionBarWidget {

	private Page page;
	
	private String actionBar = "div.xrx-action-bar-label-container";
	private String title = "//div[@id='testAreaContainer']/div/span";
	private String gearIcon = "//div[@id='testAreaContainer']/div/button[@id='config']";
	private String refresh = "//div[@id='testAreaContainer']/div/button[@id='refresh']";
	private String home = "//div[@id='testAreaContainer']/div/button[@id='home']";

	public ActionBarWidget(Page page) {
		this.page = page;
	}

	public String getTitle() {
		return page.textContent(title);
	}

	public void clickGearIcon() {
		page.click(gearIcon);
	}

	public void refreshPage() {
		page.click(refresh);
	}

	public HomePage gotoHomePage() {
		page.click(home);
		return new HomePage(page);
	}
	
	public String getColor() {
		String backgroundColor = page.locator(actionBar).evaluate("\"el => getComputedStyle(el).backgroundColor\"").toString();
		return backgroundColor;
	}
}
