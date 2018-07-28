/**
 * 
 */
package com.flipkart.tests;

import org.testng.annotations.Test;

import com.flipkart.pages.DetailScreenTestPage;
import com.flipkart.pages.HomeScreenPage;
import com.flipkart.pages.LaunchappTestPage;
import com.flipkart.pages.MyCartScreenTest;
import com.flipkart.pages.SearchProductScreenPage;
import com.flipkart.pages.SearchscreenTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

/**
 * @author Vikash.Singh
 *         Test case execution
 */
public class TestPage extends WebDriverTestCase {
	@Test
	public void addCartTest() throws InterruptedException {
		LaunchappTestPage launchAppPage = new LaunchappTestPage();
		launchAppPage.skipAuthentication();
		HomeScreenPage homeScreen = new HomeScreenPage();
		homeScreen.productMenu();
		homeScreen.selectProduct("Electronics");
		SearchProductScreenPage searchProductScreen = new SearchProductScreenPage();
		searchProductScreen.searchProductIcon();
		searchProductScreen.searchProduct("Apple Ipad pro");
		SearchscreenTestPage searchScreenTestPage = new SearchscreenTestPage();
		searchScreenTestPage.selectSorting();
		searchScreenTestPage.waitForFilter();
		searchScreenTestPage.searchedProductDetails();
		searchScreenTestPage.selectProductByIndex(0);
		DetailScreenTestPage detailScreenTest = new DetailScreenTestPage();
		detailScreenTest.verifySelectedProduct();
		detailScreenTest.addToCart();
		detailScreenTest.goToCart();
		MyCartScreenTest myCartScreenTest = new MyCartScreenTest();
		myCartScreenTest.waitForAddPin();
		myCartScreenTest.verifyMyCart();
		myCartScreenTest.continueShopping();

	}
}