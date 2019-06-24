package com.stepDefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomerSteps1 {
	WebDriver driver;
	@Given("user is in telecom domain")
	public void user_is_in_telecom_domain() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SINDHU\\vasavi\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/");

	}

	@Given("the user clicked on Add customer")
	public void the_user_clicked_on_Add_customer() {
		driver.findElement(By.xpath("//a[text()='Add Customer'][1]")).click();

	}


		
		@When("the user has filling all the details")
		public void the_user_has_filling_all_the_details(DataTable CustomerDetails1) {
		    Map<String, String> CustomerDetails1Map = CustomerDetails1.asMap(String.class,String.class);
		    System.out.println(CustomerDetails1Map);
		    driver.findElement(By.xpath("//label[@for='done']")).click();
			driver.findElement(By.name("fname")).sendKeys(CustomerDetails1Map.get("Firstname"));
			driver.findElement(By.name("lname")).sendKeys(CustomerDetails1Map.get("Lastname"));
			driver.findElement(By.id("email")).sendKeys(CustomerDetails1Map.get("Email ID"));
			driver.findElement(By.name("addr")).sendKeys(CustomerDetails1Map.get("Address"));
			driver.findElement(By.name("telephoneno")).sendKeys(CustomerDetails1Map.get("Telephone No"));

		}

		@When("the user clicked on Submit button")
		public void the_user_clicked_on_Submit_button() {
			driver.findElement(By.xpath("//input[@type='submit']")).click();

		}

		@Then("the user will be displayed ID")
		public void the_user_will_be_displayed_ID() {
			   Assert.assertTrue(driver.findElement(By.xpath("//td[@align='center'][2]")).isDisplayed()); 

		}




}
