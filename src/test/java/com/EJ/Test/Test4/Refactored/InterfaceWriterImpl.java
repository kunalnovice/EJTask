package com.EJ.Test.Test4.Refactored;

public class InterfaceWriterImpl implements InterfaceWriter {
    @Override
    public void write(String str) {
        System.out.println("value is" + str.toUpperCase());
    }
}
