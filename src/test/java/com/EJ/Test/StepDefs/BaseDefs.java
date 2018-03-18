package com.EJ.Test.StepDefs;

import com.EJ.Test.APICollection.CallingCodeAPI;
import com.EJ.Test.APICollection.CapitalCityAPI;
import com.EJ.Test.APICollection.RegionAPI;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.LogConfig;
import com.jayway.restassured.config.RestAssuredConfig;
import cucumber.api.Scenario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class BaseDefs {


    public CallingCodeAPI callingCodeAPI = new CallingCodeAPI();
    public CapitalCityAPI capitalCityAPI = new CapitalCityAPI();
    public RegionAPI regionAPI = new RegionAPI();

    protected Scenario scenario;
    public static final String DIR = System.getProperty("user.dir")+ File.separator+"src/test/resources/config/JSON/interimJSON.txt";

    public void before(Scenario scenario) {
        System.out.println("in basedefs before method start");
        this.scenario = scenario;
        System.out.println("in basedefs before method end");
    }
    public BaseDefs() {
        try {
            System.out.println("in basedefs constructor start");
            setRestAssuredFileLogging();
            System.out.println("in basedefs constructor end");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setRestAssuredFileLogging() throws FileNotFoundException {
        PrintStream fileOutPutStream = new PrintStream(new File(DIR));
        RestAssured.config= RestAssuredConfig.newConfig().logConfig(new LogConfig(fileOutPutStream,true));
    }
}
