package com.wordpress.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.appModules.Menus_Action;
import com.wordpress.core.BaseTest;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月5日 下午5:59:43 
* 外观模块下，菜单栏的增删改查
*/

public class Menus_Test extends BaseTest{
	

	
	@Test(priority=0)
	public void addMenus() {
		menus.addMenus("测试菜单1");
	}
	
	@Test(description="添加同名菜单失败",priority=1)
	public void addSameMenus() {
		menus.addMenus("测试菜单1");
		assertTrue(webtest.ifContains("名称冲突"));
	}
	
	@Test(priority=2)
	public void editMenus() {
		menus.editMenus("测试菜单1");
		assertTrue(webtest.ifContains("已被更新"));
	}
	
	@Test(priority=3)
	public void delMenus() {
		menus.delMenus("测试菜单1");
		assertTrue(webtest.ifContains("成功删除"));
		
	}
	
	
	
	
	
	
	Menus_Action menus;
	
	@BeforeMethod
	public void setup() {
		menus = new Menus_Action(webtest);
	}
}
