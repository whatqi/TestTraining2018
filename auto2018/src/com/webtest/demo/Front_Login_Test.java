package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Front_Login_Test extends BaseTest{

	Login_Action action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
	}

	@Test(description="成功登陆前台")
	public void testLogin() throws Exception  {
		webtest.open("");
		action.login("qingdao01", "123456");
		assertTrue(webtest.ifContains("退出"));
	}
	
	@Test(description="qingdao01登录密码错误")
	public void testfail() throws Exception  {
		webtest.open("");
		action.login("qingdao01", "123456789");
		assertTrue(webtest.ifContains("退出"));
	}

}
