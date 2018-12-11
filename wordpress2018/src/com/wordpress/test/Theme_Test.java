package com.wordpress.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.wordpress.appModules.Theme_Action;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��3�� ����3:26:56 
* ���ģ���£��������Ĳ������� 
*/

public class Theme_Test extends BaseTest{
	
	String changethemename = "Twenty Sixteen";
	String addthemename = "Relativity";

	
	@Test(description="�����Ѱ�װ������",priority=0)
	public void changeTheme() {
		waiguan.changeTheme(changethemename);
		assertTrue(webtest.ifContains("�������Ѽ���"));
	}
	
	@Test(description="������ָ���Ĭ������",priority=1)
	public void defaulttheme() {
		waiguan.changeTheme("Twenty Seventeen");
		assertTrue(webtest.ifContains("�������Ѽ���"));
	}
	
	@Test(description="�����������",priority=2)
	public void addThemeBySearch() {
		waiguan.addThemeBySearch(addthemename);
		assertFalse(webtest.ifContains("���ڰ�װ"));
	}
	
	
	@Test(description="ɾ���Ѱ�װ����",priority=3)
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
