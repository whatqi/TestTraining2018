package com.webtest.core;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.webtest.utils.JavaMail;
import com.webtest.utils.FileToZIP;
import com.webtest.utils.Log;

/**
 * author:lihuanzhen
 * ������������ʧ�ܣ�����
 */


public class WebTestListener  extends TestListenerAdapter{
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  Log.error(tr.getInstance()+"-"+tr.getName()+"����ʧ�ܣ���Ҫ����");
		  BaseTest tb = (BaseTest) tr.getInstance();
          WebDriver driver = tb.getDriver();    
		  SeleniumScreenShot ss = new SeleniumScreenShot(driver);
		  ss.screenShot();
//		  
//		  Log.error(tr.getInstance()+"-"+tr.getName()+"����ʧ�ܣ������ʼ�");
//		  JavaMail email = new JavaMail();
//		  email.sendmail();
	  }
	  
	  @Override
		public void onFinish(ITestContext testContext) {
			super.onFinish(testContext);
			Log.info(testContext.getName());
			JavaMail sm = new JavaMail();
			sm.sendmail();		
		}

}
