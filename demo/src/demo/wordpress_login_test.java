package demo;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version 创建时间：2018年11月19日 下午4:20:13 
* 类说明 
*/

public class wordpress_login_test extends BaseTest{
	String login_url = "/wp-login.php";
	
	@Test
	public void login() {
		webtest.open(login_url);
		
	}
	
}
