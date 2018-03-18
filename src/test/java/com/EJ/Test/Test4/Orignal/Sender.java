package com.EJ.Test.Test4.Orignal;

public class Sender {
    private Writer writer;
    public Writer getWriter() {
        return writer;
    }
    public void Send(String strMessage) {
        writer = new Writer();
        writer.write(strMessage);
    }
    public static void main(String args[]) {
        Sender sender = new Sender();
        sender.Send("some message");
    }
}
