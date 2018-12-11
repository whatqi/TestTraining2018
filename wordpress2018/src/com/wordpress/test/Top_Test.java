package com.wordpress.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.wordpress.appModules.Top_Action;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��5�� ����6:00:59 
* �����Զ������ý�����������
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
		assertTrue(webtest.ifContains("�Ҳ�����Ŀ"));
	}
	
	Top_Action top;
	
	@BeforeMethod
	public void setup() {
		top = new Top_Action(webtest);
	}
}
