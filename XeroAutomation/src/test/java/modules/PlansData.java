package modules;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Scripts.ZeroReusableMethods;

public class PlansData {
	public WebDriver PlansXero(String validStreet, String contactCity,String selectStateOp,String selectState,String zipCode,String continuePay,Properties objPro,Properties pro,WebDriver driver) throws Exception {
		ZeroReusableMethods ob =new ZeroReusableMethods();

		WebElement validstreet = driver.findElement(ob.getLocator("xero.starterPlan.validstreet",objPro)) ;
		ob.enterText(validstreet, "3450 granada ave", "valid street name");


		WebElement contactcity = driver.findElement(ob.getLocator("xero.starterPlan.contactcity",objPro)) ;
		ob.enterText(contactcity, "santa clara", "contact city  name");

		WebElement selectstateop = driver.findElement(ob.getLocator("xero.starterPlan.selectstateop",objPro)) ;
		ob.clickObj(selectstateop, "select Button");

		WebElement selectstate = driver.findElement(ob.getLocator("xero.starterPlan.selectstate",objPro)) ;
		ob.clickObj(selectstate, "select state Button");

		Thread.sleep(3000);

		WebElement zipcode = driver.findElement(ob.getLocator("xero.starterPlan.zipcode",objPro)) ;
		ob.enterText(zipcode, "95051", "zip code name");

		WebElement continuepay = driver.findElement(ob.getLocator("xero.starterPlan.continuepay",objPro)) ;
		ob.clickObj(continuepay, "continue pay Button");
		
		return driver;
		


	}
}
