/**
 *
 */
package org.cloudats.cucumber.sample;

import org.cloudats.cucumber.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.google.inject.Inject;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * @author <a href="mailto:haithanh0809@gmail.com">Nguyen Thanh Hai</a>
 * Sep 26, 2016
 */
@ScenarioScoped
public class FirstStepDefinition {
  
  @Inject
  private WebDriverProvider wpProvider;
  
  @Given("^I am on the Google search page$")
  public void visitGoogle() {
    wpProvider.provide().get("https://www.google.com");
  }
  
  @When("^I search for \"(.*)\"$")
  public void searchFor(String query) {
    WebElement element = wpProvider.provide().findElement(By.name("q"));
    element.sendKeys(query);
    element.submit();
  }

  @Then("^the page title should start with \"(.*)\"$")
  public void checkTitle(String output) throws InterruptedException {
    Thread.sleep(3000);
    Assert.assertTrue(wpProvider.provide().getTitle().startsWith(output));
  }
  
  
  @After
  public void tearDown() {
    wpProvider.provide().close();
  }
  
} 
