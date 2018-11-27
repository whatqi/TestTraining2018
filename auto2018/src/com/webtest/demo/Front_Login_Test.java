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

	@Test(description="�ɹ���½ǰ̨")
	public void testLogin() throws Exception  {
		webtest.open("");
		action.login("qingdao01", "123456");
		assertTrue(webtest.ifContains("�˳�"));
	}
	
	@Test(description="qingdao01��¼�������")
	public void testfail() throws Exception  {
		webtest.open("");
		action.login("qingdao01", "123456789");
		assertTrue(webtest.ifContains("�˳�"));
	}

}
