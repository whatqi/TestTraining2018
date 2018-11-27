package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webtest.utils.ObjectMap;


/** 
* author:shenmengqi 
* @version 创建时间：2018年11月27日 下午2:31:54 
*  登录页面操作 
*/

public class LoginPage {
		public WebElement element;
		public WebDriver driver;
		ObjectMap objMap = new ObjectMap("conf/login.properties");
		
		public LoginPage(WebDriver wd) {
			this.driver = wd;
		}
		
		public WebElement getLink() throws Exception {
			this.element =driver.findElement(objMap.getlocator("main.link"));
			return element;
		}
	

}
