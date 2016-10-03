/**
 *
 */
package org.cloudats.cucumber;

import com.google.inject.AbstractModule;

/**
 * @author <a href="mailto:haithanh0809@gmail.com">Nguyen Thanh Hai</a>
 * Sep 30, 2016
 */
public class SeleniumModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(WebDriverProvider.class);
  }

}
