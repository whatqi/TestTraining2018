package demo;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��11��19�� ����4:20:13 
* ��˵�� 
*/

public class wordpress_login_test extends BaseTest{
	String login_url = "/wp-login.php";
	
	@Test
	public void login() {
		webtest.open(login_url);
		
	}
	
}
