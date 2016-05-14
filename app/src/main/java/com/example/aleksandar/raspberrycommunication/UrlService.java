package com.example.aleksandar.raspberrycommunication;


import retrofit.Call;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Aleksandar on 13.03.2016.
 */
public interface UrlService {
    @FormUrlEncoded
    @POST("/update.php")
    Call<MyResponse> updateStatus(@Field("Name") String name);
}
