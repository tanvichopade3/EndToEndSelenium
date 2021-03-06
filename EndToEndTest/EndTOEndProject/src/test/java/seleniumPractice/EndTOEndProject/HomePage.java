package seleniumPractice.EndTOEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String password, String text) throws IOException {

		driver.get(prop.getProperty("url"));

		landingPage landingPg = new landingPage(driver);
		WebElement loginLink = landingPg.getLogin();
		loginLink.click();

		loginPage loginPg = new loginPage(driver);
		loginPg.getEmail().sendKeys(userName);
		loginPg.getPassword().sendKeys(password);
//		System.out.println("text value - " + text);
		log.info("text value - " + text);
		loginPg.getLoginButton().click();

		log.info("login is successful");
	}

	@DataProvider
	public Object[][] getData() {

		// row i.e. 2 - stands for how many times test-case should run
		// coloumn i.e. 3 - stands for how many values per each test
		Object[][] data = new Object[2][3];

		data[0][0] = "nonrestrictedUser@ds.com";
		data[0][1] = "Password";
		data[0][2] = "nonrestrictedUser";

		data[1][0] = "restrictedUser@ds.com";
		data[1][1] = "Password";
		data[1][2] = "restrictedUser";

		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
