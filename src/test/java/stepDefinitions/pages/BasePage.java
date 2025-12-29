package stepDefinitions.pages;

import com.jovisco.factories.DriverFactory;
import com.jovisco.utils.GlobalVars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }
    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
    public void navigateToUrl(String url) {
        getDriver().get(url);
    }
    public void enterValue(By by, String value) {
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(by))).sendKeys(value);
    }
    public void enterValue(WebElement element, String value) {
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(element))).sendKeys(value);
    }
    public void clickButton(By by) {
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(by))).click();
    }
    public void clickButton(WebElement element) {
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(element))).click();
    }
    public void verifyAlertMessage(String message) {
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        var alert = getDriver().switchTo().alert();
        var found = alert.getText().contains(message);
        Assert.assertTrue(found);
        alert.accept();
    }
    public void waitForElement(By by) {
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForElement(WebElement element) {
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
