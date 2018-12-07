package com.wordpress.appModules;

import com.wordpress.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月5日 下午6:00:48 
* 外观模块下，顶部自定义添加媒体操作类 
*/

public class Top_Action {
	
	
	
	
	private WebDriverEngine webtest;
	
	public Top_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	
	public void login() {
		webtest.open("/wp-login.php");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "VJH$zxPNT3%enjVfHX");
		webtest.click("id=wp-submit");
	}
	
	public void top() {
		this.login();
		webtest.click("xpath=//div[contains(@class,'wp-menu-image dashicons-before dashicons-admin-appearance')]");
//		webtest.click("xpath=//div[text()='外观']");
		webtest.click("xpath=//a[@href='widgets.php']");
		webtest.click("xpath=//button[@id='show-settings-link']");
		if(webtest.isElementPresent("xpath=//a[@id='access-on']")) {
			webtest.click("xpath=//a[@id='access-on']");
		}
	}
	//a[@href='customize.php?return=%2Fwordpress%2Fwp-admin%2Fthemes.php&autofocus%5Bcontrol%5D=background_image']
}
