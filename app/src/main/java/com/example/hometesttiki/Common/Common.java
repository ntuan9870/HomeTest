package com.example.hometesttiki.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.hometesttiki.Callback.RetrofitClient;
import com.example.hometesttiki.Retrofit.ITikiAPI;

import retrofit2.Retrofit;

public class Common {
    public static ITikiAPI getAPI(){
        return RetrofitClient.getInstance().create(ITikiAPI.class);
    }
    public static boolean isConnectedToInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager!=null){
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
            if(info!=null){
                for(int i = 0; i < info.length; i++){
                    if(info[i].getState()==NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
