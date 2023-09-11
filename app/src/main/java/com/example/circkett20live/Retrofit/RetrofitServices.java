package com.example.circkett20live.Retrofit;

import com.example.circkett20live.Playerdetils.MainResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitServices {

    // Specify the API endpoint URL as the parameter for @GET
    @GET("v1/currentMatches") // The base URL is already set elsewhere, so you only need to specify the relative path here
    Call<MainResponse> getLiveScore(@Query("apikey") String appKey, @Query("offset") String offset);
}
