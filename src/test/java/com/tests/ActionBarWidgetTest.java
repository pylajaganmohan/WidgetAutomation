package com.tests;

import org.testng.annotations.Test;

import com.base.BaseTest;

public class ActionBarWidgetTest extends BaseTest{

	@Test
	public void validateBackGroundColor() {
		actionBarPage = homePage.openActionBar();
		System.out.println(actionBarPage.getColor());
	}
}
