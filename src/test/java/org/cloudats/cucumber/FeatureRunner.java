package org.cloudats.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/org/cloudats/cucumber/Simple.feature"},
//		glue = {"org.cloudats.cucumber"},
		plugin = {"pretty", "json:target/cucumber.json"}
)
public class FeatureRunner extends AbstractTestNGCucumberTests {

}
