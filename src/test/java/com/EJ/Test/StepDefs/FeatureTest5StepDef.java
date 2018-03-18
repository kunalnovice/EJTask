package com.EJ.Test.StepDefs;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FeatureTest5StepDef extends BaseDefs {

    public FeatureTest5StepDef()  {
        super();
    }
    @Before
    public void setData(Scenario scenario) {
        System.out.println("I am in before of FirstStepDefs start");
        super.before(scenario);
        System.out.println("I am in before of FirstStepDefs end");
    }

    @Given("^I invoke calling code API for calling code (\\d+)$")
    public void iInvokeCallingCodeAPIForCallingCode(int arg0) throws Throwable {
        callingCodeAPI.executeCallingCodeGET(arg0);
    }

    @Then("^Response should contain name as \"([^\"]*)\"$")
    public void responseShouldContainNameAsEstonia(String arg0) throws Throwable {
        callingCodeAPI.checkCountryExist(arg0);
    }


    @Then("^Response should not contain name as \"([^\"]*)\"$")
    public void responseShouldNotContainNameAs(String arg0) throws Throwable {
        callingCodeAPI.checkCountrydoesNotExist(arg0);
    }

    @Given("^I invoke calling code API for capital city \"([^\"]*)\"$")
    public void iInvokeCallingCodeAPIForCapitalCity(String arg0) throws Throwable {
        capitalCityAPI.executeCapitalCityGET(arg0);
    }

    @Given("^I invoke calling code API for Region \"([^\"]*)\"$")
    public void iInvokeCallingCodeAPIForRegion(String arg0) throws Throwable {
        regionAPI.executeRegionGET(arg0);
    }

    @Then("^bordering countries matrix is calculated$")
    public void borderingCountriesMatrixIsCalculated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        regionAPI.calcuateBorderingCountryMatrix();
    }

    @Then("^Get me bordering country for the Country \"([^\"]*)\"$")
    public void getMeBorderingCountryForTheCountry(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        regionAPI.printBorderingCountryCountForGivenCountry(arg0);

    }
}
