package com.example.shpock.Models.service;

import retrofit.Callback;
import retrofit.http.GET;

public interface ApiService {
    @GET("/mobile/interview-test/pirateships")
    void get_interview(Callback<Object> response);
}
