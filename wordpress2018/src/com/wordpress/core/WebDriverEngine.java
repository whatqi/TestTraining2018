package com.wordpress.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.ExecuteScript;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;
/**
 * author:shenmengqi
 * 页面对象操作类
 */
public class WebDriverEngine {

	WebDriver driver = null;
	ElementFinder finder = null;
	Actions action  =null;

	
	
	public WebDriverEngine(WebDriver driver) {
		
		this.driver = driver;
		driver.manage().window().maximize();
		finder = new ElementFinder(driver);
		action = new Actions(driver);
	}
	
		
	public String[] getAllWindowTitles() {

	    String current = driver.getWindowHandle();

	    List<String> attributes = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	      driver.switchTo().window(handle);
	      attributes.add(driver.getTitle());
	    }

	    driver.switchTo().window(current);

	    return attributes.toArray(new String[attributes.size()]);
	}
	

	public void enterFrame(String frameID) {	
		
		this.pau_wait(10);
		driver.switchTo().frame(frameID);
		Log.info("Entered iframe " + frameID);
	}

	
	public void enterFrame(int frameID) {
		this.pau_wait(10);
		driver.switchTo().frame(frameID);
		Log.info("Entered iframe " + frameID);
	}
	
	
	public void getWindow(int i){
		
		List<String> windows = new ArrayList<String>();
		for (String handle : driver.getWindowHandles())
		{
//			System.out.println(handle);  //杩涘叆鍒扮浜屼釜椤甸潰
			windows.add(handle);
		}
		driver.switchTo().window(windows.get(i));
	}

	
	public void leaveFrame() {
		driver.switchTo().defaultContent();
		Log.info("Left the iframe");
	}
	

	//打开网页
	public void open(String url) {
			
		String baseurl;
		try {
			baseurl = ReadProperties.getPropertyValue("base_url");
			driver.get(baseurl+url);
			pause(3000);
			
			Log.info("Opened url :" + baseurl+url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Log.info("Opened url ERROR");
	}

	
	public String getTitle() {
	
		return driver.getTitle();
	
	}

	
	public void pau_wait(int time) {
		
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	
	//毫秒
	public void pause(int time) {
		if (time <= 0) {
			return;
		}
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		
		}
	}

	
	//文本是否存在
	public boolean isTextPresent(String pattern) {
		
		String text = driver.getPageSource();
		text = text.trim();
		if (text.contains(pattern)) {
		
			return true;
		}
		return false;
	}
	
	//文本是否不存在
	public boolean isTextNotPresent(String pattern) {
		String text = driver.getPageSource();
		text = text.trim();
		if(text.contains(pattern)) {
			return false;
		}
		return true;
	}

	
	//清空原有内容,sendKeys
	public void typeAndClear(String locator, String value) {
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.clear();
			element.sendKeys(value);
		}
		this.pau_wait(10);
	}

	
	//sendKeys
	public void type(String locator, String value) {
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.sendKeys(value);
			this.pau_wait(10);
		}
	}

	
	public boolean isChecked(String locator) {
		WebElement element = finder.findElement(locator);
		return element.isSelected();
	}

	
	//JavaScriptClick
		public void JavaScriptClick(String locator) {
			JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
			WebElement element = finder.findElement(locator);
			
			try {
				// 判断传入的element元素是否处于可单击状态，以及是否能显示在页面上
				if (element.isEnabled() && element.isDisplayed()) {
					Log.info("WebDriverEngine-使用JavaScript进行页面元素的单击");
					// 执行JavaScript语句arguments[0].click();
					//argumets[0]表示第一个参数，即element
					jsexecutor.executeScript("arguments[0].click();", element);
					this.pau_wait(10);
				} else {
					Log.error("WebDriverEngine-页面上的元素无法进行单击操作");
				}
			} catch (StaleElementReferenceException e) {
				Log.error("WebDriverEngine-页面元素没有附加在网页中"+e.getStackTrace());
			} catch (NoSuchElementException e) {
				Log.error("WebDriverEngine-在页面中没有找到要操作的元素"+e.getStackTrace());
			} catch (Exception e) {
				Log.error("WebDriverEngine-无法完成单击动作"+e.getStackTrace());
			}
		}
	
	public void click(String locator) {
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.click();
//			this.pause(3000);
			this.pau_wait(10);
		}
	}

	
	//长按
	public void clickLonger(String locator) {
		WebElement element = finder.findElement(locator);
		
		if (element != null) {
			runJs("window.scrollTo(0," + element.getLocation().x + ")");
			element.click();
//			this.pause(3000);
			this.pau_wait(10);
		}
	}

	
	//双击
	public void doubleClick(String locator) {
		WebElement element = finder.findElement(locator);
		Actions builder = new Actions(driver);
		builder.doubleClick(element).build().perform();
	}

	
	//元素是否存在
	public void isDisplayed(String locator) {
		WebElement element = finder.findElement(locator);
		if (element != null) {
			System.out.println(element.isDisplayed());
		}
	}

	
	public String getText(String locator) {

		return finder.findElement(locator).getText().trim();
	}

	
	//元素是否存在
	public boolean isElementPresent(String locator) {
		WebElement element = null;
		
		try {
			element = finder.findElement(locator);
		} catch (Exception e) {

			Log.info(e.getMessage());
		}
		if (element != null) {
			return true;
		}
		{
			return false;
		}
	}

	
	public String getValue(String locator) {

		return finder.findElement(locator).getAttribute("value");
	}

	
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	
	public void goBack() {
		driver.navigate().back();
	}

	
	public void refresh() {
		driver.navigate().refresh();
	}
	
	
	public void goForward() {

		driver.navigate().forward();
	}

	//下拉菜单动作
	public Select getSelect(String locator) {
	
		Select inputSelect = new Select(finder.findElement(locator));
		return inputSelect;
	}

	public void selectByValue(String locator, String value) {
	
		getSelect(locator).selectByValue(value);
		this.pause(5000);
	}
	
	public void selectByVisibleText(String locator, String value) {
	
		getSelect(locator).selectByVisibleText(value);
	}
	
	public void selectByIndex(String locator, int index) {
	
		getSelect(locator).selectByIndex(index);
	}

	
	//弹窗动作
	public Alert getAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	
	public String getAlertTest() {

		return getAlert().getText();
	}

	
	public void alertAccept() {

		getAlert().accept();
	}
	
	
	public void alertDismiss() {
		getAlert().dismiss();
	}
	
	
	public void alertSend(String value) {
		getAlert().sendKeys(value);
	}

	
	public String getHtmlSource() {
		return driver.getPageSource();
	}

	
	public void runJs(String js) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(js);
	}

	
	//拖拽
	public void dragAndDrop(String locator1,String locator2) {
		WebElement element1 =finder.findElement(locator1); 
		WebElement element2= finder.findElement(locator2); 
		(new Actions(driver)).dragAndDrop(element1, element2).perform();
	}
	
	
	//鼠标悬停
	public void mouseoverElement(String locator) {
		Actions action = new Actions(driver);
		WebElement ele = finder.findElement(locator);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);  
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);  
		
		action.moveToElement(finder.findElement(locator)).perform();
		this.pause(3000);
	}
	
	
	
	

	
	
	//切换窗口
	public void switchWidow(int i){
	    List<String> windows = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	    
	    	windows.add(handle);
	    }
	    driver.switchTo().window(windows.get(i));
	}
	
	
	//右键
	public void rightClickMouse(String locator) throws InterruptedException {
	
		action.contextClick(finder.findElement(locator)).perform();
		
	}
	
	
	//Tab键
	public void tapClick(){
	
		action.sendKeys(Keys.TAB).perform();;
	}
	
	
	public void tapType(String content){
		
			action.sendKeys(content).perform();
		}
	
	
 	public boolean ifContains(String content) {
		return driver.getPageSource().contains(content);
	}
	

	
}
