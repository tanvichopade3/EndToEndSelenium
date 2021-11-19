package seleniumPractice.EndTOEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pageObjects.landingPage;
import resources.base;

public class ValidateNavigationBar extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() throws IOException {

		landingPage landingPg = new landingPage(driver);

		Boolean val = landingPg.getNavigationBar().isDisplayed();
		// System.out.println("val - " + val);
		Assert.assertTrue(val);
		// .nav.navbar-nav.navbar-right
		log.info("Navigation bar validation");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
