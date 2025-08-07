package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.constants.AppConstants;

public class HomePageTest extends BaseTest{

	@Test
	public void HomePageTitleTest() {
		Assert.assertEquals(homePage.getTitle(), AppConstants.HOME_PAGE_TITLE);
	}
}
