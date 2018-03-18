package com.EJ.Test.Test3;

import java.util.Random;

public class EnumTitle {
    public enum Title {Mr, Mrs, Sir, Miss, Madam, Master}
    public static Title getRandomTitle() {
        return Title.values()[new Random().nextInt(Title.values().length)];
    }
}
