package com.flipkart.pages;

import org.openqa.selenium.Keys;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SearchProductScreenPage
		extends
			WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "searchproductscreen.btn.search")
	private QAFWebElement searchproductscreenBtnSearch;
	@FindBy(locator = "searchproductscreen.input.search")
	private QAFWebElement searchproductscreenInputSearch;
	@FindBy(locator = "searchproductscreen.text.product")
	private QAFWebElement searchedproduct;
	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getSearchproductscreenBtnSearch() {
		return searchproductscreenBtnSearch;
	}

	public QAFWebElement getSearchproductscreenInputSearch() {
		return searchproductscreenInputSearch;
	}
	public void searchProductIcon() {
		getSearchproductscreenBtnSearch().click();

	}
	public void searchProduct(String product) {
		getSearchproductscreenInputSearch().sendKeys(product);
		searchedproduct.click();
	}

}
