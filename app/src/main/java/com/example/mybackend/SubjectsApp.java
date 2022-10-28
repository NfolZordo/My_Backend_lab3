package com.example.mybackend;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubjectsApp extends Application {

    public static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static SubjectsApi getSubjectsApi() {
        return getRetrofitInstance().create(SubjectsApi.class);
    }
}
//    public SubjectsApi subjectsApi;
//
//    public void onCreate() {
//        super.onCreate();
//        configureRetrofit();
//    }
//    private void configureRetrofit() {
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(httpLoggingInterceptor)
//                .build();
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://localhost:8080")
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        subjectsApi = retrofit.create(SubjectsApi.class);
//    }
//}
