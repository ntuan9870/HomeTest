package com.example.hometesttiki.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Banner {

    public int id;
    public String title;
    public String content;
    public String url;
    public String image_url;
    public String thumbnail_url;
    public String mobile_url;
    public double ratio;

    public Banner() {
    }

    public Banner(int id, String title, String content, String url, String image_url, String thumbnail_url, String mobile_url, double ratio) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.url = url;
        this.image_url = image_url;
        this.thumbnail_url = thumbnail_url;
        this.mobile_url = mobile_url;
        this.ratio = ratio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}