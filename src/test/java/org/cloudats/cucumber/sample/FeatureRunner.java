package org.cloudats.cucumber.sample;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"})
public class FeatureRunner extends AbstractTestNGCucumberTests {

}
