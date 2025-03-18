package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	
	WebDriver driver; //globally declaring

	
	public Login_page(WebDriver driver) //constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this); //webelements initialize cheyyan anu
		                                       // static method anu 
	}
	
	@FindBy(xpath="//input[@type='text']")private WebElement username_Field;
	@FindBy(xpath="//input[@type='password']")private WebElement password_field;
	@FindBy(xpath="//button[@type='submit']")private WebElement signIn_button;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alertmsg;
	
	public void enterUserName(String username)
	{
		username_Field.sendKeys(username);
		
	}
	
	public void enterPassword(String password)
	{
		password_field.sendKeys(password);
		
	}
	
	public void clickSignIn()
	{
		signIn_button.click();
		
	}
	
	public boolean isHomePageLoaded()
	{
	    return dashboard.isDisplayed();
	}
	
	public boolean isAlertDisplayed()
	{
		return alertmsg.isDisplayed();
	}
	
	

}
