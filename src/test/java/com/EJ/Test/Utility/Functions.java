package com.EJ.Test.Utility;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Functions {

    SimpleDateFormat sdf;
    Calendar cal;
    String strDate;

    public String getCurrentDate(String expectedFormat) {
        cal=Calendar.getInstance();
        sdf=new SimpleDateFormat(expectedFormat);//ddMMYYYY_HHmmss
        strDate=sdf.format(cal.getTime());
        System.out.println("current date in string format: "+ strDate);
        return strDate;
    }

    public String getFutureDate(String expectedFormat) {
        cal=Calendar.getInstance();
        sdf=new SimpleDateFormat(expectedFormat);//ddMMYYYY_HHmmss
        strDate=sdf.format(cal.getTime());
        cal.add(Calendar.DATE,1);
        Date futureDate= cal.getTime();
        strDate=sdf.format(futureDate);
        System.out.println("Future date in string format: "+ strDate);
        return strDate;
    }
    public int getCurrentDayPlusOneDay() {
        return toInteger(getFutureDate("dd"));
    }

    public int getCurrentHour() {
        return toInteger(getCurrentDate("HH"));
    }

    public int getCurrentMin() {
        return toInteger(getCurrentDate("dd"));
    }

    public int getCurrentMonthPlusOneDay() {
        return toInteger(getFutureDate("MM"));
    }

    public int getCurrentYearPlusOneDay() {
        return toInteger(getFutureDate("YYYY"));
    }

    public int getTodaysDay() {
        return toInteger(getCurrentDate("dd"));
    }

    public int toInteger(String str) { return Integer.parseInt(str);
    }
    public String toString(Integer intVrbl) { return String.valueOf(intVrbl);
    }

    public String getRandomString() {
        String name = RandomStringUtils.randomAlphabetic(5).toLowerCase();
        return name;
    }
    public String getRandomNumber() {
        String name = RandomStringUtils.randomNumeric(5);
        return name;
    }
    public String getRandomAmount() {
        DecimalFormat amount = new DecimalFormat(("1.00"));
        return String.valueOf(amount.format(Math.random()));
    }
    public String getScenarioNumber(String scenarioName) {
        return(scenarioName.split("-",2)[0]);
    }
    public String getFirstPartOfStringSplitBasedOnPattern(String stringToSplit, String pattern) {
        return(stringToSplit.split(pattern,2)[0]);
    }
    public String getPartOfStringSplitBasedOnPattern(String stringToSplit, String pattern, Integer part) {
        return(stringToSplit.split(pattern,2)[part]);
    }
    public String convertDateFormat(String date, String currentFormat, String requiredFormat) {
        String oldDateString = date;
        String newDateString = "";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(currentFormat);
            Date d = dateFormat.parse(oldDateString);
            dateFormat.applyPattern(requiredFormat);
            newDateString = dateFormat.format(d);
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
        return newDateString;
    }
    public String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String replaceString(String orignalString, String templateStringToReplace, String toBeReplaceWithString) {
        return orignalString.replace(templateStringToReplace, toBeReplaceWithString);
    }
    public String replaceTEMPLATEString(String orignalString, String templateStringToReplace, String toBeReplaceWithString) {
        return orignalString.replace("TEMPLATE", toBeReplaceWithString);
    }

    public String getSubString(String string, int startIndex, int endIndex) {
        return string.substring(startIndex,endIndex);
    }

    public int getRowIndex(ArrayList<Map<String,String>> arrayList, String stringToMatch) {
        int index = 0;
        for(int i=0;i<arrayList.size();i++) {
            if(arrayList.get(i).get("ScenarioNumber").equals(stringToMatch)) {
                index=i;
                break;
            }
        }
        return index;
    }

    public String IdentifyIndexOfGivenValue(String string, int indexToFind) {
       // int index = string.charAt(indexToFind-1);
               return String.valueOf(string.charAt(indexToFind-1));
    }
}
