package com.flipkart.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class LaunchappTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "launch.btn.skip")
	private QAFWebElement launchBtnSkip;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getLaunchBtnSkip() {
		return launchBtnSkip;
	}

	public void skipAuthentication() throws InterruptedException {
		getLaunchBtnSkip().click();
		Thread.sleep(1000);
	}

}
