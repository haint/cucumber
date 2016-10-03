/**
 *
 */
package org.cloudats.cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author <a href="mailto:haithanh0809@gmail.com">Nguyen Thanh Hai</a>
 * Sep 30, 2016
 */
public class WebDriverProvider {

  private WebDriver wd;
  
  protected WebDriverProvider() {
    String browser = System.getProperty("browser", "firefox");
    if ("firefox".equals(browser)) {
      wd = new FirefoxDriver();
    } else if ("chrome".equals(browser)) {
      System.setProperty("webdriver.chrome.driver", "C:/browsersDriver/chromedriver.exe");
      wd = new ChromeDriver();
    } else if ("ie".equals(browser)) {
      System.setProperty("webdriver.ie.driver", "C:/browsersDriver/IEDriverServer.exe");
      wd = new InternetExplorerDriver();
    }
    
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.manage().window().maximize();
  }
  
  public WebDriver provide() {
    return wd;
  }
}
