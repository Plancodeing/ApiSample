package com.example.apisample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    static Retrofit getClient() {


        retrofit = new Retrofit.Builder()
                .baseUrl("https://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())

                .build();



        return retrofit;
    }
}
