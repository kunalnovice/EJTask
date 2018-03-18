package com.EJ.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",tags ={"@working"},format={"html:target/cucumber-report","json:target/cucumber.json"})
public class RunnerTest {

}
