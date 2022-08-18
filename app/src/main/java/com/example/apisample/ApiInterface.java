package com.example.apisample;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("employees")
    Call<Employee> getEmployees();
}
