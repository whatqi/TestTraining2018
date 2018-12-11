package com.wordpress.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.wordpress.appModules.LittleTools_Action;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��5�� ����4:37:02 
* ���ģ���£�С���ߵ���ɾ�Ĳ��������
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
		assertTrue(webtest.ifContains("�޸��ѱ���"));
		
	}
	
	@Test (priority=1)
	public void editTools() {
		tools.editTools("www.123.com","8");
		assertTrue(webtest.ifContains("�޸��ѱ���"));
	}
	
	@Test(priority=2)
	public void delTools() {
		tools.delTools();
		assertTrue(webtest.ifContains("�޸��ѱ���"));
	}
	
	@Test(priority=3,description="ͨ���Զ��������С����")
	public void addToolsByUser() {
		tools.addToolsByUser();
		assertTrue(webtest.ifContains("�ѷ���"));
	}
	
	@Test(priority=4,description="ͨ���Զ�����ɾ��С����")
	public void delToolsByUser() {
		tools.delToolsByUser();
		assertTrue(webtest.ifContains("�ѷ���"));
	}
}
