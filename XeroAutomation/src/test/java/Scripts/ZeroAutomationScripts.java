package Scripts;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import modules.MyFreetrial;
import modules.MyLogin;
import modules.Mylogout;
import modules.PlansData;
import modules.SelfForm;

public class ZeroAutomationScripts extends ZeroReusableMethods {

public static void loginToZero() throws Exception {

		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		logger = extent.createTest("loginToZero");
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));
		
		MyLogin ml=new MyLogin();
		ml.loginXero(credpro.getProperty("loginusername"), credpro.getProperty("loginpassword"), objPro, pro, driver);

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}

	public static void incorrectEmail() throws Exception {
		logger = extent.createTest("incorrectEmail");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));


		/*Enter username to username field*/
		WebElement un = driver.findElement(getLocator("xero.login.username",objPro));
		enterText(un, credpro.getProperty("loginusername"), "userName");

		Thread.sleep(3000);
		/*Enter password to password field*/
		WebElement pwd = driver.findElement(getLocator("xero.login.password",objPro));
		enterText(pwd, "p123", "password");
		Thread.sleep(3000);

		/*Click login*/
		WebElement login = driver.findElement(getLocator("xero.login.loginbutton",objPro));
		clickObj(login, "Login Button");


		/*check error message */
		WebElement  LoginValidation = driver.findElement(getLocator("xero.incorrectemail.loginvalidation",objPro)) ;
		validate_Error_message(LoginValidation,
				"Login Validation", 
				"Your email or password is incorrect");


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}
	public static void forgotPassword() throws Exception {
		logger = extent.createTest("forgotPassword");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));

		/*forgot passwoed*/
		WebElement forgotpassword = driver.findElement(getLocator("xero.forgotpassword.forgotpasswordbutton",objPro));
		clickObj(forgotpassword, "forgotpassword Button");


		/*Enter username to username field*/
		WebElement un = driver.findElement(getLocator("xero.forgotpassword.email",objPro));
		enterText(un, credpro.getProperty("loginusername"), "userName");



		/*continue button*/
		WebElement continuebutton =driver.findElement(getLocator("xero.forgotpassword.continuebutton",objPro));
		clickObj(continuebutton, "continue Button");
		logger.log(Status.PASS, MarkupHelper.createLabel("Check Your Email.", ExtentColor.GREEN));

		Thread.sleep(3000);
		WebElement  passworreset = driver.findElement(getLocator("xero.forgotpassword.passwordreset",objPro)) ;
		validate_Error_message(passworreset,"Password reset message","pranali.lonkar030@gmail.com"); 


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}
	
	public static void freeTrial() throws Exception {
		logger = extent.createTest("freeTrial");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroFreeTrial"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero free trial is launched..", ExtentColor.GREEN));

		WebElement freetrial = driver.findElement(getLocator("xero.freetrial.freetrialbutton",objPro));
		clickObj(freetrial, "free trial Button");
		
		MyFreetrial mf=new MyFreetrial();
		mf.FreetrialXero(credpro.getProperty("firstname"), credpro.getProperty("lastname"),credpro.getProperty("loginusername"), credpro.getProperty("phno"),objPro.getProperty("xero.freetrial.state"),objPro, objPro, driver);
		
		WebElement checkbox = driver.findElement(getLocator("xero.freetrial.checkbox",objPro));
		clickObj(checkbox,"checkbox");


		WebElement getstarted = driver.findElement(getLocator("xero.freetrial.getstarted",objPro));
		clickObj(getstarted,"get started");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));



	}


	public static void freeTrialError() throws Exception {
		logger = extent.createTest("freeTrialError");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroFreeTrial"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero free trial is launched..", ExtentColor.GREEN));

		WebElement freetrial = driver.findElement(getLocator("xero.freetrial.freetrialbutton",objPro));
		clickObj(freetrial, "free trial Button");


		WebElement getstarted = driver.findElement(getLocator("xero.freetrial.getstarted",objPro));
		clickObj(getstarted,"get started");

		WebElement firstname = driver.findElement(getLocator("xero.freetrialerror.firstnameerror",objPro));
		validate_Error_message(firstname,"firstname error","First name can't be empty"); 


		WebElement lastname = driver.findElement(getLocator("xero.freetrialerror.lastnameerror",objPro));
		validate_Error_message(lastname,"lastname error","Last name can't be empty"); 

		WebElement email = driver.findElement(getLocator("xero.freetrialerror.emailerror",objPro));
		validate_Error_message(email,"email error","Email address can't be empty"); 

		WebElement phno = driver.findElement(getLocator("xero.freetrialerror.phnerror",objPro));
		validate_Error_message(phno,"phno error","Phone number can't be empty"); 

		MyFreetrial mf=new MyFreetrial();
		mf.FreetrialXero(credpro.getProperty("firstname"), 
				credpro.getProperty("lastname"),
				credpro.getProperty("loginusername"), 
				credpro.getProperty("phno"),
				objPro.getProperty("xero.freetrial.state"),
				objPro, 
				pro, 
				driver);
	

		WebElement getstarted1 = driver.findElement(getLocator("xero.freetrial.getstarted",objPro));
		clickObj(getstarted1,"get started");


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	public static void termsAndPrivacyLink() throws Exception {
		logger = extent.createTest("termsAndPrivacyLink");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroFreeTrial"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero free trial is launched..", ExtentColor.GREEN));


		WebElement freetrial = driver.findElement(getLocator("xero.freetrial.freetrialbutton",objPro));
		clickObj(freetrial, "free trial Button");


		WebElement getstarted = driver.findElement(getLocator("xero.freetrial.getstarted",objPro));
		clickObj(getstarted,"get started");

		WebElement termslink = driver.findElement(getLocator("xero.termsAndPrivacyLink.termslink",objPro));
		clickObj(termslink,"terms link");
		logger.log(Status.PASS, MarkupHelper.createLabel("Terms of page is opened..", ExtentColor.GREEN));


		WebElement privacypolicy = driver.findElement(getLocator("xero.termsAndPrivacyLink.privacypolicy",objPro));
		clickObj(privacypolicy,"privacy policy link");
		logger.log(Status.PASS, MarkupHelper.createLabel("privacy policy page is opened..", ExtentColor.GREEN));


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	public static void offerLink() throws Exception {
		logger = extent.createTest("offerLink");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroFreeTrial"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero free trial is launched..", ExtentColor.GREEN));

		WebElement freetrial = driver.findElement(getLocator("xero.freetrial.freetrialbutton",objPro));
		clickObj(freetrial, "free trial Button");

		WebElement offerlink = driver.findElement(getLocator("xero.offerlink.offerlinkbtn",objPro));
		clickObj(offerlink,"offer link");
		
		logger.log(Status.PASS, MarkupHelper.createLabel("offer details page is opened..", ExtentColor.GREEN));


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}
	public static void bookkeeperLink() throws Exception {
		logger = extent.createTest("bookkeeperLink");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroFreeTrial"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero free trial is launched..", ExtentColor.GREEN));

		WebElement freetrial = driver.findElement(getLocator("xero.freetrial.freetrialbutton",objPro));
		clickObj(freetrial, "free trial Button");


		WebElement bookkeeper = driver.findElement(getLocator("xero.bookkeeperLink.bookkeeper",objPro));
		clickObj(bookkeeper,"bookkeeper link");
		logger.log(Status.PASS, MarkupHelper.createLabel("let's start a great partnership page is opened..", ExtentColor.GREEN));


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}
	public static void allTabs() throws Exception {
		logger = extent.createTest("allTabs");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));


		MyLogin ml=new MyLogin();
		ml.loginXero(credpro.getProperty("loginusername"), credpro.getProperty("loginpassword"), objPro, pro, driver);

		WebElement dashboard = driver.findElement(getLocator("xero.allTabs.dashboard",objPro)) ;
		clickObj(dashboard, "dashboard Button");


		WebElement account = driver.findElement(getLocator("xero.allTabs.account",objPro)) ;
		clickObj(account, "dashboard Button");

		WebElement report = driver.findElement(getLocator("xero.allTabs.report",objPro)) ;
		clickObj(report, "report Button");

		WebElement contacts = driver.findElement(getLocator("xero.allTabs.contacts",objPro)) ;
		clickObj(contacts, "contacts Button");

		WebElement settings = driver.findElement(getLocator("xero.allTabs.settings",objPro)) ;
		clickObj(settings, "settings Button");

		WebElement newbutton = driver.findElement(getLocator("xero.allTabs.newbtn",objPro)) ;
		clickObj(newbutton, "new Button");

		WebElement files = driver.findElement(getLocator("xero.allTabs.files",objPro)) ;
		clickObj(files, "files Button");

		Thread.sleep(3000);

		WebElement search = driver.findElement(getLocator("xero.allTabs.search",objPro)) ;
		clickObj(search, "search Button");
		Thread.sleep(3000);

		WebElement help = driver.findElement(getLocator("xero.allTabs.help",objPro)) ;
		clickObj(help, "help Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}
	public static void logoutProfile() throws Exception {
		logger = extent.createTest("logoutProfile");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));


		MyLogin ml=new MyLogin();
		ml.loginXero(credpro.getProperty("loginusername"), credpro.getProperty("loginpassword"), objPro, pro, driver);


		Mylogout lx = new Mylogout();
		lx.LogoutXero(objPro.getProperty("xero.logoutProfile.profilebtn"), 
				objPro.getProperty("xero.logoutProfile.logout"), 
				objPro, pro, driver);
		
		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	public static void profileImage() throws Exception {
		logger = extent.createTest("profileImage");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));



		MyLogin ml=new MyLogin();
		ml.loginXero(credpro.getProperty("loginusername"), credpro.getProperty("loginpassword"), objPro, pro, driver);

		WebElement profilebutton = driver.findElement(getLocator("xero.logoutProfile.profilebtn",objPro)) ;
		clickObj(profilebutton, "profile button");

		WebElement profile = driver.findElement(getLocator("xero.profileImage.profile",objPro)) ;
		clickObj(profile, "profile");

		WebDriverWait wait=new WebDriverWait(driver, 20);

		//WebElement uploadimage=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='button-1041-btnEl']"))) ;
		//clickObj(uploadimage, "upload image button");

		Thread.sleep(6000);
		//WebElement browsePhoto=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='filefield-1258-button-fileInputEl']")));
		//enterText(browsePhoto, "/Users/pranalibankar/Downloads/pp.png", "browse Photo button");


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	public static void addOrganizationTrailVersion() throws Exception {
		logger = extent.createTest("addOrganizationTrailVersion");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));


		MyLogin ml=new MyLogin();
		ml.loginXero(credpro.getProperty("secondloginusername"), credpro.getProperty("secondloginpassword"), objPro, pro, driver);

		SelfForm sf= new SelfForm();
		sf.SelfXero(objPro.getProperty("xero.addOrganizationTrailVersion.self"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.myxero"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.runorganization"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.orgname"),
				objPro.getProperty("xero.addOrganizationTrailVersion.stateorg"),
				objPro.getProperty("xero.addOrganizationTrailVersion.timezone"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.selecttimezone"),
				objPro.getProperty("xero.addOrganizationTrailVersion.oranizationdo"), 
				objPro, pro, driver);
		
		WebElement starttrail = driver.findElement(getLocator("xero.addOrganizationTrailVersion.starttrail",objPro)) ;
		clickObj(starttrail, " starttrail Button");

		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	public static void addOrganizationPaidVersion() throws Exception {
		logger = extent.createTest("addOrganizationPaidVersion");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));



		MyLogin ml=new MyLogin();
		ml.loginXero(credpro.getProperty("secondloginusername"), credpro.getProperty("secondloginpassword"), objPro, pro, driver);

		SelfForm sf= new SelfForm();
		sf.SelfXero(objPro.getProperty("xero.addOrganizationTrailVersion.self"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.myxero"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.runorganization"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.orgname"),
				objPro.getProperty("xero.addOrganizationTrailVersion.stateorg"),
				objPro.getProperty("xero.addOrganizationTrailVersion.timezone"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.selecttimezone"),
				objPro.getProperty("xero.addOrganizationTrailVersion.oranizationdo"), 
				objPro, pro, driver);
		Thread.sleep(3000);

		WebElement rndmclk = driver.findElement(getLocator("xero.addOrganizationPaidVersion.randmclk",objPro)) ;
		clickObj(rndmclk, "rndmclk Button");

		WebElement buynow = driver.findElement(getLocator("xero.addOrganizationPaidVersion.buynow",objPro)) ;
		clickObj(buynow, "buy now Button");

		Thread.sleep(3000);
		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));



	}
	public static void starterPlan() throws Exception {
		logger = extent.createTest("starterPlan");
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));


		MyLogin ml=new MyLogin();
		ml.loginXero(credpro.getProperty("secondloginusername"), credpro.getProperty("secondloginpassword"), objPro, pro, driver);

		SelfForm sf= new SelfForm();
		sf.SelfXero(objPro.getProperty("xero.addOrganizationTrailVersion.self"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.myxero"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.runorganization"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.orgname"),
				objPro.getProperty("xero.addOrganizationTrailVersion.stateorg"),
				objPro.getProperty("xero.addOrganizationTrailVersion.timezone"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.selecttimezone"),
				objPro.getProperty("xero.addOrganizationTrailVersion.oranizationdo"), 
				objPro, pro, driver);
		Thread.sleep(3000);

		WebElement rndmclk = driver.findElement(getLocator("xero.addOrganizationPaidVersion.randmclk",objPro)) ;
		clickObj(rndmclk, "rndmclk Button");

		WebElement buynow = driver.findElement(getLocator("xero.addOrganizationPaidVersion.buynow",objPro)) ;
		clickObj(buynow, "buy now Button");

		Thread.sleep(3000);

		WebElement starterplan = driver.findElement(getLocator("xero.starterPlan.starterplanbtn",objPro)) ;
		clickObj(starterplan, "starter plan Button");


		WebElement continuebillingacnt = driver.findElement(getLocator("xero.starterPlan.continuebillingacnt",objPro)) ;
		clickObj(continuebillingacnt, "continue Button");

		PlansData pd = new PlansData();
		pd.PlansXero(objPro.getProperty("xero.starterPlan.validstreet"), 
				objPro.getProperty("xero.starterPlan.contactcity"), 
				objPro.getProperty("xero.starterPlan.selectstateop"), 
				objPro.getProperty("xero.starterPlan.selectstate"), 
				objPro.getProperty("xero.starterPlan.zipcode"),
				objPro.getProperty("xero.starterPlan.continuepay"), 
				objPro, pro, driver);
		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}


	public static void standardPlan() throws Exception {
		logger = extent.createTest("starterPlan");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
	
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));

		MyLogin ml=new MyLogin();
		ml.loginXero(credpro.getProperty("secondloginusername"), credpro.getProperty("secondloginpassword"), objPro, pro, driver);

		SelfForm sf= new SelfForm();
		sf.SelfXero(objPro.getProperty("xero.addOrganizationTrailVersion.self"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.myxero"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.runorganization"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.orgname"),
				objPro.getProperty("xero.addOrganizationTrailVersion.stateorg"),
				objPro.getProperty("xero.addOrganizationTrailVersion.timezone"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.selecttimezone"),
				objPro.getProperty("xero.addOrganizationTrailVersion.oranizationdo"), 
				objPro, pro, driver);
		Thread.sleep(3000);

		WebElement rndmclk = driver.findElement(getLocator("xero.addOrganizationPaidVersion.randmclk",objPro)) ;
		clickObj(rndmclk, "rndmclk Button");

		WebElement buynow = driver.findElement(getLocator("xero.addOrganizationPaidVersion.buynow",objPro)) ;
		clickObj(buynow, "buy now Button");

		Thread.sleep(3000);

		WebElement standardplan = driver.findElement(getLocator("xero.standardplan.standardplanbtn",objPro)) ;
		clickObj(standardplan, "standard plan Button");


		WebElement continuebillingacnt = driver.findElement(getLocator("xero.starterPlan.continuebillingacnt",objPro)) ;
		clickObj(continuebillingacnt, "continue Button");

		PlansData pd = new PlansData();
		pd.PlansXero(objPro.getProperty("xero.starterPlan.validstreet"), 
				objPro.getProperty("xero.starterPlan.contactcity"), 
				objPro.getProperty("xero.starterPlan.selectstateop"), 
				objPro.getProperty("xero.starterPlan.selectstate"), 
				objPro.getProperty("xero.starterPlan.zipcode"),
				objPro.getProperty("xero.starterPlan.continuepay"), 
				objPro, pro, driver);
		
		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));

	}

	public static void premiumPlan() throws Exception {
		logger = extent.createTest("premiumPlan");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));

		MyLogin ml=new MyLogin();
		ml.loginXero(credpro.getProperty("secondloginusername"), credpro.getProperty("secondloginpassword"), objPro, pro, driver);


		SelfForm sf= new SelfForm();
		sf.SelfXero(objPro.getProperty("xero.addOrganizationTrailVersion.self"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.myxero"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.runorganization"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.orgname"),
				objPro.getProperty("xero.addOrganizationTrailVersion.stateorg"),
				objPro.getProperty("xero.addOrganizationTrailVersion.timezone"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.selecttimezone"),
				objPro.getProperty("xero.addOrganizationTrailVersion.oranizationdo"), 
				objPro, pro, driver);
		Thread.sleep(3000);

		WebElement rndmclk = driver.findElement(getLocator("xero.addOrganizationPaidVersion.randmclk",objPro)) ;
		clickObj(rndmclk, "rndmclk Button");

		WebElement buynow = driver.findElement(getLocator("xero.addOrganizationPaidVersion.buynow",objPro)) ;
		clickObj(buynow, "buy now Button");

		Thread.sleep(3000);
		WebElement premiumplan = driver.findElement(getLocator("xero.premiumplan.premiumplanbtn",objPro)) ;
		clickObj(premiumplan, "premium plan Button");


		WebElement continuebillingacnt = driver.findElement(getLocator("xero.starterPlan.continuebillingacnt",objPro)) ;
		clickObj(continuebillingacnt, "continue Button");

		PlansData pd = new PlansData();
		pd.PlansXero(objPro.getProperty("xero.starterPlan.validstreet"), 
				objPro.getProperty("xero.starterPlan.contactcity"), 
				objPro.getProperty("xero.starterPlan.selectstateop"), 
				objPro.getProperty("xero.starterPlan.selectstate"), 
				objPro.getProperty("xero.starterPlan.zipcode"),
				objPro.getProperty("xero.starterPlan.continuepay"), 
				objPro, pro, driver);
		
		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	public static void quickBooksUser() throws Exception {
		logger = extent.createTest("quickBooksUser");
		
		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));

		MyLogin ml=new MyLogin();
		ml.loginXero(credpro.getProperty("secondloginusername"), credpro.getProperty("secondloginpassword"), objPro, pro, driver);

		SelfForm sf= new SelfForm();
		sf.SelfXero(objPro.getProperty("xero.addOrganizationTrailVersion.self"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.myxero"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.runorganization"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.orgname"),
				objPro.getProperty("xero.addOrganizationTrailVersion.stateorg"),
				objPro.getProperty("xero.addOrganizationTrailVersion.timezone"), 
				objPro.getProperty("xero.addOrganizationTrailVersion.selecttimezone"),
				objPro.getProperty("xero.addOrganizationTrailVersion.oranizationdo"), 
				objPro, pro, driver);
		
		Thread.sleep(3000);

		WebElement rndmclk = driver.findElement(getLocator("xero.addOrganizationPaidVersion.randmclk",objPro)) ;
		clickObj(rndmclk, "rndmclk Button");

		WebElement setuplink = driver.findElement(getLocator("xero.quickBooksUser.setuplink",objPro)) ;
		clickObj(setuplink, "setuplink Button");


		WebElement checkboxbtn = driver.findElement(getLocator("xero.quickBooksUser.checkboxbtn",objPro)) ;
		Thread.sleep(3000);
		clickObj(checkboxbtn, "checkbox Button");

		Thread.sleep(3000);

		WebElement buynow = driver.findElement(getLocator("xero.quickBooksUser.buynow",objPro)) ;
		clickObj(buynow, "buy now Button");


		Thread.sleep(3000);
		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	public static void accountsButton() throws Exception {
		logger = extent.createTest("accountsButton");

		String propertyPath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/Configuration.properties";
		Properties pro=loadPropertyFile(propertyPath);

		String credentialspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/datafiles/usercredentials.properties";
		Properties credpro=loadPropertyFile(credentialspath);
		
		String objectspath="/Users/pranalibankar/eclipse-workspace/XeroAutomation/src/test/resources/objectsRepo/objects.properties";
		Properties objPro=loadPropertyFile(objectspath);
		
		IntializeDriver("firefox", pro.getProperty("firefoxpath"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox driver is launched", ExtentColor.GREEN));


		driver.get(pro.getProperty("ZeroUrl"));
		//driver.get(pro.getProperty("implicitwait"));

		logger.log(Status.PASS, MarkupHelper.createLabel("Zero login page is launched..", ExtentColor.GREEN));

		MyLogin ml=new MyLogin();
		ml.loginXero(credpro.getProperty("loginusername"), credpro.getProperty("loginpassword"), objPro, pro, driver);

		WebElement account = driver.findElement(getLocator("xero.accountsButton.account",objPro)) ;
		clickObj(account, "dashboard Button");

		WebElement purchase = driver.findElement(getLocator("xero.accountsButton.purchase",objPro)) ;
		clickObj(purchase, "purchase Button");

		WebElement bill = driver.findElement(getLocator("xero.accountsButton.bill",objPro)) ;
		clickObj(bill, "bill Button");


		Thread.sleep(3000);


		closeDriver();
		logger.log(Status.PASS, MarkupHelper.createLabel("Firefox browser is Closed...", ExtentColor.GREEN));


	}

	
}
