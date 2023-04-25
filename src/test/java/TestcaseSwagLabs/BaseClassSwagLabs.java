package TestcaseSwagLabs;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassSwagLabs {
	public WebDriver driver;
	Fillo fillo;
	Connection connection;

	@BeforeTest
	public void Reportsetup() throws FilloException {
		// report = new ExtentReports("ExtendReports.html");
		fillo = new Fillo();
		connection = fillo.getConnection("DataSheet.xlsx");
	}

	@BeforeMethod
	public void setup(Method method) {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

		// step-2: Maximize the browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

	}

	@AfterMethod
	public void teardown() {
		// report.endTest(test);
		driver.quit();

	}
}
