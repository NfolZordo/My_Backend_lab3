package com.example.lab_3_round_3;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {

    @GET("/greeting")
    public Call<ArrayList<Subject>> getPostWithID();

}
