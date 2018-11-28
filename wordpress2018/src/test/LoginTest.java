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

	@Test(priority=0)
	public void login_success_test() {
		Login_Action.login(webtest,"admin","2i*m2I$CQlcZbQM&LLh2CAq3");
		Checker.checktxt(webtest,"�ǳ�");
	}
	
	@Test(description="�û�������")
	public void login_fail1_test() {
		Login_Action.login(webtest,"admin123","2i*m2I$CQlcZbQM&LLh2CAq3");
		Checker.checktxt(webtest,"����");
	}
	
	@Test(description="�û��������쳣")
	public void login_fail2_test() {
		Login_Action.login(webtest,"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","2i*m2I$CQlcZbQM&LLh2CAq3");
		Checker.checktxt(webtest,"��Ч");
	}
	
	@Test(description="�û���Ϊ��")
	public void login_fail3_test() {
		Login_Action.login(webtest,"","2i*m2I$CQlcZbQM&LLh2CAq3");
		Checker.checktxt(webtest,"Ϊ��");
	}
	
	@Test(description="�������")
	public void login_fail4_test() {
		Login_Action.login(webtest,"admin","admin");
		Checker.checktxt(webtest,"���벻��ȷ");
	}
	
	@Test(description="���볤���쳣")
	public void login_fail5_test() {
		Login_Action.login(webtest,"admin","ksksksdhfiefwbeiutwehfwoeutyef");
		Checker.checktxt(webtest,"���벻��ȷ");
	}
	
	@Test(description="����Ϊ��")
	public void login_fail6_test() {
		Login_Action.login(webtest,"admin","");
		Checker.checktxt(webtest,"Ϊ��");
	}
}
