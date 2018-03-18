package com.EJ.Test.Test1;

import com.EJ.Test.POJO.Example;
import com.EJ.Test.POJO.Test5POJO;
import com.google.gson.Gson;
import com.EJ.Test.Utility.FileOperations;

public class DeSerializationTest {
    public static void main(String args[]) {
        Test5POJO  test5POJOobj;
        try {
            test5POJOobj=getJavaObject();
            System.out.println(test5POJOobj);
            String test5JSON =new Gson().toJson(test5POJOobj);
            System.out.println("JSON string converted from Java Object looks like "+test5JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static Test5POJO getJavaObject() throws Exception {
        Test5POJO test5POJOobject = new Test5POJO();
        //Example[] exObj ;
        test5POJOobject = new Gson().fromJson(FileOperations.ReadFromFile("test1JSON.txt"),Test5POJO.class);

        return  test5POJOobject;

    }
}
