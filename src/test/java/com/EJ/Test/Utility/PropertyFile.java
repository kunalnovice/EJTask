package com.EJ.Test.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFile {
    public static Properties prop = new Properties();
    private static String User_dir = System.getProperty("user.dir")+ File.separator;
    private static String testEnvironmentPath = User_dir + "src/test/resources/config/TestEnvironment.properties";
    private static String JSONLocPath = User_dir +"src/test/resources/config/JSONLocator.properties";
    private static String testDataPath = User_dir +"src/test/resources/config/TestData.properties";
    InputStream inputStream;



    private PropertyFile(String path) {loadProperties(path);}

    static PropertyFile testEnvironmentObject = new PropertyFile(testEnvironmentPath);
    static PropertyFile respoLocatorObject = new PropertyFile(JSONLocPath);
    static PropertyFile testDataObject = new PropertyFile(testDataPath);

    public static PropertyFile getTestEnvironmentObject(){
        return testEnvironmentObject;
    }
    public static PropertyFile getRespoLocatorObject(){
        return respoLocatorObject;
    }
    public static PropertyFile getTestDataObject(){
        return testDataObject;
    }
    public void loadProperties(String propFilePath) {
        try {
            if(propFilePath!= null) {
                inputStream = new FileInputStream(propFilePath);
                prop.load(inputStream);
            } else {
                System.out.println(propFilePath + "File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPropertyValue(String key) {
       return prop.getProperty(key);
        }
    }


