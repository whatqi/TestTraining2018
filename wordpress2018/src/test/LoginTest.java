package test;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;

import appModules.Login_Action;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��11��28�� ����2:04:43 
* ��¼�������� 
*/

public class LoginTest extends BaseTest{

	@Test
	public void login_success_test() {
		Login_Action.login(webtest,"admin","2i*m2I$CQlcZbQM&LLh2CAq3");
		Checker.check(webtest,"�ǳ�");
	}
	
	@Test(description="�û�������")
	public void login_fail_test() {
		Login_Action.login(webtest,"admin123","2i*m2I$CQlcZbQM&LLh2CAq3");
		Checker.check(webtest,"�ǳ�");
	}
}
