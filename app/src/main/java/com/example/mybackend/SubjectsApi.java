package com.example.mybackend;

import retrofit2.Call;
import retrofit2.http.GET;

interface SubjectsApi {
    @GET("/greeting")
//    @Headers("Content-Type: application/json")
    Call<Subjects> getSubjects();
}
