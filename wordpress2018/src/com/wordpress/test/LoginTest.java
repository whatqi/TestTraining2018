package com.wordpress.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.appModules.Login_Action;
import com.wordpress.core.BaseTest;
import com.wordpress.core.Checker;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��11��28�� ����2:04:43 
* ��¼�������� 
*/

public class LoginTest extends BaseTest{
	
	Login_Action lo_action;
	Checker checker;
	
	@BeforeMethod
	public void setup() {
		lo_action = new Login_Action(webtest);
		checker = new Checker(webtest);
	}

	@Test(priority=0)
	public void login_success_test() {
		lo_action.login("admin", "VJH$zxPNT3%enjVfHX");
		
	}
	
	@Test(description="�û�������",priority=1)
	public void login_fail1_test() {
		lo_action.login("error", "VJH$zxPNT3%enjVfHX");
		checker.checktxt("����");
	}
	
	@Test(description="�û��������쳣",priority=2)
	public void login_fail2_test() {
		lo_action.login("wuwuwuwuwuwuwiwiicbiuwegfieugfiwug", "VJH$zxPNT3%enjVfHX");
		checker.checktxt("��Ч");
	}
	
	@Test(description="�û���Ϊ��",priority=3)
	public void login_fail3_test() {
		lo_action.login("", "VJH$zxPNT3%enjVfHX");
		checker.checktxt("Ϊ��");
	}
	
	@Test(description="�������",priority=4)
	public void login_fail4_test() {
		lo_action.login("admin", "%enjVfHX");
		checker.checktxt("���벻��ȷ");
	}
	
	@Test(description="���볤���쳣",priority=5)
	public void login_fail5_test() {
		lo_action.login("admin", "sdefdfwrfwrfwrfwfwrfwVJH$zxPNT3%enjVfHX");
		checker.checktxt("���벻��ȷ");
	}
	
	@Test(description="����Ϊ��",priority=6)
	public void login_fail6_test() {
		lo_action.login("admin", "");
		checker.checktxt("Ϊ��");
	}
}