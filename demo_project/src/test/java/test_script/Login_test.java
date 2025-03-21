	package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_page;
import utilities.Exel_utilities;

public class Login_test extends Base  {
	
	@Test(priority=1,groups={"Regression"},retryAnalyzer=retry.Retry.class,description="verifying login using usernam and password")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
//		String username="admin";
//		String password="admin";
		
		String username=Exel_utilities.getStringdata(1,0,"loginpage");
		String password=Exel_utilities.getStringdata(1,1,"loginpage");
		Login_page pagelogin=new Login_page(driver);  //creating object of the other clas
		pagelogin.enterUserName(username);
		pagelogin.enterPassword(password);
		pagelogin.clickSignIn();
		boolean isloaded = pagelogin.isHomePageLoaded();
		Assert.assertTrue(isloaded,"Home page not loading when correct user credential is given");
	}
	
	@Test(priority=2)
	public void verifyInvalidpasswordEntry()
	{
		String username="admin";
		String password="hello";
		
		Login_page pagelogin=new Login_page(driver);  //creating object of the other clas
		pagelogin.enterUserName(username);
		pagelogin.enterPassword(password);
		pagelogin.clickSignIn();
		boolean checkAlert = pagelogin.isAlertDisplayed();
		Assert.assertTrue(checkAlert, "not displayed");
		
		
	}
	
	@Test(priority=3)
	public void verifyInvalidUserEntry()
	{
		String username="fake";
		String password="admin";
		
		Login_page pagelogin=new Login_page(driver);  //creating object of the other clas
		pagelogin.enterUserName(username);
		pagelogin.enterPassword(password);
		pagelogin.clickSignIn();
		boolean checkAlert = pagelogin.isAlertDisplayed();
		Assert.assertTrue(checkAlert, "not displayed");
	}
	
	@Test(priority=4)
	public void verifyInvalidUsernameAndPassword()
	{
		String username="fake";
		String password="haha";
		
		Login_page pagelogin=new Login_page(driver);  //creating object of the other clas
		pagelogin.enterUserName(username);
		pagelogin.enterPassword(password);
		pagelogin.clickSignIn();
		boolean checkAlert = pagelogin.isAlertDisplayed();
		Assert.assertTrue(checkAlert, "not displayed");

		
	}
	
	
	
	

}
