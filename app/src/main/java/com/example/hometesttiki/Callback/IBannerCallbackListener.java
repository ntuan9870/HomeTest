package com.example.hometesttiki.Callback;

import com.example.hometesttiki.Model.Banner;

import java.util.List;

public interface IBannerCallbackListener {
    void onBannerLoadSuccess(List<Banner> banners);
    void onBannerLoadFailed(String message);
}
