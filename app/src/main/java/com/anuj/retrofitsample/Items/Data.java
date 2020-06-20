package com.anuj.retrofitsample.Items;

import com.google.gson.annotations.SerializedName;

public class Data {
    String Name;
    String Desc;
    int count;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Data(String name, String desc, int count) {
        Name = name;
        Desc = desc;
        this.count = count;
    }
}
