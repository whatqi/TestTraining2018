package com.webtest.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
/**
 * author:lihaunzhen
 * 截屏类
 */
public class SeleniumScreenShot {
    public WebDriver driver;
 
    public SeleniumScreenShot(WebDriver driver) {
    
    	this.driver = driver;
    
    }
 
    
    
    public void screenShot(){
    	//报告正确显示截图
    	System.setProperty("org.uncommons.reportng.escape-output", "false"); 
    	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String nowDateTime=sdf.format(new Date());
		
		File s_file=((TakesScreenshot)driver).
				getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(s_file, new File("D:\\2016TrainingJava\\testdemo\\"+nowDateTime+".png"));
			Reporter.log("<img src=D:/2016TrainingJava/testdemo/" + nowDateTime + ".png onclick='window.open(\"D:/2016TrainingJava/testdemo/"+nowDateTime+".png\")' height='108' width='192'/>",true);

//			Reporter.log("<img src =D:/2016TrainingJava/testdemo/"+nowDateTime+".jpg width = '100px' />",true);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}