package com.webtest.core;

import org.testng.Assert;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��11��27�� ����5:02:06 
* ��˵�� 
*/

public class Checker {
	
	public static void checktxt(WebDriverEngine webtest,String txt) {
		Assert.assertTrue(webtest.isTextPresent(txt));
	}
	
	
}
