package com.webtest.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Admin_Login extends BaseTest{
	
	@Test(description="后台管理员登陆成功")
	public void testlogin() {
		webtest.open("/admin.php/Login/index.html");
		
		webtest.type("name=username","admin");
		webtest.type("name=password","admin");
		
		webtest.click("xpath=//input[@type='submit']");
		Assert.assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="密码错误，登录失败")
	public void testloginfail() {
		webtest.open("/admin.php/Login/index.html");
		
		webtest.type("name=username","admin");
		webtest.type("name=password","admin11111");
		
		webtest.click("xpath=//input[@type='submit']");
		Assert.assertTrue(webtest.isTextPresent("退出"));
	}
}
