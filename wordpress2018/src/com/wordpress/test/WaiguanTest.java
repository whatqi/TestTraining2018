package com.wordpress.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.appModules.Login_Action;
import com.wordpress.appModules.Waiguan_Action;
import com.wordpress.core.BaseTest;
import com.wordpress.core.Checker;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��3�� ����3:26:56 
* ��˵�� 
*/

public class WaiguanTest extends BaseTest{
	
	Waiguan_Action waiguan;
	
	@BeforeMethod
	public void setup() {
		waiguan = new Waiguan_Action(webtest);
	}
	
	@Test
	public void addzhuti() {
		waiguan.addzhuti();
	}
	
}
