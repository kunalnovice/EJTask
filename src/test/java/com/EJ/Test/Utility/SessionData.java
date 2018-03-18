package com.EJ.Test.Utility;

import com.jayway.restassured.response.Response;

public class SessionData {
    public static Response response;


    public static Response getResponse() {
        return response;
    }

    public static void setResponse (Response response) {
        SessionData.response= response;
    }
}