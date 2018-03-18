package com.EJ.Test.Test4.Refactored;

public class SenderNew implements Consumer {
    private InterfaceWriter interfaceWriter;

    public SenderNew(InterfaceWriter interfaceWriter) {
        this.interfaceWriter= interfaceWriter;
    }
    @Override
    public void send(String strMessage) {
        this.interfaceWriter.write(strMessage);
    }
    public static void main( String args[]) {
        String msg ="Dependency Injection implemented";
        InjectorImpl injectorimpl = null;
        Consumer app= null;
        injectorimpl = new InjectorImpl();
        app=injectorimpl.getConsumer();
        app.send(msg);
    }
}
