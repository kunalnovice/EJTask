package com.EJ.Test.APICollection;

import com.EJ.Test.POJO.Example;
import com.EJ.Test.Utility.BasicValidation;
import com.EJ.Test.Utility.Common;
import com.EJ.Test.Utility.SessionData;
import com.google.gson.Gson;
import com.jayway.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RegionAPI extends Common {

    HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();
    HashMap<String, List<String>> hmapMorethan3BorderingCOuntry = new HashMap<String, List<String>>();
    HashMap<String, List<String>> hmapMorethan4BorderingCOuntry = new HashMap<String, List<String>>();
    HashMap<String, List<String>> hmapMorethan5BorderingCOuntry = new HashMap<String, List<String>>();
    HashMap<String, List<String>> hmapIndividualCountryDetail = new HashMap<String, List<String>>();

    public void executeRegionGET(String arg0) throws Exception {
        RequestSpecification reqSpec = reqHelper.getRequestSpec();
        String callingCodeAPI= testEnvironmentObject.getPropertyValue("region")+arg0;
        reqHelper.assertGETReponse200(reqSpec,callingCodeAPI);
    }




    public void calcuateBorderingCountryMatrix() {
        arrayExampleObj = new Gson().fromJson(SessionData.getResponse().asString(),Example[].class);
        System.out.println(arrayExampleObj.length);
        updateBorderMatrix();
        printBorderMatrix();
        createBorderingCountryMatrix();
        printBorderingCountryMatrix();
        //BasicValidation.areStringNotEqual(arg0,exampleObj.getName());

    }

    private void printBorderingCountryMatrix() {
        System.out.println("countries more than 3 Bordering Countries are");
        printBorderingCountryMatrix(hmapMorethan3BorderingCOuntry);
        System.out.println("countries more than 4 Bordering Countries are");
        printBorderingCountryMatrix(hmapMorethan4BorderingCOuntry);
        System.out.println("countries more than 5 Bordering Countries are");
        printBorderingCountryMatrix(hmapMorethan5BorderingCOuntry);
    }

    private void createBorderingCountryMatrix() {
        for(int i=0;i<arrayExampleObj.length;i++) {
            exampleObj=arrayExampleObj[i];
            if(exampleObj.getBorders().size()>3) {
                hmapMorethan3BorderingCOuntry.put(exampleObj.getName(),exampleObj.getBorders());
                //hmapMorethan4BorderingCOuntry.put(exampleObj.getName(),exampleObj.getBorders());
                //hmapMorethan5BorderingCOuntry.put(exampleObj.getName(),exampleObj.getBorders());
            }
            if(exampleObj.getBorders().size()>4) {
                hmapMorethan4BorderingCOuntry.put(exampleObj.getName(),exampleObj.getBorders());
                //hmapMorethan5BorderingCOuntry.put(exampleObj.getName(),exampleObj.getBorders());
            }
            if(exampleObj.getBorders().size()>5) {
                hmapMorethan5BorderingCOuntry.put(exampleObj.getName(),exampleObj.getBorders());
            }
        }
    }

    private void printBorderMatrix() {
        Iterator it = hmap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey()+"-----"+pair.getValue());
            it.remove();
        }
    }


    private void printBorderingCountryMatrix(HashMap<String, List<String>> hmap) {
        Iterator it = hmap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey()+"-----"+pair.getValue());
            
        }
    }

    private void updateBorderMatrix() {
        for(int i=0;i<arrayExampleObj.length;i++) {
            exampleObj=arrayExampleObj[i];
            hmap.put(exampleObj.getName(),exampleObj.getBorders());
        }
    }

   

    public void printBorderingCountryCountForGivenCountry(String countryName) {
        arrayExampleObj = new Gson().fromJson(SessionData.getResponse().asString(),Example[].class);
        System.out.println(arrayExampleObj.length);
        updateBorderMatrix();
        identifyCountry(countryName);
    }

    private void identifyCountry(String countryName) {
        int individualBorderingCountryCount = 0;
    
        for(int i=0;i<arrayExampleObj.length;i++) {
            exampleObj = arrayExampleObj[i];
            if (exampleObj.getName().equals(countryName)) {
                hmapIndividualCountryDetail.put(exampleObj.getName(), exampleObj.getBorders());
                individualBorderingCountryCount = exampleObj.getBorders().size();
                printBorderingCountryMatrix(hmapIndividualCountryDetail);
                System.out.println("Total Number of countries are " + individualBorderingCountryCount);
                break;

            }

        }
    }
}
