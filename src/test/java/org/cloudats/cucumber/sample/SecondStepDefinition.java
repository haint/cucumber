/**
 *
 */
package org.cloudats.cucumber.sample;

import org.cloudats.cucumber.WebDriverProvider;
import org.openqa.selenium.By;
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
public class SecondStepDefinition {
  
  @Inject
  private WebDriverProvider wpProvider;

  @Given("^I am on the Vnexpress search page$")
  public void visitVnExpress() {
    wpProvider.provide().get("http://vnexpress.net/");
  }
  
  @When("^I click first menu item$")
  public void click() {
    wpProvider.provide().findElement(By.xpath("//*[@id='menu_web']/li[2]/a")).click();
  }
  
  @Then("^the page title should index of \"(.*)\"$")
  public void checkIndexOfTitle(String title) throws InterruptedException {
    Thread.sleep(3000);
    Assert.assertTrue(wpProvider.provide().getTitle().indexOf(title) != -1);
  }
  
  @After
  public void tearDown() {
    wpProvider.provide().close();
  }
  
} 
