package com.example.hometesttiki.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sale {

    @SerializedName("data")
    @Expose
    private List<DataSale> data = null;
    @SerializedName("tabs")
    @Expose
    private List<Tab> tabs = null;
    @SerializedName("version")
    @Expose
    private String version;

    public List<DataSale> getData() {
        return data;
    }

    public void setData(List<DataSale> data) {
        this.data = data;
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    public void setTabs(List<Tab> tabs) {
        this.tabs = tabs;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
