package test_script;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pages.AdminUsers_page;
import pages.Login_page;
import utilities.Faker_utilities;

public class AdminUsers_test extends Base {

	@Test(priority = 1,invocationCount=3)
	public void input_AdminUserDetails() {

		String username = "admin";
		String password = "admin";
//		String admin_username = "The Stig";
//		String admin_password = "topgear";
		Faker_utilities fakerutilities=new Faker_utilities();           //usig FAKER  for random inputs
		String admin_username=fakerutilities.creatARandomFirstName();
		String admin_password=fakerutilities.creatARandomLastName();
		// login
		Login_page loginobject = new Login_page(driver);
		loginobject.enterUserName(username);
		loginobject.enterPassword(password);
		loginobject.clickSignIn();
		loginobject.isHomePageLoaded();

		AdminUsers_page adminUserInput = new AdminUsers_page(driver);

		adminUserInput.moreinfo_AdminUser();
		adminUserInput.newUser();
		adminUserInput.Input_AdminUserName(admin_username);
		adminUserInput.Input_AdminUserPassword(admin_password);
		adminUserInput.userDetails_dropdown();
		adminUserInput.save_Userdetails();
		adminUserInput.isUserInput_AlertBoxLoaded();

	}

	@Test(priority = 2)
	public void delete_AdminUserDetails() {
		String username = "admin";
		String password = "admin";
		
		String admin_username = "The Stig";
		String admin_password = "topgear";
		
		
		// login
		Login_page loginobject = new Login_page(driver);
		loginobject.enterUserName(username);
		loginobject.enterPassword(password);
		loginobject.clickSignIn();
		loginobject.isHomePageLoaded(); // verify alert

		AdminUsers_page adminUserdelete = new AdminUsers_page(driver);

		adminUserdelete.moreinfo_AdminUser();
		adminUserdelete.newUser();
		
       
      
        
		adminUserdelete.deleteAdminUserInformation();
		adminUserdelete.isUserDelete_AlertBoxLoaded(); // alert verifying

	}

}
