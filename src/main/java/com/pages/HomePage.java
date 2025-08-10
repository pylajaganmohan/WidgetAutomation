package com.pages;

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
		private String spinBox = "//button[text()='Spin Box']";
		private String toggleSwitch = "//button[text()='Toggle Switch']";
		private String tumbler = "//button[text()='Tumbler']";
		
		public HomePage(Page page) {
			this.page = page;
		}
		
		public String getTitle() {
			return page.textContent(title);
		}
		
		//Widget Navigations
		public ActionBarWidget openActionBar() {
			page.click(actionBar);
			return new ActionBarWidget(page);
		}
		
		public ButtonWidget openButtonWidget() {
			page.click(button);
			return new ButtonWidget(page);
		}
		
		public SpinBoxWidget openSpinBoxWidget() {
			page.click(spinBox);
			return new SpinBoxWidget(page);
		}
		
		public ToggleSwitchWidget openToggleSwitchWidget() {
			page.click(toggleSwitch);
			return new ToggleSwitchWidget(page);
		}
		
		public TumblerWidget openTumblerWidget() {
			page.click(tumbler);
			return new TumblerWidget(page);
		}
		
		//Test Actions
		public boolean ID_106552() {
			return page.locator(spinBox).isVisible();
		}
		
		public boolean ID_106575() {
			return page.locator(toggleSwitch).isVisible();
		}
		
		public boolean ID_106582() {
			return page.locator(tumbler).isVisible();
		}
		
		
		
		
		
}
