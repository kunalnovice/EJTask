package com.EJ.Test.Test3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreatorTestA {

    public static Scanner scan;
    public static int no_of_records;
    public static void main(String args[]) {
         scan = new Scanner(System.in);
        int no_of_records;
        System.out.println("Enter how many Customer");

        try{
            no_of_records =inputNoOfCustomer();
            createCustomer();
        } catch (Exception e) {
            System.out.println("Please enter number only");
        }


    }

    private static void createCustomer() {
        if(no_of_records>=0) {
            Builder builder = new Builder(no_of_records);
            builder.build();
        } else {
            System.out.println("Please enter valid number >= 0");
        }
    }

    private static int inputNoOfCustomer() {
        no_of_records = scan.nextInt();
        System.out.println("value entered is "+no_of_records);
        return no_of_records;
    }
}
