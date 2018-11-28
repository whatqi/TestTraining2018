package com.webtest.core;

import org.testng.Assert;

/** 
* author:shenmengqi 
* @version 创建时间：2018年11月27日 下午5:02:06 
* 类说明 
*/

public class Checker {
	
	public static void checktxt(WebDriverEngine webtest,String txt) {
		Assert.assertTrue(webtest.isTextPresent(txt));
	}
	
	
}
