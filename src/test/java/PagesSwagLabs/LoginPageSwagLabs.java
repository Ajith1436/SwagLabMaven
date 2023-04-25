package PagesSwagLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSwagLabs {
	WebDriver Pagedriver;
	
	//==============Objects=============================//
	
	
	@FindBy(id = "user-name")
	WebElement UserNameTxt;
	
	@FindBy(id = "password")
	WebElement PasswordTxt;
	
	@FindBy(id = "login-button")
	WebElement LoginBtn;
	
	
	
	public LoginPageSwagLabs(WebDriver driver) {
		Pagedriver = driver;
		PageFactory.initElements(Pagedriver, this);

	}
	public void LoginFunctionswagLabs(String UserNameVal, String PasswordVal) throws InterruptedException {
		
		UserNameTxt.sendKeys(UserNameVal);
		PasswordTxt.sendKeys(PasswordVal);
		LoginBtn.click();
		Thread.sleep(3000);
	}

}
