package com.wordpress.appModules;

import com.webtest.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��5�� ����5:59:35 
* ��˵�� 
*/

public class Menus_Action {
	
	private WebDriverEngine webtest;
	
	
	public void addMenus(String name) {
		this.menus();
		
		webtest.click("xpath=//a[contains(.,'�����²˵�')]");
		webtest.typeAndClear("xpath=//input[@id='menu-name']", name);
		webtest.click("xpath=//input[@id='save_menu_header']");
	}
	
	public void editMenus(String name) {
		this.menus();
		webtest.selectByVisibleText("name=menu", name);
		webtest.click("xpath=//input[@value='ѡ��']");
		//�޸Ĳ˵��Ĳ���
		webtest.click("xpath=//input[@id='auto-add-pages']");
		
		webtest.click("xpath=//input[@id='save_menu_header']");
	}
	
	public void delMenus(String name) {
		this.menus();
		webtest.selectByVisibleText("name=menu", name);
		webtest.click("xpath=//input[@value='ѡ��']");
		webtest.click("xpath=//a[contains(.,'ɾ���˵�')]");
		webtest.alertAccept();
		try {
			webtest.wait(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void addMenusByUser(String name) {
		this.menusByUser();
		webtest.click("xpath=//button[@class='button customize-add-menu-button']");
		webtest.typeAndClear("xpath=//input[@aria-describedby='add_menu-description']", name);
		webtest.click("xpath=//button[contains(.,'����')]");
		webtest.click("id=save");
	}
	
	public void delMeunsByUser(String name) {
		this.menusByUser();
		webtest.click("xpath=//h3[text()='"+name+"']");
		webtest.click("xpath=//button[contains(.,'ɾ���˵�')]");
		webtest.click("id=save");
	}
	
	
	public Menus_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	
	public void login() {
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "VJH$zxPNT3%enjVfHX");
		webtest.click("id=wp-submit");
	}
	
	public void menus() {
		this.login();
		webtest.click("xpath=//li[@id='menu-appearance']/a/div[@class='wp-menu-name']");
		webtest.click("xpath=//a[@href='nav-menus.php']");
	}
	
	public void menusByUser() {
		this.login();
		webtest.click("xpath=//div[text()='���']");
		webtest.click("xpath=//a[text()='�Զ���']");
		webtest.click("xpath=//h3[contains(.,'�˵�')]");
	}
}
