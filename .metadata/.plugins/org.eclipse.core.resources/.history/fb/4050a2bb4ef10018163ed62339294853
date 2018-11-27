package com.webtest.core;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.webtest.utils.JavaMail;
import com.webtest.utils.Log;

/**
 * author:lihuanzhen
 * 监听器，用例失败，截屏
 */


public class WebTestListener  extends TestListenerAdapter{
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  Log.error(tr.getInstance()+"-"+tr.getName()+"运行失败，需要截屏");
		  BaseTest tb = (BaseTest) tr.getInstance();
          WebDriver driver = tb.getDriver();    
		  SeleniumScreenShot ss = new SeleniumScreenShot(driver);
		  ss.screenShot();
		  
		  Log.error(tr.getInstance()+"-"+tr.getName()+"运行失败，发送邮件");
		  JavaMail email = new JavaMail();
		  email.sendmail();
		 
		  
	  }

}
