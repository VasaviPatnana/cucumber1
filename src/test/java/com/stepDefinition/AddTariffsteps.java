package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddTariffsteps {

	  WebDriver driver;

	@Given("The user is in Telecom domain")
	public void the_user_is_in_Telecom_domain() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SINDHU\\vasavi\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/");

	}

	@Given("the user click on Add Tariff Plan")
	public void the_user_click_on_Add_Tariff_Plan() {
		driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();

	}

	@When("the user is filling all the tariff details{string},{string},{string},{string},{string},{string},{string}")
	public void the_user_is_filling_all_the_tariff_details(String Monthrent, String Freeloc, String Freeint, String Freesms, String Localcharges, String Intercharges, String Smscharges) {
		driver.findElement(By.name("rental")).sendKeys(Monthrent);
		driver.findElement(By.name("local_minutes")).sendKeys(Freeloc);
		driver.findElement(By.name("inter_minutes")).sendKeys(Freeint);
		driver.findElement(By.name("sms_pack")).sendKeys(Freesms);
		driver.findElement(By.name("minutes_charges")).sendKeys(Localcharges);
		driver.findElement(By.name("inter_charges")).sendKeys(Intercharges);
		driver.findElement(By.name("sms_charges")).sendKeys(Smscharges);

	}

	@When("the user click on done button")
	public void the_user_click_on_done_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Then("the user should be displayed added tariff plan")
	public void the_user_should_be_displayed_added_tariff_plan() {
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).isDisplayed()); 

	}


}
