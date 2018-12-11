package com.wordpress.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.wordpress.appModules.LittleTools_Action;

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
	
	@Test(priority=3,description="通过自定义栏添加小工具")
	public void addToolsByUser() {
		tools.addToolsByUser();
		assertTrue(webtest.ifContains("已发布"));
	}
	
	@Test(priority=4,description="通过自定义栏删除小工具")
	public void delToolsByUser() {
		tools.delToolsByUser();
		assertTrue(webtest.ifContains("已发布"));
	}
}
