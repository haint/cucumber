/**
 *
 */
package org.cloudats.cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author <a href="mailto:haithanh0809@gmail.com">Nguyen Thanh Hai</a>
 * Sep 26, 2016
 */
public class SimpleStepDefinition {
  
  private WebDriver driver;
  
  @Before
  public void init() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @Given("^I am on the Google search page$")
  public void visitGoogle() {
    driver.get("https://www.google.com");
  }
  
  @When("^I search for \"(.*)\"$")
  public void searchFor(String query) {
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys(query);
    element.submit();
  }

  @Then("^the page title should start with \"(.*)\"$")
  public void checkTitle(String output) throws InterruptedException {
//    new WebDriverWait(driver, 10 * 1000).until(new ExpectedCondition<Boolean>() {
//
//      @Override
//      public Boolean apply(WebDriver d) {
//        return d.getTitle().toLowerCase().startsWith("cheese");
//      }
//      
//    });
    Thread.sleep(3000);
    System.out.println(output);
    System.out.println(driver.getTitle());
    Assert.assertTrue(driver.getTitle().startsWith(output));
    driver.close();
  }
  
  @After
  public void tearDown() {
    driver.quit();
  }
  
} 
