package ExternalDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CucumberBasic.ContextSteps;
import io.cucumber.java.en.And;

public class StepDefinitions {
    private ContextSteps contextSteps;
    WebDriver driver = null;

    // PicoContainer injects class ContextSteps
    public StepDefinitions(ContextSteps contextSteps) {
        this.contextSteps = contextSteps;
        driver = this.contextSteps.getDriver();
    }

    // -------------StepDefinitions-------------//

    @And("I write {string}")
    public void i_write(String keysToSend) {
        driver.findElement(By.name("q")).sendKeys(keysToSend);
        driver.findElement(By.name("btnK")).click();
    }
}
