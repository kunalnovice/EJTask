package com.EJ.Test.Utility;


import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;

import static com.jayway.restassured.RestAssured.given;

public class RequestHelper extends Common {
    public RequestSpecification getRequestSpec() throws FileNotFoundException {
        FileOperations.preArchiveSteps();
        RequestSpecification reqSpec = given()
                //.cookies(SessionData.getCookies())
                .header("headernname","headerValue");
        return reqSpec;
    }

    public Response assertGETReponse200(RequestSpecification reqSpec, String endPoint) {
        Response resp = reqSpec.when()
                .log().all()
                .get(endPoint)
                .then()
                .log().all()
                .extract().response();
        FileOperations.appendFiles(source,interim);
        BasicValidation.isResponse200(resp);

        return resp;
    }

    public Response assertPOSTReponse200(RequestSpecification reqSpec, String endPoint, String StringJSON) {
        Response resp = reqSpec.body(StringJSON).when()
                .log().all()
                .post(endPoint)
                .then()
                .log().all()
                .extract().response();
        FileOperations.appendFiles(source,interim);
        BasicValidation.isResponse200(resp);

        return resp;
    }

    public Response assertPOSTReponse400(RequestSpecification reqSpec, String endPoint, String StringJSON) {
        Response resp = reqSpec.body(StringJSON).when()
                .log().all()
                .post(endPoint)
                .then()
                .log().all()
                .extract().response();
        FileOperations.appendFiles(source,interim);
        //BasicValidation.isResponse400(resp);

        return resp;
    }
}
