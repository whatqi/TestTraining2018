package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObject.LoginPage;


public class Login_Action {
	public static void execute(WebDriver wd,String name,String password) throws Exception {
		wd.get("http://localhost:8032/mymovie");
		pageObject.LoginPage mPage = new pageObject.LoginPage(wd);
		mPage.getLink().click();
		
	}

}
