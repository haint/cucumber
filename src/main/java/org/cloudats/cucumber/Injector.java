/**
 *
 */
package org.cloudats.cucumber;

import com.google.inject.Guice;
import com.google.inject.Stage;

import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;

/**
 * @author <a href="mailto:haithanh0809@gmail.com">Nguyen Thanh Hai</a>
 * Sep 30, 2016
 */
public class Injector implements InjectorSource {

  @Override
  public com.google.inject.Injector getInjector() {
    return Guice.createInjector(Stage.PRODUCTION, CucumberModules.SCENARIO, new SeleniumModule());
  }
  
}
