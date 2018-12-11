package com.wordpress.appModules;

import com.webtest.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月5日 下午6:00:48 
* 外观模块下，顶部自定义添加媒体操作类 
*/

public class Top_Action {
	
	
	public void addvideo() {
		this.top();
		webtest.pause(3000);
		webtest.click("id=customize-media-control-button-35");
		webtest.click("link=上传文件");
		webtest.click("xpath=//button[starts-with(@id,'__wp-uploader-id-')]");
	}
	
	public void addpic() {
		this.top();
		webtest.pause(3000);
		webtest.click("id=header_image-button");
		webtest.click("link=上传文件");
		webtest.click("xpath=//button[starts-with(@id,'__wp-uploader-id-')]");
//		webtest.type("xpath=//button[starts-with(@id,'__wp-uploader-id-')]","D:\\2016TrainingJava\\testdemo\\20181203-180439.png");
	}
	
	
	public void delpic() {
		this.top();
		webtest.pause(3000);
		webtest.click("id=header_image-button");
		webtest.click("link=媒体库");
		webtest.click("xpath=//div[@class='thumbnail']");
		webtest.click("xpath=//button[contains(.,'永久删除')]");
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
		webtest.click("xpath=//div[text()='外观']");
		webtest.click("xpath=//a[text()='顶部']");
	}
}
