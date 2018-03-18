package com.EJ.Test.APICollection;

import com.EJ.Test.POJO.Example;
import com.EJ.Test.Utility.BasicValidation;
import com.EJ.Test.Utility.Common;
import com.EJ.Test.Utility.SessionData;
import com.google.gson.Gson;
import com.jayway.restassured.specification.RequestSpecification;

public class CapitalCityAPI extends Common {



    public void executeCapitalCityGET(String arg0) throws Exception {
        RequestSpecification reqSpec = reqHelper.getRequestSpec();
        String callingCodeAPI= testEnvironmentObject.getPropertyValue("capitalCity")+arg0;
        reqHelper.assertGETReponse200(reqSpec,callingCodeAPI);
    }

    public void checkCountryExist(String arg0) {




        SessionData.getResponse().asString().contains(arg0);

        arrayExampleObj = new Gson().fromJson(SessionData.getResponse().asString(),Example[].class);

        System.out.println(new Gson().toJson(arrayExampleObj));

        System.out.println(arrayExampleObj.length);
        exampleObj=arrayExampleObj[0];
        exampleObj.getName();

        BasicValidation.areStringEqual(arg0,exampleObj.getName());
    }

    public void checkCountrydoesNotExist(String arg0) {
        SessionData.getResponse().asString().contains(arg0);

        arrayExampleObj = new Gson().fromJson(SessionData.getResponse().asString(),Example[].class);

        System.out.println(new Gson().toJson(arrayExampleObj));

        System.out.println(arrayExampleObj.length);
        exampleObj=arrayExampleObj[0];
        exampleObj.getName();

        BasicValidation.areStringNotEqual(arg0,exampleObj.getName());
    }
}
