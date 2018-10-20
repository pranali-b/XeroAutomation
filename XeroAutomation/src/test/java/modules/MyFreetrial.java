package modules;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Scripts.ZeroReusableMethods;

public class MyFreetrial {
	public  WebDriver FreetrialXero(String firstName, String lastName,String userName,String phNo,String State,Properties objPro,Properties pro ,WebDriver driver) throws Exception {

		ZeroReusableMethods ob =new ZeroReusableMethods();
		WebElement firstname = driver.findElement(ob.getLocator("xero.freetrial.firstname",objPro));
		ob.enterText(firstname,firstName, "firstname");

		WebElement lastname = driver.findElement(ob.getLocator("xero.freetrial.lastname",objPro));
		ob.enterText(lastname,lastName, "lastname");

		WebElement un = driver.findElement(ob.getLocator("xero.freetrial.email",objPro));
		ob.enterText(un, userName, "userame");

		WebElement phno = driver.findElement(ob.getLocator("xero.freetrial.phno",objPro));
		ob.enterText(phno,phNo, "phno");

		WebElement state = driver.findElement(ob.getLocator("xero.freetrial.state",objPro));
		ob.clickObj(state,"state");
		
		return driver;

	}
}