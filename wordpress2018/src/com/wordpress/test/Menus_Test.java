package com.wordpress.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.appModules.Menus_Action;
import com.wordpress.core.BaseTest;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��5�� ����5:59:43 
* ���ģ���£��˵�������ɾ�Ĳ�
*/

public class Menus_Test extends BaseTest{
	

	
	@Test(priority=0)
	public void addMenus() {
		menus.addMenus("���Բ˵�1");
	}
	
	@Test(description="���ͬ���˵�ʧ��",priority=1)
	public void addSameMenus() {
		menus.addMenus("���Բ˵�1");
		assertTrue(webtest.ifContains("���Ƴ�ͻ"));
	}
	
	@Test(priority=2)
	public void editMenus() {
		menus.editMenus("���Բ˵�1");
		assertTrue(webtest.ifContains("�ѱ�����"));
	}
	
	@Test(priority=3)
	public void delMenus() {
		menus.delMenus("���Բ˵�1");
		assertTrue(webtest.ifContains("�ɹ�ɾ��"));
		
	}
	
	
	
	
	
	
	Menus_Action menus;
	
	@BeforeMethod
	public void setup() {
		menus = new Menus_Action(webtest);
	}
}
