package com.EJ.Test.Utility;

import com.google.gson.stream.JsonReader;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.LogConfig;
import com.jayway.restassured.config.RestAssuredConfig;

import java.io.*;

public class FileOperations extends Common{

    private static String payLoadDir = JSON_dir+"/samplePayLoad/";
    public static JsonReader myReader;
    public static JsonReader ReadFromFile(String fileName) throws UnsupportedEncodingException,FileNotFoundException {
        String location = payLoadDir+fileName;
        File crunchifyFile = new File(location);

        InputStreamReader isReader;

        try {
            isReader = new InputStreamReader(new FileInputStream(crunchifyFile),"UTF-8");
            myReader = new JsonReader(isReader);

        } catch ( Exception e) {
            System.out.println(fileName+"file doesn't exist");
            throw e;

        }
        System.out.println("File exist and file "+ fileName + "read successfully");
        return myReader;

    }

    public static void moveJSONToPositiveArchive() {
        if(isPositiveJSONArchiveEnabled()) {
            appendFiles(archivePositive,source);
        }
    }

    public static void moveJSONToNegativeArchive() {
        if(isNegativeJSONArchiveEnabled()) {
            appendFiles(archiveNegative,source);
        }
    }
    public static void moveJSONToFailureArchive() {
        if(isFailureJSONArchiveEnabled()) {
            appendFiles(archiveFailure,source);
        }
    }

    public static void appendFiles(String permFile, String tmpFile) {
        try {
            //create a writer for PerFile
            BufferedWriter out = new BufferedWriter(new FileWriter(permFile, true));
            //create a reader for tmpFile
            BufferedReader in = new BufferedReader(new FileReader(tmpFile));
            String str;
            while((str = in.readLine())!= null) {
                out.write("\n"+str);
            }
            in.close();
            out.close();
        } catch (IOException e) {

        }
    }

    public static void addStringToTextFile(String filePath, String toAdd) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(toAdd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cleanCOntentFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        PrintWriter writer = new PrintWriter(file);
        writer.flush();
        writer.close();
    }

    public static void resetRESTAssuredConfiguration(String filePath) throws FileNotFoundException {
        PrintStream fileOutPutStream = new PrintStream(new File(filePath));
        RestAssured.config= RestAssuredConfig.newConfig().logConfig(new LogConfig(fileOutPutStream, true));
    }

    public static void preArchiveSteps() throws FileNotFoundException {
        resetRESTAssuredConfiguration(interim);
        FileOperations.addStringToTextFile(source,"\n\n-----------Time of Request\\Response "+function.getCurrentDate()+"--------------\n");
    }
}
