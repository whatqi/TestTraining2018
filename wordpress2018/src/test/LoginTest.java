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

	@Test(priority=0)
	public void login_success_test() {
		Login_Action.login(webtest,"admin","2i*m2I$CQlcZbQM&LLh2CAq3");
		Checker.checktxt(webtest,"登出");
	}
	
	@Test(description="用户名错误")
	public void login_fail1_test() {
		Login_Action.login(webtest,"admin123","2i*m2I$CQlcZbQM&LLh2CAq3");
		Checker.checktxt(webtest,"错误");
	}
	
	@Test(description="用户名长度异常")
	public void login_fail2_test() {
		Login_Action.login(webtest,"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","2i*m2I$CQlcZbQM&LLh2CAq3");
		Checker.checktxt(webtest,"无效");
	}
	
	@Test(description="用户名为空")
	public void login_fail3_test() {
		Login_Action.login(webtest,"","2i*m2I$CQlcZbQM&LLh2CAq3");
		Checker.checktxt(webtest,"为空");
	}
	
	@Test(description="密码错误")
	public void login_fail4_test() {
		Login_Action.login(webtest,"admin","admin");
		Checker.checktxt(webtest,"密码不正确");
	}
	
	@Test(description="密码长度异常")
	public void login_fail5_test() {
		Login_Action.login(webtest,"admin","ksksksdhfiefwbeiutwehfwoeutyef");
		Checker.checktxt(webtest,"密码不正确");
	}
	
	@Test(description="密码为空")
	public void login_fail6_test() {
		Login_Action.login(webtest,"admin","");
		Checker.checktxt(webtest,"为空");
	}
}
