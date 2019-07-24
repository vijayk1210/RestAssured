package runner;

import java.io.*;

import cucumber.api.Scenario;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utilities.Generics;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"steps"},plugin = {
        "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true)

public class TestRunner{


    @Before
    public void beforeScenario(Scenario scenario) {
        Reporter.assignAuthor("Vijay Kumar");
    }
    @AfterClass
        public static void writeExtentReport() {
            Reporter.loadXMLConfig(new File(Generics.getReportConfigPath()));
        }
    
    }