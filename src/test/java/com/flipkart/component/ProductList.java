package com.flipkart.component;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductList extends QAFWebComponent {

	public ProductList(String locator) {
		super(locator);
		
	}
	@FindBy(locator = "productlist.text.name")
	private QAFWebElement productlistTextName;
	@FindBy(locator = "productlist.text.color")
	private QAFWebElement productlistTextColor;
	@FindBy(locator = "productlist.text.price")
	private QAFWebElement productlistTextPrice;

	

	public QAFWebElement getProductlistTextName() {
		return productlistTextName;
	}

	public QAFWebElement getProductlistTextColor() {
		return productlistTextColor;
	}

	public QAFWebElement getProductlistTextPrice() {
		return productlistTextPrice;
	}

}
