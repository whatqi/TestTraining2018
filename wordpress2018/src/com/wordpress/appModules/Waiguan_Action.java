package com.wordpress.appModules;

import com.wordpress.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月3日 下午3:21:21 
* 类说明 
*/

public class Waiguan_Action {

	private WebDriverEngine webtest;
	
	public Waiguan_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	public void addzhuti() {
		webtest.click("xpath=//div[contains(.,'外观')]");
		webtest.click("xpath=//a[@aria-current='page']");
		webtest.click("xpath=//a[contains(@class,'hide-if-no-js page-title-action')]");
	}
}
