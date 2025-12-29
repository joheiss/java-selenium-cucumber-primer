package com.jovisco.factories;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }
    public static void cleanupDriver() {
        driver.get().quit();
        driver.remove();
    }
    private static WebDriver createDriver() {
        var browserType = getBrowserType();
        var driver = switch (browserType) {
            case "chrome" -> createChromeDriver();
            case "firefox" -> createFirefoxDriver();
            default -> createChromeDriver();
        };
        driver.manage().window().maximize();
        return driver;
    }
    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", getDriverPath() + "chromedriver");
        var chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--remote-allow-origins=*");
        // chromeOptions.addArguments("--headless");
        var driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", getDriverPath() + "geckodriver");
        var geckoOptions = new FirefoxOptions();
        geckoOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        // geckoOptions.addArguments("--remote-allow-origins=*");
        var driver = new FirefoxDriver(geckoOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return driver;
    }

    private static String getBrowserType() {
        String browserType = null;
        try {
            Properties props = new Properties();
            var file = new FileInputStream("src/test/java/com/jovisco/properties/config.properties");
            props.load(file);
            return props.getProperty("browser").toLowerCase().trim();
        } catch (FileNotFoundException e) {
            System.out.println("config.properties file not found");
            browserType = "chrome";
        } catch (IOException e) {
            System.out.println("Error reading config.properties file");
            browserType = "chrome";
        }
        return browserType;
    }

    private static String getDriverPath() {
        String os = SystemUtils.OS_NAME;
        String suffix = "linux";
        if (os.toLowerCase().contains("mac")) {
            suffix = "mac";
        } else if (os.toLowerCase().contains("win")) {
            suffix = "win";
        }
        return "src/test/resources/drivers/" + suffix + "/";
    }
}
