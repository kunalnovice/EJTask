package com.EJ.Test.Test3;

public class FactoryObject {
    //one factory Object created for any request
    private static final FactoryObject factoryObject = new FactoryObject();

    //no other class can instantiate constructor of this class
    private FactoryObject(){
    }

    //single static  way of accessing Object
    public static FactoryObject getFactoryObject() { return factoryObject;}

    //Factory Object Demo method to creat Default number of Customer

    protected static void demoMethod() {
        Builder builder = new Builder(10);
        builder.build();
    }

}
