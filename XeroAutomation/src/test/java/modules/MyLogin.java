package modules;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Scripts.ZeroReusableMethods;

public class MyLogin {

	public  WebDriver loginXero(String userName, String password, Properties objPro, Properties pro ,WebDriver driver) throws Exception {
		ZeroReusableMethods ob =new ZeroReusableMethods();

		/*Enter username to username field*/
		WebElement un = driver.findElement(ob.getLocator("xero.login.username",objPro));
		ob.enterText(un, userName, "userName");

		Thread.sleep(3000);
		/*Enter password to password field*/
		WebElement pwd = driver.findElement(ob.getLocator("xero.login.password",objPro));
		ob.enterText(pwd, password, "password");
		Thread.sleep(3000);

		/*Click login*/
		WebElement login = driver.findElement(ob.getLocator("xero.login.loginbutton",objPro));
		ob.clickObj(login, "Login Button");

		return driver;

	}
}