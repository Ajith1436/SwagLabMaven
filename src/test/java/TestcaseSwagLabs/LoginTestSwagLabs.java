package TestcaseSwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import PagesSwagLabs.LoginPageSwagLabs;

public class LoginTestSwagLabs extends BaseClassSwagLabs {
	@Test
	public void test1() throws FilloException, InterruptedException {
		Recordset recordset = connection.executeQuery("select * from data where TestName='test1'");
		recordset.next();
		
		String Username = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		LoginPageSwagLabs login = new LoginPageSwagLabs(driver);
		login.LoginFunctionswagLabs(Username, Password);
		
		WebElement title = driver.findElement(By.xpath("//span[@class='title']"));
		String ActualText = title.getText();
		String ExpText = "Products";
		Assert.assertEquals(ActualText, ExpText);
		
	}
	
	@Test
	public void test2() throws FilloException, InterruptedException {
		Recordset recordset = connection.executeQuery("select * from data where TestName='test2'");
		recordset.next();
		
		String Username = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		LoginPageSwagLabs login = new LoginPageSwagLabs(driver);
		login.LoginFunctionswagLabs(Username, Password);
		
		WebElement lockedUserError = driver.findElement(By.xpath("//h3[@data-test='error']"));
		String ActualError = lockedUserError.getText();
		String ExpError = "Epic sadface: Sorry, this user has been locked out.";
		Assert.assertEquals(ActualError, ExpError);
	}

}
