package CucumberBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;;

public class StepDefinitions {
    int TIME_WAIT = 5;
    WebDriver driver = null;
    WebDriverWait wait = null;

    // -------------Setup&Terminate-------------//

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webDriver/chromedriver.exe");
    }

    @After
    public void terminate() {
        if (driver != null) {
            driver.close();
        }
    }

    // -------------StepDefinitions-------------//

    @Given("browser {string}")
    public void i_open_browser_as(String browser) {
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }else{
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(TIME_WAIT, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, TIME_WAIT);
    }

    @When("I enter url as {string}")
    public void i_enter_uPPrl_as(String url) {
        driver.get(url);

        // Accept cookies
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0)); // the first frame available is 0 (if there is any)
        driver.findElement(By.xpath("//*[@id='introAgreeButton']/span/span")).click();
    }

    @And("I write {string}")
    public void i_write(String keysToSend) {
        driver.findElement(By.name("q")).sendKeys(keysToSend);
        driver.findElement(By.name("btnK")).click();
    }

    @And("I select {string}")
    public void i_select(String button) {
        driver.findElement(By.partialLinkText(button)).click();
    }

    @Then("I see {string} web")
    public void i_see(String string) {
        String url = driver.getCurrentUrl();
        assertTrue("Url wrong: " + url, url.contains(string));
    }
}
