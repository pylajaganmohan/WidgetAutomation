package com.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	ThreadLocal<Playwright> playwright = new ThreadLocal<Playwright>();
	ThreadLocal<Browser> browser = new ThreadLocal<Browser>();
	ThreadLocal<BrowserContext> context = new ThreadLocal<BrowserContext>();
	ThreadLocal<Page> page = new ThreadLocal<Page>();
	Properties prop;

	public Playwright getPlaywright() {
		return playwright.get();
	}

	public Browser getBrowser() {
		return browser.get();
	}

	public BrowserContext getContext() {
		return context.get();
	}

	public Page getPage() {
		return page.get();
	}

	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		playwright.set(Playwright.create());

		switch (browserName.toLowerCase()) {
		case "chromium":
			browser.set(getPlaywright().chromium()
					.launch(new LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--window-size=1024,600"))));
			break;
		case "firefox":
			browser.set(getPlaywright().firefox()
					.launch(new LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--window-size=1024,600"))));
			break;
		case "webkit":
			browser.set(getPlaywright().webkit()
					.launch(new LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--window-size=1024,600"))));
			break;
		case "chrome":
			browser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false)
					.setArgs(Arrays.asList("--window-size=1024,600"))));
			break;
		case "edge":
			browser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false)
					.setArgs(Arrays.asList("--window-size=1024,600"))));
			break;
		default:
			System.out.println("invalid browser......");
			break;
		}

		context.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(1024, 600)));
		page.set(getContext().newPage());
		System.out.println("http://" + prop.getProperty("serverIp") + prop.getProperty("url"));
		getPage().navigate("http://" + prop.getProperty("serverIp") + prop.getProperty("url"));
		return getPage();
	}

	public Properties init_prop() {
		try {
			FileInputStream fi = new FileInputStream("./src/test/resources/config.properties");
			prop = new Properties();
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}
}
