package com.EJ.Test.Utility;


import com.EJ.Test.POJO.Example;
import com.google.gson.Gson;

import java.io.File;

public class Common {
    public static PropertyFile testEnvironmentObject =PropertyFile.getTestEnvironmentObject();
    public static PropertyFile respLocatorObjet = PropertyFile.getRespoLocatorObject();
    public static PropertyFile testDataObject = PropertyFile.getTestDataObject();

    //public static final Logging log = Logging.getLogger();
    public static Functions function = new Functions();
    public static RequestHelper reqHelper = new RequestHelper();

    public static String positiveJSONArchive = testEnvironmentObject.getPropertyValue("Positive.JSON.Archive");
    public static String negativeJSONArchive = testEnvironmentObject.getPropertyValue("Negative.JSON.Archive");
    public static String failureJSONArchive = testEnvironmentObject.getPropertyValue("Failure.JSON.Archive");

    public static String JSON_dir = System.getProperty("user.dir")+ File.separator+"src/test/resources/config/JSON/";
    public static String source = JSON_dir+"SourceJSON.txt";
    public static String interim = JSON_dir+"interimJSON.txt";
    public static String archivePositive = JSON_dir+"ArchivedPositiveJSON.txt";
    public static String archiveNegative = JSON_dir+"ArchivedNegativeJSON.txt";
    public static String archiveFailure = JSON_dir+"ArchivedFailureJSON.txt";

    public static Gson gson = new Gson();
    public Example[] arrayExampleObj ;

    public Example exampleObj ;

    public static boolean isPositiveJSONArchiveEnabled() {
        if(positiveJSONArchive.equals("YES")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isNegativeJSONArchiveEnabled() {
        if(negativeJSONArchive.equals("YES")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isFailureJSONArchiveEnabled() {
        if(failureJSONArchive.equals("YES")) {
            return true;
        } else {
            return false;
        }
    }
}
