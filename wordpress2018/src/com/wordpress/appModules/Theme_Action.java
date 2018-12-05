package com.wordpress.appModules;

import com.webtest.utils.Log;
import com.wordpress.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��3�� ����3:21:21 
* wordpress��Ŀ
* ���ģ���£��������Ĳ����� 
*/

public class Theme_Action {

	private WebDriverEngine webtest;
	
	
	//�����Ѱ�װ����
	public void changeTheme(String name) {
		this.theme();
		
		if(webtest.isElementPresent("xpath=//h2[contains(.,'"+name+"')]")) {
			webtest.click("xpath=//h2[contains(.,'"+name+"')]");
			
			webtest.click("xpath=//a[@aria-label='����Twenty Thirteen']");

		}else {
			Log.error(name+"����Ԫ�ز�����");
		}
	}
	
	
	//�������
	//�������Ⲣ���
	public void addThemeBySearch(String name) {
		this.theme();
		webtest.click("xpath=//a[@class='hide-if-no-js page-title-action']");
		webtest.typeAndClear("id=wp-filter-search-input",name);
		
		webtest.click("xpath=//h3[contains(.,'"+name+"')]");
		
		webtest.click("xpath=//a[contains(.,'��װ')]");
		
		int i=0;
		while(i<2 && webtest.ifNotContains("���ڰ�װ")) {
			webtest.pause(5000);
			i++;
		}
		
	}
	//ͨ�����Ӱ�װ����
	public void addThemeByLink(String name) {
		
		this.theme();
		
		webtest.click("xpath=//a[contains(.,'���������')]");
		webtest.click("xpath=//h3[contains(.,'"+name+"')]");
		
		webtest.click("xpath=//a[contains(.,'��װ')]");
		
		int i=0;
		while(i<2 && webtest.ifNotContains("���ڰ�װ")) {
			webtest.pause(5000);
			i++;
		}
	}
	//ͨ����ť��װ����
	public void addThemeByButton(String name) {
		
		
		this.theme();
		
		webtest.click("xpath=//a[@class='hide-if-no-js page-title-action']");
		webtest.click("xpath=//h3[contains(.,'"+name+"')]");
		
		webtest.click("xpath=//a[contains(.,'��װ')]");
		
		int i=0;
		while(i<2 && webtest.ifNotContains("���ڰ�װ")) {
			webtest.pause(5000);
			i++;
		}
	}

	
	//ɾ����ӵ�����
	public void delTheme(String name) {
		this.theme();
		String themediv = "xpath=//h2[@id='"+name+"-name']";
		
		if(webtest.isElementPresent(themediv)) {
			if(webtest.isElementPresent("xpath=//h2[contains(.,'��ǰ��"+name+"')]")) {//�ж������Ƿ�����ʹ��
				Log.error("Ҫɾ�������⣺"+name+"����ʹ��");
			}else {
				webtest.click(themediv);
				webtest.click("xpath=//a[contains(.,'ɾ��')]");
				webtest.alertAccept();
				webtest.pause(5000);
			}	
		}else {
			Log.error(name+"����δ��װ");
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
		webtest.click("xpath=//div[text()='���']");
		webtest.click("xpath=//a[@aria-current='page']");		
	}
	
}
