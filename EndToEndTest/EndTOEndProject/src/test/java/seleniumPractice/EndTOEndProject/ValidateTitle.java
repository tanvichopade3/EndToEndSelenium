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

public class ValidateTitle extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	public landingPage landingPg;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void validationHeaderTitle() throws IOException {

		landingPg = new landingPage(driver);

		String homePageTitle = landingPg.getTitle().getText();
		System.out.println(homePageTitle);

		Assert.assertEquals(homePageTitle, "FEATURED COURSES");

		log.info("HomePage title validation");

	}

	@Test
	public void validationMoneyGuaranteeTitle() throws IOException {

		String moneyGuaranteeTitle = landingPg.getMoneyGuaranteeTitle().getText().toUpperCase();
		System.out.println(moneyGuaranteeTitle);

		Assert.assertEquals(moneyGuaranteeTitle, "30 DAY MONEY BACK GUARANTEE");

		log.info("Money Guarantee Title title validation");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
