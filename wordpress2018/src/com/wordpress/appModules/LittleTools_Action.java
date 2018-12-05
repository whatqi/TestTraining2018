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
	
	String addtoolspath = "//a[contains(@href,'/wordpress/wp-admin/widgets.php?editwidget=rss-1&addnew=1&num=3&base=rss')]";
	String edittoolspath = "//a[contains(@href,'/wordpress/wp-admin/widgets.php?editwidget=rss-2&sidebar=sidebar-1&key=5')]";
	String savepath = "//input[@value='����С����']";
	
	
	public void addTools() {
		this.tools();
		webtest.click("xapth="+addtoolspath);
		webtest.click("xpath="+savepath);
	}
	
	
	public void editTools(String url,String i) {
		this.tools();
		webtest.click("xpath="+edittoolspath);
		//�ڴ�����RSS feed URL
		webtest.type("xpath=//input[@id='rss-url-2']", url);
		//�����˵�
		webtest.selectByValue("xpath=//select[@id='rss-items-2']", i);
		//��ѡ��,��ʾ��Ŀ����
		webtest.click("xpath=//input[@id='rss-show-author-2']");
		webtest.click("xpath=//input[@id='rss-show-date-2']");
		
		webtest.click("xpath="+savepath);
	}
	
	
	public void delTools() {
		this.tools();
		webtest.click("xpath="+edittoolspath);
		webtest.click("xpath="+savepath);
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
		webtest.click("xpath=//div[contains(@class,'wp-menu-image dashicons-before dashicons-admin-appearance')]");
//		webtest.click("xpath=//div[text()='���']");
		webtest.click("xpath=//a[@href='widgets.php']");
		webtest.click("xpath=//button[@id='show-settings-link']");
		if(webtest.isElementPresent("xpath=//a[@id='access-on']")) {
			webtest.click("xpath=//a[@id='access-on']");
		}
	}
	
	
}
