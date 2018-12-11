package com.wordpress.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.wordpress.appModules.Top_Action;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月5日 下午6:00:59 
* 顶部自定义添加媒体测试用例类
*/

public class Top_Test extends BaseTest{
	@Test
	public void add() {
		top.addvideo();
	}
	
	
	@Test
	public void addpic() {
		top.addpic();
	}
	
	@Test
	public void delpic() {
		top.delpic();
		assertTrue(webtest.ifContains("找不到条目"));
	}
	
	Top_Action top;
	
	@BeforeMethod
	public void setup() {
		top = new Top_Action(webtest);
	}
}
