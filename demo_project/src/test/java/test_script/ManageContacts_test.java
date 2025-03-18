package test_script;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_page;
import pages.ManageContacts_page;
import utilities.Exel_utilities;

public class ManageContacts_test extends Base 
{   
	
	@Test
	public void manageContact() throws Exception
	{
//		String username="admin";
//		String password="admin";
//		
//		String phone="7561053532";
//		String email="stigASD@gmail.com";
//		String address="Broadcast Centre,201 Wood,London";
//		String deliveryTime="30 min";
//		String deliveryCharge="350";
		
		
		String username=Exel_utilities.getStringdata(1,0,"loginpage");
		String password= Exel_utilities.getStringdata(1,1,"loginpage");
		String phone=Exel_utilities.getIntegerdata(2,0,"managecontact");
		String email= Exel_utilities.getStringdata(2,1,"managecontact");
		String address= Exel_utilities.getStringdata(2,2,"managecontact");
		String deliveryTime= Exel_utilities.getIntegerdata(2,3,"managecontact");
		String deliveryCharge= Exel_utilities.getIntegerdata(2,4,"managecontact");
		
		Login_page login=new Login_page(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickSignIn();
		login.isHomePageLoaded();
		
		
		ManageContacts_page manageContact=new ManageContacts_page(driver);
		
		manageContact.loginButton();
	
		manageContact.enterContacts(phone,email,address,deliveryTime,deliveryCharge);
		boolean verifyAlert=manageContact.isAlertLoaded();
		Assert.assertTrue(verifyAlert, "error successfull logins");
		
		
		
		
		
		
	}
	
	

}
