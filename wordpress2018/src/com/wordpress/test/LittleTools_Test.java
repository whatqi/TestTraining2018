package com.wordpress.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.appModules.LittleTools_Action;
import com.wordpress.appModules.Theme_Action;
import com.wordpress.core.BaseTest;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月5日 下午4:37:02 
* 外观模块下，小工具的增删改查测试用例
*/

public class LittleTools_Test extends BaseTest{
	LittleTools_Action tools;
	
	@BeforeMethod
	public void setup() {
		tools = new LittleTools_Action(webtest);
	}
	
	@Test(priority=0)
	public void addTools() {
		tools.addTools();
		assertTrue(webtest.ifContains("修改已保存"));
		
	}
	
	@Test (priority=1)
	public void editTools() {
		tools.editTools("www.123.com","8");
		assertTrue(webtest.ifContains("修改已保存"));
	}
	
	@Test(priority=2)
	public void delTools() {
		tools.delTools();
		assertTrue(webtest.ifContains("修改已保存"));
	}
}
