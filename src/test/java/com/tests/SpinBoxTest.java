package com.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTest;
import com.constants.AppConstants;
import com.utilities.ImageComparator;

@Listeners(com.listeners.ExtentReportListener.class)
public class SpinBoxTest extends BaseTest {

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
			isSame = ImageComparator.compareImages(spinBox.validateLayout(AppConstants.HORIZONTAL_LEFT),
					AppConstants.SPINBOX_HORIZONTAL_LEFT);
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
			isSame = ImageComparator.compareImages(spinBox.validateLayout(AppConstants.VERTICAL_LEFT),
					AppConstants.SPINBOX_VERTICAL_LEFT);
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
			isSame = ImageComparator.compareImages(spinBox.validateLayout(AppConstants.VERTICAL_TOP),
					AppConstants.SPINBOX_VERTICAL_TOP);
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
			isSame = ImageComparator.compareImages(spinBox.validateDefaultLayout(),
					AppConstants.SPINBOX_HORIZONTAL_LEFT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(isSame);
	}

	@Test(description = "106559")
	public void TC_ID_106559() {
		spinBox = homePage.openSpinBoxWidget();
		boolean isSame = false;
		try {
			isSame = ImageComparator.compareImages(spinBox.validateLayout(AppConstants.VERTICAL_TOP),
					AppConstants.SPINBOX_VERTICAL_TOP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(isSame);
	}

	@Test(description = "106560")
	public void TC_ID_106560() {
		spinBox = homePage.openSpinBoxWidget();
		boolean isSame = false;
		try {
			isSame = ImageComparator.compareImages(spinBox.validateLayout(AppConstants.HORIZONTALARROW_LEFT),
					AppConstants.SPINBOX_HORIZONTALARROW_LEFT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(isSame);
	}

	@Test(description = "106561")
	public void TC_ID_106561() {
		spinBox = homePage.openSpinBoxWidget();
		Assert.assertTrue(spinBox.ID_106561_and_ID_106562(10));
	}

	@Test(description = "106562")
	public void TC_ID_106562() {
		spinBox = homePage.openSpinBoxWidget();
		Assert.assertTrue(spinBox.ID_106561_and_ID_106562(10));
	}

	@Test(description = "106563")
	public void TC_ID_106563() {
		spinBox = homePage.openSpinBoxWidget();
		Assert.assertTrue(spinBox.ID_106563());
	}

	@Test(description = "106564")
	public void TC_ID_106564() {
		spinBox = homePage.openSpinBoxWidget();
		Assert.assertTrue(spinBox.ID_106561_and_ID_106562(10));
	}

	@Test(description = "106565")
	public void TC_ID_106565() {
		spinBox = homePage.openSpinBoxWidget();
		Assert.assertTrue(spinBox.ID_106565());
	}

	@Test(description = "106566")
	public void TC_ID_106566() {
		spinBox = homePage.openSpinBoxWidget();
		Assert.assertTrue(spinBox.ID_106566());
	}
	
	@Test(description = "106567")
	public void TC_ID_106567() {
		spinBox = homePage.openSpinBoxWidget();
		Assert.assertTrue(spinBox.ID_106567());
	}
	
	@Test(description = "106568")
	public void TC_ID_106568() {
		spinBox = homePage.openSpinBoxWidget();
		Assert.assertTrue(spinBox.ID_106566());
	}
	
	@Test(description = "106569")
	public void TC_ID_106569() {
		spinBox = homePage.openSpinBoxWidget();
		softAssert = new SoftAssert();
		softAssert.assertTrue(spinBox.numberFormatting("n1"));
		softAssert.assertTrue(spinBox.numberFormatting("n2"));
		softAssert.assertTrue(spinBox.numberFormatting("n3"));
		softAssert.assertAll();
	}
	
	@Test(description = "106571")
	public void TC_ID_106571() {
		spinBox = homePage.openSpinBoxWidget();
		Assert.assertTrue(spinBox.ID_106571());
	}

}
