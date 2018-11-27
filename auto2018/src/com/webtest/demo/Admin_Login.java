package com.webtest.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Admin_Login extends BaseTest{
	
	@Test(description="��̨����Ա��½�ɹ�")
	public void testlogin() {
		webtest.open("/admin.php/Login/index.html");
		
		webtest.type("name=username","admin");
		webtest.type("name=password","admin");
		
		webtest.click("xpath=//input[@type='submit']");
		Assert.assertTrue(webtest.isTextPresent("�˳�"));
	}
	
	@Test(description="������󣬵�¼ʧ��")
	public void testloginfail() {
		webtest.open("/admin.php/Login/index.html");
		
		webtest.type("name=username","admin");
		webtest.type("name=password","admin11111");
		
		webtest.click("xpath=//input[@type='submit']");
		Assert.assertTrue(webtest.isTextPresent("�˳�"));
	}
}
