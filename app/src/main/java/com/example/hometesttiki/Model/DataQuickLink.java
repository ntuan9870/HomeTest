package com.example.hometesttiki.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataQuickLink {

    @SerializedName("data")
    @Expose
    private List<List<QuickLink>> data = null;

    public List<List<QuickLink>> getData() {
        return data;
    }

    public void setData(List<List<QuickLink>> data) {
        this.data = data;
    }

}