package com.EJ.Test.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryName {

    @SerializedName("name")
    @Expose
    private String name = null;

    public String getNames() {
        return name;
    }

    public void setNames(String name) {
        this.name = name;
    }

}
