package appModules;

import org.openqa.selenium.WebDriver;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;
import com.webtest.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��11��28�� ����2:10:20 
* ��˵�� 
*/

public class Login_Action {

	public static void login(WebDriverEngine webtest, String name, String pwd) {

		webtest.open("/wp-login.php");
		if(webtest.isElementPresent("xpath=//a[contains(.,'�ǳ�')]")) {
			webtest.click("xpath=//a[contains(.,'�ǳ�')]");
		}
		webtest.type("id=user_login", name);
		webtest.type("id=user_pass", pwd);
		webtest.click("id=wp-submit");
	}
}
