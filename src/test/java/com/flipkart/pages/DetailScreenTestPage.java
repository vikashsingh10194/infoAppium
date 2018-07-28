package com.flipkart.pages;

import org.hamcrest.Matchers;
import org.testng.Reporter;

import com.flipkart.beans.ProductBean;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class DetailScreenTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "detailpage.text.name")
	private QAFWebElement detailpageTextName;
	@FindBy(locator = "detailpage.text.price")
	private QAFWebElement detailpageTextPrice;
	@FindBy(locator = "detailpage.btn.addcart")
	private QAFWebElement detailpageBtnAddcart;
	@FindBy(locator = "detailpage.btn.cart")
	private QAFWebElement detailpageBtnCart;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getDetailpageTextName() {
		return detailpageTextName;
	}

	public QAFWebElement getDetailpageTextPrice() {
		return detailpageTextPrice;
	}

	public QAFWebElement getDetailpageBtnAddcart() {
		return detailpageBtnAddcart;
	}

	public QAFWebElement getDetailpageBtnCart() {
		return detailpageBtnCart;
	}

	public void addToCart() {
		getDetailpageBtnAddcart().click();
	}
	public void goToCart() {
		getDetailpageBtnCart().click();
	}
	// Data verification from bean
	public void verifySelectedProduct() {
		String actualName = getDetailpageTextName().getText().replace(" (Gold)", "");
		String actPrice = getDetailpageTextPrice().getText().replaceAll("[,]", "");
		/* ProductBean bean= new ProductBean(); */
		String prodName = ProductBean.getProductName();
		String prodPrice = ProductBean.getProductPrice().substring(3);
		Validator.verifyThat("Verify product Name :", actualName,
				Matchers.containsString(prodName));
		Validator.verifyThat("Verify product price :", actPrice,
				Matchers.containsString(prodPrice));
		Reporter.log("Details verified successfully", true);
	}

}
