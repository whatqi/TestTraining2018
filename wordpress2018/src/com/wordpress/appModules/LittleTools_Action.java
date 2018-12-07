package com.wordpress.appModules;

import com.wordpress.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��5�� ����4:38:42 
* wordpress��Ŀ
*   ���ģ���£�С������ɾ�Ĳ�Ĳ����� 
*/

public class LittleTools_Action {
	
	private WebDriverEngine webtest;
	
	int toolsid = 22;//������ҳ�������ǵڼ������ֵ�С���ߣ�������־��Ǽ�
	int editi = 2;//ҳ���г��ֵ��Ǽ���С���ߣ�������־��Ǽ�
	
	String editid = "widget-"+toolsid+"_rss-"+editi;
	//������水ť
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
		//�ڴ�����RSS feed URL
		webtest.type("xpath=//input[@id='rss-url-"+editi+"']", url);
		//�����˵�
		webtest.selectByValue("xpath=//select[@id='rss-items-"+editi+"']", i);
		//��ѡ��,��ʾ��Ŀ����
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
		webtest.click("xpath=//div[text()='���']");
		webtest.click("xpath=//a[text()='С����']");
		
		
//		webtest.click("xpath=//button[@id='show-settings-link']");
//		if(webtest.isElementPresent("xpath=//a[@id='access-on']")) {
//			webtest.click("xpath=//a[@id='access-on']");
//		}
	}
	
	
}
