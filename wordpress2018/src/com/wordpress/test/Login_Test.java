package com.wordpress.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.wordpress.appModules.Login_Action;

/** 
* author:shenmengqi 
* @version 创建时间：2018年11月28日 下午2:04:43 
* 登录测试用例 
*/

public class Login_Test extends BaseTest{
	
	Login_Action lo_action;
	
	@BeforeMethod
	public void setup() {
		lo_action = new Login_Action(webtest);
	}

	@Test(priority=0)
	public void login_success_test() {
		lo_action.login("admin", "VJH$zxPNT3%enjVfHX");
		
	}
	
	@Test(description="用户名错误",priority=1)
	public void login_fail1_test() {
		lo_action.login("error", "VJH$zxPNT3%enjVfHX");
		assertTrue(webtest.ifContains("错误"));
	}
	
	@Test(description="用户名长度异常",priority=2)
	public void login_fail2_test() {
		lo_action.login("wuwuwuwuwuwuwiwiicbiuwegfieugfiwug", "VJH$zxPNT3%enjVfHX");
		assertTrue(webtest.ifContains("无效"));
	}
	
	@Test(description="用户名为空",priority=3)
	public void login_fail3_test() {
		lo_action.login("", "VJH$zxPNT3%enjVfHX");
		assertTrue(webtest.ifContains("为空"));
	}
	
	@Test(description="密码错误",priority=4)
	public void login_fail4_test() {
		lo_action.login("admin", "%enjVfHX");
		assertTrue(webtest.ifContains("密码不正确"));
	}
	
	@Test(description="密码长度异常",priority=5)
	public void login_fail5_test() {
		lo_action.login("admin", "sdefdfwrfwrfwrfwfwrfwVJH$zxPNT3%enjVfHX");
		assertTrue(webtest.ifContains("密码不正确"));
	}
	
	@Test(description="密码为空",priority=6)
	public void login_fail6_test() {
		lo_action.login("admin", "");
		assertTrue(webtest.ifContains("为空"));
	}
}
