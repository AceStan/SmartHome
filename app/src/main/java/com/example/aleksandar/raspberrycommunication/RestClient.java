package com.example.aleksandar.raspberrycommunication;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Aleksandar on 13.03.2016.
 */
public class RestClient {
    static String baseUrl = "http://192.168.0.109";

    public static UrlService getUrlService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UrlService.class);
    }
}
