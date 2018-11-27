package com.webtest.core;

import org.testng.Assert;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��11��27�� ����5:02:06 
* ��˵�� 
*/

public class Checker {
	
	
	public  WebDriverEngine webtest;
	
	public Checker(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	public void check(String txt) {
		Assert.assertTrue(webtest.isTextPresent(txt));
	}
	
	
}
