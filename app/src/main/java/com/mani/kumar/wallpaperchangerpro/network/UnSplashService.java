package com.mani.kumar.wallpaperchangerpro.network;

import com.mani.kumar.wallpaperchangerpro.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UnSplashService {
        @GET("photos")
        Call<List<Photo>> listRepos(@Query("page") String page, @Query("client_id")String clientId);
}
