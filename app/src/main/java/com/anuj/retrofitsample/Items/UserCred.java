package com.anuj.retrofitsample.Items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserCred {
    @SerializedName("var1")
    @Expose
    private String var1;

    @SerializedName("var2")
    @Expose
    private String var2;


}