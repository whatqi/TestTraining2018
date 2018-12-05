package com.wordpress.appModules;

import com.webtest.utils.Log;
import com.wordpress.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月3日 下午3:21:21 
* wordpress项目
* 外观模块下，添加主题的操作类 
*/

public class Theme_Action {

	private WebDriverEngine webtest;
	
	
	//启用已安装主题
	public void changeTheme(String name) {
		this.theme();
		
		if(webtest.isElementPresent("xpath=//h2[contains(.,'"+name+"')]")) {
			webtest.click("xpath=//h2[contains(.,'"+name+"')]");
			
			webtest.click("xpath=//a[@aria-label='激活Twenty Thirteen']");

		}else {
			Log.error(name+"主题元素不存在");
		}
	}
	
	
	//添加主题
	//搜索主题并添加
	public void addThemeBySearch(String name) {
		this.theme();
		webtest.click("xpath=//a[@class='hide-if-no-js page-title-action']");
		webtest.typeAndClear("id=wp-filter-search-input",name);
		
		webtest.click("xpath=//h3[contains(.,'"+name+"')]");
		
		webtest.click("xpath=//a[contains(.,'安装')]");
		
		int i=0;
		while(i<2 && webtest.ifNotContains("正在安装")) {
			webtest.pause(5000);
			i++;
		}
		
	}
	//通过链接安装主题
	public void addThemeByLink(String name) {
		
		this.theme();
		
		webtest.click("xpath=//a[contains(.,'添加新主题')]");
		webtest.click("xpath=//h3[contains(.,'"+name+"')]");
		
		webtest.click("xpath=//a[contains(.,'安装')]");
		
		int i=0;
		while(i<2 && webtest.ifNotContains("正在安装")) {
			webtest.pause(5000);
			i++;
		}
	}
	//通过按钮安装主题
	public void addThemeByButton(String name) {
		
		
		this.theme();
		
		webtest.click("xpath=//a[@class='hide-if-no-js page-title-action']");
		webtest.click("xpath=//h3[contains(.,'"+name+"')]");
		
		webtest.click("xpath=//a[contains(.,'安装')]");
		
		int i=0;
		while(i<2 && webtest.ifNotContains("正在安装")) {
			webtest.pause(5000);
			i++;
		}
	}

	
	//删除添加的主题
	public void delTheme(String name) {
		this.theme();
		String themediv = "xpath=//h2[@id='"+name+"-name']";
		
		if(webtest.isElementPresent(themediv)) {
			if(webtest.isElementPresent("xpath=//h2[contains(.,'当前："+name+"')]")) {//判断主题是否正在使用
				Log.error("要删除的主题："+name+"正在使用");
			}else {
				webtest.click(themediv);
				webtest.click("xpath=//a[contains(.,'删除')]");
				webtest.alertAccept();
				webtest.pause(5000);
			}	
		}else {
			Log.error(name+"主题未安装");
		}
		
	}
	
	
	
	
	
	
	public Theme_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	public void login() {
		webtest.open("/wp-login.php");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "VJH$zxPNT3%enjVfHX");
		webtest.click("id=wp-submit");
	}
	
	public void theme() {
		this.login();
		webtest.click("xpath=//div[text()='外观']");
		webtest.click("xpath=//a[@aria-current='page']");		
	}
	
}
