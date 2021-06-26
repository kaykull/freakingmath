package com.example.hoang_tuan_thanh;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkController {

    public static DemoService getApiInfo() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://68.183.234.90:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DemoService service = retrofit.create(DemoService.class);
        return service;
    }
}
