package com.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
	
		private Page page;
		
		private String title = "//div[@id='action_bar']/div[@class='xrx-action-bar-label line-one']";
		private String actionBar = "//button[text()='Action Bar']";
		private String activityIndicator = "//button[text()='Activity Indicator']";
		private String alert = "//button[text()='Alert']";
		private String banner = "//button[text()='Banner']";
		private String boundingBox = "//button[text()='Bounding Box']";
		private String button = "//button[text()='Button']";
		private String AlternateLayoutBtn = "//button[text()='Alternative Layout Button']";
		private String carousel= "//button[text()='Carousel']";
		private String keyboradOrPad= "//button[text()='Keyboard/ pad']";
		private String levelIndicator= "//button[text()='Level Indicator']";
		
		public HomePage(Page page) {
			this.page = page;
		}
		
		public String getTitle() {
			return page.textContent(title);
		}
		
		public ActionBarWidget openActionBar() {
//			Locator locator = page.locator(actionBar);
//			String backgroundColor = (String) locator.evaluate("el => getComputedStyle(el).backgroundColor");
//			System.out.println("Button color: " + backgroundColor);
			page.click(actionBar);
			return new ActionBarWidget(page);
		}
		
		
		
		
		
}
