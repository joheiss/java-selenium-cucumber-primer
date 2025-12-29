package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Timestamp;

import static com.jovisco.factories.DriverFactory.cleanupDriver;
import static com.jovisco.factories.DriverFactory.getDriver;

public class Hooks {

    @Before(order = 0)
    public void setup() {
        getDriver();
    }
    @AfterStep
    public void captureScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            var timestamp = Long.toString(new Timestamp(System.currentTimeMillis()).getTime());
            var screenshot = (( TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Step Screenshot - " + timestamp);
        }
    }
    @After(order = 0)
    public void tearDown() {
        cleanupDriver();
    }
}
