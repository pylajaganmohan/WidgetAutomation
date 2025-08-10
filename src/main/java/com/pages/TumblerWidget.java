package com.pages;

import java.nio.file.Paths;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.BoundingBox;

public class TumblerWidget {

	private Page page;

	private String gearIcon = "button#config";
	private String refresh = "button#refresh";
	private String okButton = "//span[text()='OK' and @id='ui-id-4-text']/parent::button";
	private String disabledOption = "input#disabledOptions";
	private String tumblerControl = "div#testControl";
	private String tumblerCanvas = "div#testControl canvas";
	private String tumblerSpan = "div#testControl span";
	private String min = "input#minOptions";
	private String max = "input#maxOptions";
	private String showRetrunValue = "input#showReturnedValueOptions";
	private String returnValue = "div#testControlValue";
	private String initialValue = "input#initialValueOptions";
	private String orientation = "select#orientationOptions";

	public TumblerWidget(Page page) {
		this.page = page;
	}
	
	//Getter Methods
	public String getGearIcon() {
		return gearIcon;
	}
	
	public String getRefresh() {
		return refresh;
	}
	
	public String getTumblerCanvas() {
		return tumblerCanvas;
	}
	
	public String getOrientation() {
		return orientation;
	}
	
	public String getOkButton() {
		return okButton;
	}
	
	//Action Methods
	public boolean ID_106583() {
		page.click(gearIcon);
		if (!page.locator(disabledOption).isChecked()) {
			page.click(disabledOption);
		}
		page.click(okButton);

		return page.locator(tumblerControl).getAttribute("class").contains("xrx-xrxtumbler-disabled");
	}

	public boolean ID_106584() {
		page.click(gearIcon);
		if (!page.locator(disabledOption).isChecked()) {
			page.click(disabledOption);
		}
		page.click(okButton);

		boolean isDisabled = page.locator(tumblerControl).getAttribute("class").contains("xrx-xrxtumbler-disabled");
		page.click(refresh);

		page.click(gearIcon);

		boolean isUnchecked = !page.locator(disabledOption).isChecked();

		return isDisabled && isUnchecked;
	}

	public String ID_106589(String initVal) {
		page.click(gearIcon);
		page.fill(initialValue, initVal);
		if (Integer.parseInt(initVal) > 1) {
			page.fill(max, String.valueOf(Integer.parseInt(initVal) + 2));
		}
		page.click(showRetrunValue);
		page.click(okButton);

		page.waitForSelector(returnValue);

		return page.locator(returnValue).textContent();

	}
	
	public String ID_106590() {
		page.click(gearIcon);
		page.click(showRetrunValue);
		page.click(okButton);

		page.waitForSelector(returnValue);

		return page.locator(returnValue).textContent();

	}
	
	
	public String scrollToMax(String maxVal) throws InterruptedException {
		page.click(gearIcon);
		page.fill(max, maxVal);
		page.click(showRetrunValue);
		page.click(okButton);

		Locator tumbler = page.locator(tumblerCanvas);
		BoundingBox box = tumbler.boundingBox();

		if (box != null) {
			double startX = box.x + box.width - 10;
			double startY = box.y + box.height / 2;
			System.out.println(startX);
			System.out.println(startY);
			// Scroll until tumblerSpan reaches maxVal
			int attempts = 0;
			while (attempts < 15) {
				String style = page.locator(tumblerSpan).getAttribute("style");
				// System.out.println("Current style: " + style);
				if (maxVal != "") {
					if (style != null && style.contains("left: " + maxVal + "px;")) {
						break;
					}
				} else {
					if (style != null && style.contains("left: 1px;")) {
						break;
					}
				}

				page.mouse().move(startX, startY);
				page.mouse().down();
				page.mouse().move(startX - 150, startY); // drag left
				page.mouse().up();

				Thread.sleep(300); // allow transition
				attempts++;
			}
		}

		return page.locator(returnValue).textContent();

	}

	public String scrollToMin(String minVal) throws InterruptedException {
		page.click(gearIcon);
		page.fill(min, minVal);
		page.click(showRetrunValue);
		page.click(okButton);

		Locator tumbler = page.locator(tumblerCanvas);
		BoundingBox box = tumbler.boundingBox();

		if (box != null) {
			double startX = box.x + box.width - 10;
			double startY = box.y + box.height / 2;
			System.out.println(startX);
			System.out.println(startY);
			// Scroll until tumblerSpan reaches maxVal
			int attempts = 0;
			while (attempts < 15) {
				String style = page.locator(tumblerSpan).getAttribute("style");
				// System.out.println("Current style: " + style);
				if (min != "") {
					if (style != null && style.contains("left: " + min + "px;")) {
						break;
					}
				} else {
					if (style != null && page.locator(returnValue).textContent().contentEquals("0.00")) {
						break;
					}
				}

				page.mouse().move(startX - 150, startY);
				page.mouse().down();
				page.mouse().move(startX, startY); // drag right
				page.mouse().up();

				Thread.sleep(300); // allow transition
				attempts++;
			}
		}

		return page.locator(returnValue).textContent();

	}
	
	public String validateOrientation(String orient) {
		page.locator(gearIcon).click();
		page.locator(orientation).selectOption(orient);
		page.click(okButton);

		String path = "screenshot/actualImages/actual-tumbler-" + orient + ".png";
		page.locator(tumblerCanvas).screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(path)));
		return path;
	}

}
