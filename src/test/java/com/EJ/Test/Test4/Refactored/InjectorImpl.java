package com.EJ.Test.Test4.Refactored;

public class InjectorImpl implements Injector {

    @Override
    public Consumer getConsumer() {
        return new SenderNew(new InterfaceWriterImpl());
    }
}
