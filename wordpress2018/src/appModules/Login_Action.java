package appModules;

import org.openqa.selenium.WebDriver;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version 创建时间：2018年11月28日 下午2:10:20 
* 类说明 
*/

public class Login_Action {

	public static void login(WebDriverEngine webtest, String name, String pwd) {

		webtest.open("/wp-login.php");
		if(webtest.isElementPresent("xpath=//a[contains(.,'登出')]")) {
			webtest.click("xpath=//a[contains(.,'登出')]");
		}
		webtest.type("id=user_login", name);
		webtest.type("id=user_pass", pwd);
		webtest.click("id=wp-submit");
	}
}
