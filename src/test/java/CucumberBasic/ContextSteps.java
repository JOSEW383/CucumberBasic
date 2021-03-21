package CucumberBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;

public class ContextSteps {

    private static boolean initialized = false;
 
    private WebDriver driver;
 
    @Before
    public void setUp() throws Exception {
       if (!initialized) {
          // initialize the driver
          System.setProperty("webdriver.chrome.driver", "src/test/resources/webDriver/chromedriver.exe");
          driver = new ChromeDriver();
 
          initialized = true;
       }
    }
 
    public WebDriver getDriver() {
       return driver;
    }
 }