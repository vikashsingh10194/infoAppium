package com.flipkart.pages;

import java.util.List;

import org.testng.Reporter;

import com.flipkart.beans.ProductBean;
import com.flipkart.component.ProductList;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SearchscreenTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "searchscreen.list.product")
	private List<ProductList> searchscreenListProduct;
	@FindBy(locator = "searchscreen.btn.filter")
	private QAFWebElement filterButton;
	@FindBy(locator = "searchscreen.btn.display")
	private QAFWebElement displayButton;
	@FindBy(locator = "searchscreen.btn.product")
	private QAFWebElement productButton;
	@FindBy(locator = "searchscreen.btn.apply")
	private QAFWebElement applyButton;
	@FindBy(locator = "searchscreen.btn.sorting")
	private QAFWebElement sortButton;
	@FindBy(locator = "searchscreen.btn.lowhigh")
	private QAFWebElement lowHighButton;
	public QAFWebElement getFilterButton() {
		return filterButton;
	}

	public QAFWebElement getDisplayButton() {
		return displayButton;
	}

	public QAFWebElement getProductButton() {
		return productButton;
	}

	public QAFWebElement getApplyButton() {
		return applyButton;
	}

	public QAFWebElement getSortButton() {
		return sortButton;
	}

	public QAFWebElement getLowHighButton() {
		return lowHighButton;
	}

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<ProductList> getSearchscreenListProduct() {
		return searchscreenListProduct;
	}
	// All matching product as per search query
	public void searchedProductDetails() {

		int i = searchscreenListProduct.size();
		Reporter.log("Matching product found is   " + searchscreenListProduct.size());

		for (ProductList product : searchscreenListProduct) {

			Reporter.log("Searched product name is  "
					+ product.getProductlistTextName().getText(), true);
			Reporter.log("Searched product price is  "
					+ product.getProductlistTextPrice().getText(), true);
			Reporter.log("Searched product color is   "
					+ product.getProductlistTextColor().getText(), true);

		}

	}
	public void selectSorting() {
		// productButton.click();
		getSortButton().click();
		getLowHighButton().verifyVisible();
		getLowHighButton().click();

	}
	// Wait for filter button after applying price sorting
	public void waitForFilter() {
		getFilterButton().waitForPresent();
	}

	public ProductBean selectProductByIndex(int product) {
		ProductList productList = searchscreenListProduct.get(product);
		Reporter.log("Setting bean through component element ", true);
		String pName = productList.getProductlistTextName().getText();
		String pColor = productList.getProductlistTextColor().getText();
		String pPrice = productList.getProductlistTextPrice().getText();
		ProductBean productBean = new ProductBean();
		productBean.setProductName(pName);
		productBean.setProductColor(pColor);
		productBean.setProductPrice(pPrice);
		productList.getProductlistTextName().click();
		Reporter.log("Selected product is  " + pName, true);
		return productBean;

	}

}
