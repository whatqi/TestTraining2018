package com.wordpress.appModules;

import com.webtest.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��5�� ����6:00:48 
* ���ģ���£������Զ������ý������� 
*/

public class Top_Action {
	
	
	public void addvideo() {
		this.top();
		webtest.pause(3000);
		webtest.click("id=customize-media-control-button-35");
		webtest.click("link=�ϴ��ļ�");
		webtest.click("xpath=//button[starts-with(@id,'__wp-uploader-id-')]");
	}
	
	public void addpic() {
		this.top();
		webtest.pause(3000);
		webtest.click("id=header_image-button");
		webtest.click("link=�ϴ��ļ�");
		webtest.click("xpath=//button[starts-with(@id,'__wp-uploader-id-')]");
//		webtest.type("xpath=//button[starts-with(@id,'__wp-uploader-id-')]","D:\\2016TrainingJava\\testdemo\\20181203-180439.png");
	}
	
	
	public void delpic() {
		this.top();
		webtest.pause(3000);
		webtest.click("id=header_image-button");
		webtest.click("link=ý���");
		webtest.click("xpath=//div[@class='thumbnail']");
		webtest.click("xpath=//button[contains(.,'����ɾ��')]");
		webtest.alertAccept();
		webtest.pause(2000);
	}
	
	private WebDriverEngine webtest;
	
	public Top_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	
	public void login() {
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "VJH$zxPNT3%enjVfHX");
		webtest.click("id=wp-submit");
	}
	
	public void top() {
		this.login();
		webtest.click("xpath=//div[text()='���']");
		webtest.click("xpath=//a[text()='����']");
	}
}
