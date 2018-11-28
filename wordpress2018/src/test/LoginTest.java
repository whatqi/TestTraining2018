package test;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;

import appModules.Login_Action;

/** 
* author:shenmengqi 
* @version 创建时间：2018年11月28日 下午2:04:43 
* 登录测试用例 
*/

public class LoginTest extends BaseTest{

	@Test
	public void login_success_test() {
		Login_Action.login(webtest,"admin","2i*m2I$CQlcZbQM&LLh2CAq3");
		Checker.check(webtest,"登出");
	}
	
	@Test(description="用户名错误")
	public void login_fail_test() {
		Login_Action.login(webtest,"admin123","2i*m2I$CQlcZbQM&LLh2CAq3");
		Checker.check(webtest,"登出");
	}
}
