package org.java.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/Test1_get_objects.feature"}, glue = {"org.java.stepfiles"},
        plugin = {})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}