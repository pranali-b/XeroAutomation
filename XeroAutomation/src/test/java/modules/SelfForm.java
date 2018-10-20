package modules;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Scripts.ZeroReusableMethods;

public class SelfForm {
	
	public WebDriver SelfXero(String Self, String MyXero,String runOrganization,String orgName,String stateOrg,String timeZone,String selectTimeZone,String oranizationDo,Properties objPro,Properties pro,WebDriver driver) throws Exception {
		ZeroReusableMethods ob =new ZeroReusableMethods();
		WebElement self = driver.findElement(ob.getLocator("xero.addOrganizationTrailVersion.self",objPro)) ;
		ob.clickObj(self, "self Button");

		WebElement myxero = driver.findElement(ob.getLocator("xero.addOrganizationTrailVersion.myxero",objPro)) ;
		ob.clickObj(myxero, "myxero Button");

		WebElement runorganization = driver.findElement(ob.getLocator("xero.addOrganizationTrailVersion.runorganization",objPro)) ;
		ob.clickObj(runorganization, "runorganization Button");
		Thread.sleep(3000);
		
		WebElement orgname = driver.findElement(ob.getLocator("xero.addOrganizationTrailVersion.orgname",objPro)) ;
		ob.enterText(orgname, "self", "organization name");

		WebElement stateorg = driver.findElement(ob.getLocator("xero.addOrganizationTrailVersion.stateorg",objPro)) ;
		ob.clickObj(stateorg, "state organization Button");

		WebElement timezone = driver.findElement(ob.getLocator("xero.addOrganizationTrailVersion.timezone",objPro)) ;
		ob.clickObj(timezone, "time zone Button");

		WebElement selecttimezone = driver.findElement(ob.getLocator("xero.addOrganizationTrailVersion.selecttimezone",objPro)) ;
		ob.clickObj(selecttimezone, "select time zone Button");


		WebElement oranizationdo = driver.findElement(ob.getLocator("xero.addOrganizationTrailVersion.oranizationdo",objPro)) ;
		ob.enterText(oranizationdo, "Accounting", "oranizationdo name");

		return driver;


}
}
