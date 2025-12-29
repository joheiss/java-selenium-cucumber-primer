package com.jovisco.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = { "classpath:features" },
        glue = { "stepDefinitions" },
        plugin = { "pretty", "html:target/cucumber-report.html", "json:target/cucumber-report.json" },
        tags = "@regression",
        monochrome = true,
        dryRun = false
)
public class TestSuiteRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
