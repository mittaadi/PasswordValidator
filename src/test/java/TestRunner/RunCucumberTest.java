package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:Features"},
        glue = {"Stepdefs"},
//        tags = {},
        plugin = {"pretty"})

public class RunCucumberTest {

}
