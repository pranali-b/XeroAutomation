package modules;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Scripts.ZeroReusableMethods;

public class Mylogout {
	public WebDriver LogoutXero(String profileButton, String logOut,Properties objPro,Properties pro,WebDriver driver) throws Exception {
		
		ZeroReusableMethods ob =new ZeroReusableMethods();
		
		WebElement profilebutton = driver.findElement(ob.getLocator("xero.logoutProfile.profilebtn",objPro)) ;
		ob.clickObj(profilebutton, "profile button");

		WebElement logout = driver.findElement(ob.getLocator("xero.logoutProfile.logout",objPro)) ;
		ob.clickObj(logout, "logout Button");


		return driver;


	}
}
