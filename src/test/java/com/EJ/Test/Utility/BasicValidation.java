package com.EJ.Test.Utility;

import com.jayway.restassured.response.Response;
import org.junit.Assert;

public class BasicValidation {
    public static void isResponse200(Response resp) {
        if(resp.getStatusCode()==200) {
            FileOperations.moveJSONToPositiveArchive();
        } else {
            FileOperations.moveJSONToFailureArchive();
        }
        SessionData.response=resp;
        Assert.assertEquals(200,resp.getStatusCode());
    }
    public static void isResponse400(Response resp) {
        if(resp.getStatusCode()==400) {
            FileOperations.moveJSONToNegativeArchive();
        } else {
            FileOperations.moveJSONToFailureArchive();
        }
    }
    public static void isStringEqualAtPath(Response resp, String strPath, String expectedString) {
        Assert.assertTrue(expectedString,resp.path(strPath));
    }
    public static void isStringNotNullAtPath(Response resp, String strPath) {
        Assert.assertNotNull(resp.path(strPath));
    }
    public static void areStringEqual(String str1,String str2) {
        Assert.assertEquals(str1,str2);
    }
    public static void areStringNotEqual(String str1,String str2) {
        Assert.assertNotEquals(str1,str2);
    }

}
