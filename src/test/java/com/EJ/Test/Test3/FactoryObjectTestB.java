package com.EJ.Test.Test3;

public class FactoryObjectTestB {
    //singleton factory Object Pattern
    public static void main(String[] args) {
        FactoryObject factoryObject = FactoryObject.getFactoryObject();
        factoryObject.demoMethod();
    }
}
