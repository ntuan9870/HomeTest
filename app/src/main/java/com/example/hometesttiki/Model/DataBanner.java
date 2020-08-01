package com.example.hometesttiki.Model;

import java.util.ArrayList;
import java.util.List;

public class DataBanner {
    public List<Banner> data = new ArrayList<>();

    public DataBanner(List<Banner> data) {
        this.data = data;
    }

    public DataBanner() {
    }

    public List<Banner> getData() {
        return data;
    }

    public void setData(List<Banner> data) {
        this.data = data;
    }
}
