package com.EJ.Test.StepDefs;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FirstStepDefs extends BaseDefs {

    public FirstStepDefs() {
        super();

        System.out.println("I am in cons of FirstStepDefs");

    }

    @Before
    public void setData(Scenario scenario) {
        System.out.println("I am in before of FirstStepDefs start");
        super.before(scenario);
        System.out.println("I am in before of FirstStepDefs end");
    }

    @Given("^I am in Given$")
    public void i_am_in_Given() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("in given");
    }

    @When("^I am in When$")
    public void i_am_in_When() throws Throwable {
        System.out.println("in when");
    }

    @Then("^I am in Then$")
    public void i_am_in_Then() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("in Then");
    }

}
