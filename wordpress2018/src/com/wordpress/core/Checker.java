package com.wordpress.core;

import org.testng.Assert;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��11��27�� ����5:02:06 
* ��˵�� 
*/

public class Checker {
	
	private WebDriverEngine webtest;
	
	public Checker(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	public void checktxt(String txt) {
		Assert.assertTrue(webtest.isTextPresent(txt));
	}
	
	
}
