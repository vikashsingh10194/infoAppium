package com.flipkart.pages;

import org.hamcrest.Matchers;
import org.testng.Reporter;

import com.flipkart.beans.ProductBean;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
// import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class MyCartScreenTest extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "mycart.btn.add")
	private QAFWebElement mycartBtnAdd;
	@FindBy(locator = "mycart.btn.continue")
	private QAFWebElement mycartBtnContinue;
	@FindBy(locator = "mycart.text.name")
	private QAFWebElement mycartTextName;
	@FindBy(locator = "mycart.text.price")
	private QAFWebElement mycartTextPrice;
	@FindBy(locator = "mycart.text.color")
	private QAFWebElement myCartColor;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getMycartBtnAdd() {
		return mycartBtnAdd;
	}

	public QAFWebElement getMycartBtnContinue() {
		return mycartBtnContinue;
	}

	public QAFWebElement getMycartTextName() {
		return mycartTextName;
	}
	public QAFWebElement getMyCartColor() {
		return myCartColor;
	}

	public QAFWebElement getMycartTextPrice() {
		return mycartTextPrice;
	}

	public void waitForAddPin() {
		getMycartBtnAdd().waitForPresent(null);
	}

	public void continueShopping() {
		getMycartBtnContinue().click();
		System.out.println("continue clicked");
	}
	// My cart data verrification
	public void verifyMyCart() throws InterruptedException {
		System.out.println("=================mycart =================");
		Thread.sleep(4000);
		String actualName = getMycartTextName().getAttribute("name");
		String actualPrice =
				getMycartTextPrice().getAttribute("name").replaceAll("[,]", "").substring(1);
		String actualColor = getMyCartColor().getAttribute("name");
		String prodName = ProductBean.getProductName();
		String prodPrice = ProductBean.getProductPrice().substring(3);
		String prodColor = ProductBean.getProductColor();
		Validator.verifyThat("Verify product Name :", actualName,
				Matchers.containsString(prodName));
		Validator.verifyThat("Verify product color :", actualColor,
				Matchers.containsString(prodColor));
		Validator.verifyThat("Verify product price :", actualPrice,
				Matchers.containsString(prodPrice));
		Reporter.log("My cart is verified successfully", true);
	}

}
