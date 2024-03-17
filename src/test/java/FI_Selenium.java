import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FI_Selenium {

    // Generic function to find element with wait
    private static WebElement findElementWithWait(WebDriver driver, By locator,
                                                  Function<By, ExpectedCondition<WebElement>> condition) {
        // Set up FluentWait
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Wait for the element to meet the condition
        return wait.until(condition.apply(locator));
    }

    @Test
    public void testSeleniumFI() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        By locatorButton = By.id("populate-text");
        By locatorText = By.xpath("//h2[text()='Selenium Webdriver']");

        // Example usage: Find elements with wait
        WebElement changeTextButton = findElementWithWait(driver, locatorButton, ExpectedConditions::elementToBeClickable);
        changeTextButton.click();
        WebElement actualText = findElementWithWait(driver, locatorText, ExpectedConditions::visibilityOfElementLocated);
        System.out.println(actualText.getText());

        driver.quit();
    }
}
