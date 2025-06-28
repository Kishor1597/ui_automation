package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class WaitHelper {
    private WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementVisible(By locator, int timeoutSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator, int timeoutSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForUrlToContain(String partialUrl, int timeoutSec) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSec))
                .until(ExpectedConditions.urlContains(partialUrl));
    }

    public void waitForPageLoadComplete(int timeoutSec) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSec)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    public WebElement retryFindElement(By locator, int maxRetries, int waitBetweenSec) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                return driver.findElement(locator);
            } catch (NoSuchElementException e) {
                try {
                    Thread.sleep(waitBetweenSec * 1000L);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                attempts++;
            }
        }
        throw new NoSuchElementException("Element not found after retries: " + locator);
    }
}
