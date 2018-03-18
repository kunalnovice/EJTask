package com.EJ.Test.Test3;
import org.apache.commons.lang.RandomStringUtils;
public class CommonFunction {
    public String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length).toUpperCase();
    }
}
