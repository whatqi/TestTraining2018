package com.wordpress.appModules;

import com.wordpress.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月5日 下午4:38:42 
* wordpress项目
*   外观模块下，小工具增删改查的操作类 
*/

public class LittleTools_Action {
	
	private WebDriverEngine webtest;
	
	int toolsid = 22;//在整个页面中他是第几个出现的小工具，这个数字就是几
	int editi = 2;//页面中出现的是几个小工具，这个数字就是几
	
	String editid = "widget-"+toolsid+"_rss-"+editi;
	//点击保存按钮
	String savepath = "//input[@id='savewidget']";
	
	
	public void addTools() {
		String addid = "widget-1_rss-__i__";
		this.tools();
		webtest.click("xpath=//div[@id='"+addid+"']/div/div/a/span[@class='add']");
		webtest.click("xpath="+savepath);
	}
	
	
	public void editTools(String url,String i) {
		this.tools();
		webtest.click("xpath=//div[@id='"+editid+"']/div/div/a/span[@class='edit']");
		//在此输入RSS feed URL
		webtest.type("xpath=//input[@id='rss-url-"+editi+"']", url);
		//下拉菜单
		webtest.selectByValue("xpath=//select[@id='rss-items-"+editi+"']", i);
		//复选框,显示条目日期
		webtest.click("xpath=//input[@id='rss-show-author-"+editi+"']");
		webtest.click("xpath=//input[@id='rss-show-date-"+editi+"']");
		
		webtest.click("xpath="+savepath);
	}
	
	
	public void delTools() {
		this.tools();
		webtest.click("xpath=//div[@id='"+editid+"']/div/div/a/span[@class='edit']");
		webtest.click("xpath=//input[@id='removewidget']");
	}
	
	
	
	
	
	public LittleTools_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	
	public void login() {
		webtest.open("/wp-login.php");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "VJH$zxPNT3%enjVfHX");
		webtest.click("id=wp-submit");
	}
	
	public void tools() {
		this.login();
		webtest.click("xpath=//div[text()='外观']");
		webtest.click("xpath=//a[text()='小工具']");
		
		
//		webtest.click("xpath=//button[@id='show-settings-link']");
//		if(webtest.isElementPresent("xpath=//a[@id='access-on']")) {
//			webtest.click("xpath=//a[@id='access-on']");
//		}
	}
	
	
}
