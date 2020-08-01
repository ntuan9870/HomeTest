package com.example.hometesttiki.Retrofit;

import com.example.hometesttiki.Model.DataBanner;
import com.example.hometesttiki.Model.DataQuickLink;
import com.example.hometesttiki.Model.QuickLink;
import com.example.hometesttiki.Model.Sale;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ITikiAPI {
    @GET("v2/home/banners/v2")
    Observable<DataBanner> getDataBanner();
    @GET("shopping/v2/widgets/quick_link")
    Observable<DataQuickLink> getDataQuickLink();
    @GET("v2/widget/deals/hot")
    Observable<Sale> getSale();
}
