package com.wordpress.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.appModules.Theme_Action;
import com.wordpress.core.BaseTest;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月3日 下午3:26:56 
* 外观模块下，添加主题的测试用例 
*/

public class Theme_Test extends BaseTest{
	
	String changethemename = "Twenty Seventeen";
	String addthemename = "Relativity";

	
	@Test(description="启用已安装的主题",priority=0)
	public void changeTheme() {
		waiguan.changeTheme(changethemename);
		assertTrue(webtest.ifContains("新主题已激活"));
	}	
	
	@Test(description="搜索添加主题",priority=2)
	public void addThemeBySearch() {
		waiguan.addThemeBySearch(addthemename);
		assertFalse(webtest.ifContains("正在安装"));
	}
	
	
	@Test(description="删除已安装主题",priority=3)
	public void delTheme() {
		waiguan.delTheme(addthemename);
		assertFalse(webtest.ifContains(addthemename));
	}
	
	
	
	Theme_Action waiguan;
	
	@BeforeMethod
	public void setup() {
		waiguan = new Theme_Action(webtest);
	}
	
}
