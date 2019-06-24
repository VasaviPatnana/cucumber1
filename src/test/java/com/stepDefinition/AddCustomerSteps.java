package com.stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomerSteps {
    WebDriver driver;

	@Given("The user is in telecom domain")
	public void the_user_is_in_telecom_domain() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SINDHU\\vasavi\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/");

	}

	@Given("the user click on Add customer")
	public void the_user_click_on_Add_customer() {
		driver.findElement(By.xpath("//a[text()='Add Customer'][1]")).click();

	}

	@When("the user is filling all the details")
	public void the_user_is_filling_all_the_details(DataTable CustomerDetails) {
	    List<String> CustomerDetailslist= CustomerDetails.asList(String.class);
	    System.out.println(CustomerDetailslist);
	    driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.name("fname")).sendKeys(CustomerDetailslist.get(0));
		driver.findElement(By.name("lname")).sendKeys(CustomerDetailslist.get(1));
		driver.findElement(By.id("email")).sendKeys(CustomerDetailslist.get(2));
		driver.findElement(By.name("addr")).sendKeys(CustomerDetailslist.get(3));
		driver.findElement(By.name("telephoneno")).sendKeys(CustomerDetailslist.get(4));

	 
	}

	@When("the user click on Submit button")
	public void the_user_click_on_Submit_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Then("the user should be displayed ID")
	public void the_user_should_be_displayed_ID() {
		   Assert.assertTrue(driver.findElement(By.xpath("//td[@align='center'][2]")).isDisplayed()); 

	}



}
