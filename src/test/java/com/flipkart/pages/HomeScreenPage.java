/**
 * 
 */
package com.flipkart.pages;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * @author Vikash.Singh
 */
public class HomeScreenPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	@FindBy(locator = "homescreen.btn.drawer")
	private QAFWebElement homescreenBtnDrawer;
	@FindBy(locator = "homescreen.btn.electronics")
	private QAFWebElement homescreenBtnElectronics;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getHomescreenBtnDrawer() {
		return homescreenBtnDrawer;
	}

	public QAFWebElement getHomescreenBtnElectronics() {
		return homescreenBtnElectronics;
	}
	public void productMenu() {
		getHomescreenBtnDrawer().click();

	}
	//Selecting product category wise
	public void selectProduct(String category) {
		QAFExtendedWebElement categoryElement = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("homescreen.btn.electronics"), category));
		categoryElement.click();
	}

}
