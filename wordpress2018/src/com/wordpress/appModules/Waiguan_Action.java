package com.wordpress.appModules;

import com.wordpress.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��3�� ����3:21:21 
* ��˵�� 
*/

public class Waiguan_Action {

	private WebDriverEngine webtest;
	
	public Waiguan_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	public void addzhuti() {
		webtest.click("xpath=//div[contains(.,'���')]");
		webtest.click("xpath=//a[@aria-current='page']");
		webtest.click("xpath=//a[contains(@class,'hide-if-no-js page-title-action')]");
	}
}
