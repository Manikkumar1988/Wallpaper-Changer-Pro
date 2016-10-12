package com.mani.kumar.wallpaperchangerpro.network;

import com.mani.kumar.wallpaperchangerpro.util.AppContstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UnSplashRetrofit {
    public UnSplashService getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UnSplashService service = retrofit.create(UnSplashService.class);
        return service;
    }
}
