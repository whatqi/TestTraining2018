package com.webtest.core;

import org.testng.Assert;

/** 
* author:shenmengqi 
* @version 创建时间：2018年11月27日 下午5:02:06 
* 类说明 
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
