package com.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.constants.AppConstants;
import com.utilities.ImageComparator;

@Listeners(com.listeners.ExtentReportListener.class)
public class SpinBoxTest extends BaseTest{
	
	@Test(description = "106553")
	public void TC_ID_106553() {
		spinBox = homePage.openSpinBoxWidget();
		Assert.assertTrue(spinBox.ID_106553());
	}
	
	@Test(description = "106554")
	public void TC_ID_106554() {
		spinBox = homePage.openSpinBoxWidget();
		Assert.assertTrue(spinBox.ID_106554());
	}
	
	@Test(description = "106555")
	public void TC_ID_106555() {
		spinBox = homePage.openSpinBoxWidget();
		boolean isSame = false;
		try {
			isSame = ImageComparator.compareImages(spinBox.validateLayout(AppConstants.HORIZONTAL_LEFT), AppConstants.SPINBOX_HORIZONTAL_LEFT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(isSame);
	}
	
	@Test(description = "106556")
	public void TC_ID_106556() {
		spinBox = homePage.openSpinBoxWidget();
		boolean isSame = false;
		try {
			isSame = ImageComparator.compareImages(spinBox.validateLayout(AppConstants.VERTICAL_LEFT), AppConstants.SPINBOX_VERTICAL_LEFT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(isSame);
	}
	
	@Test(description = "106557")
	public void TC_ID_106557() {
		spinBox = homePage.openSpinBoxWidget();
		boolean isSame = false;
		try {
			isSame = ImageComparator.compareImages(spinBox.validateLayout(AppConstants.VERTICAL_TOP), AppConstants.SPINBOX_VERTICAL_TOP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(isSame);
	}
	
	@Test(description = "106558")
	public void TC_ID_106558() {
		spinBox = homePage.openSpinBoxWidget();
		boolean isSame = false;
		try {
			isSame = ImageComparator.compareImages(spinBox.validateDefaultLayout(), AppConstants.SPINBOX_HORIZONTAL_LEFT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(isSame);
	}
	
	
	
}
