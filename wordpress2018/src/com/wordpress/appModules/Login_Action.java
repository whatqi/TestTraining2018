package com.wordpress.appModules;

import org.openqa.selenium.WebDriver;

import com.wordpress.core.BaseTest;
import com.wordpress.core.Checker;
import com.wordpress.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version 创建时间：2018年11月28日 下午2:10:20 
* 类说明 
*/

public class Login_Action {

	private WebDriverEngine webtest;
	
	public Login_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	public void login(String name, String pwd) {

		webtest.open("/wp-login.php");
		if(webtest.isElementPresent("xpath=//a[contains(.,'登出')]")) {
			webtest.click("xpath=//a[contains(.,'登出')]");
		}
		webtest.type("id=user_login", name);
		webtest.type("id=user_pass", pwd);
		webtest.click("id=wp-submit");
	}
}
