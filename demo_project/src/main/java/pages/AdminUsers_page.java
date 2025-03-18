package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Page_utilities;
import utilities.Wait_utilities;

public class AdminUsers_page 
{
	
	public WebDriver driver; //globally
	
	public AdminUsers_page(WebDriver driver)  //constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")private WebElement moreinfo_button ;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement new_button;
	@FindBy(xpath="//input[@id='username']")private WebElement adminUsername_field ;
	@FindBy(xpath="//input[@id='password']")private WebElement adminPassword_field;
	@FindBy(xpath="//select[@id='user_type']")private WebElement userTypeDropdown_field ;
	@FindBy(xpath="(//button[@class='btn btn-block-sm btn-danger'])[2]")private WebElement save_button ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement userInputSuccessAlert_box ;
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[1]")private WebElement userDetails_deleteButton ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement userDeleteSuccessAlert_box ;

	
	public void moreinfo_AdminUser() 
	{
		moreinfo_button.click();

		
	}
	public void newUser()
	{
		new_button.click();
	}
	
	public void Input_AdminUserName(String admin_username)
	{
		adminUsername_field.sendKeys(admin_username);
		
		
	}
	public void Input_AdminUserPassword(String admin_password)
	{
		adminPassword_field.sendKeys(admin_password);
	}
	
	public void userDetails_dropdown()
	{
//		Select select =new Select(userTypeDropdown_field);
//		select.selectByIndex(2);
		
		Page_utilities pageutilities=new Page_utilities();
		pageutilities.selectByIndex(userTypeDropdown_field, 2);
	}
	
	public void save_Userdetails()
	{  
		Wait_utilities waitutilities=new Wait_utilities();
		waitutilities.waitForElementToBeClickable(driver,save_button);
		save_button.click();
	}
	
	public boolean isUserInput_AlertBoxLoaded()
	{
		return userInputSuccessAlert_box.isDisplayed();
	}
	
	
	public void deleteAdminUserInformation()
	{
		userDetails_deleteButton.click();
		driver.switchTo().alert().accept();
	
	}
	public boolean isUserDelete_AlertBoxLoaded()
	{
		return userDeleteSuccessAlert_box.isDisplayed();
	}

}
