package test_script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends Base {
	
	@Test
	public void userinput()
	{
		

		
		String username="admin";
		String password="admin";
		WebElement username_field=driver.findElement(By.xpath("//input[@type='text']"));
		WebElement password_field=driver.findElement(By.xpath("//input[@type='password']"));
		WebElement signIn_button=driver.findElement(By.xpath("//button[@type='submit']"));
		username_field.sendKeys(username);
		password_field.sendKeys(password);
		signIn_button.click();
		
		WebElement dashboard=driver.findElement(By.xpath("//p[text()='Dashboard']"));
		boolean verify = dashboard.isDisplayed();
		Assert.assertTrue(verify,"Error login");
		
		
		
	
	}

}
