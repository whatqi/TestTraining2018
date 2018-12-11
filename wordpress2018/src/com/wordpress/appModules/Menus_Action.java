package com.wordpress.appModules;

import com.webtest.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月5日 下午5:59:35 
* 类说明 
*/

public class Menus_Action {
	
	private WebDriverEngine webtest;
	
	
	public void addMenus(String name) {
		this.menus();
		
		webtest.click("xpath=//a[contains(.,'创建新菜单')]");
		webtest.typeAndClear("xpath=//input[@id='menu-name']", name);
		webtest.click("xpath=//input[@id='save_menu_header']");
	}
	
	public void editMenus(String name) {
		this.menus();
		webtest.selectByVisibleText("name=menu", name);
		webtest.click("xpath=//input[@value='选择']");
		//修改菜单的步骤
		webtest.click("xpath=//input[@id='auto-add-pages']");
		
		webtest.click("xpath=//input[@id='save_menu_header']");
	}
	
	public void delMenus(String name) {
		this.menus();
		webtest.selectByVisibleText("name=menu", name);
		webtest.click("xpath=//input[@value='选择']");
		webtest.click("xpath=//a[contains(.,'删除菜单')]");
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
		webtest.click("xpath=//button[contains(.,'继续')]");
		webtest.click("id=save");
	}
	
	public void delMeunsByUser(String name) {
		this.menusByUser();
		webtest.click("xpath=//h3[text()='"+name+"']");
		webtest.click("xpath=//button[contains(.,'删除菜单')]");
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
		webtest.click("xpath=//div[text()='外观']");
		webtest.click("xpath=//a[text()='自定义']");
		webtest.click("xpath=//h3[contains(.,'菜单')]");
	}
}
