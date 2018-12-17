package com.example.arcus.laboratorijskevjezbe_android.Network;


import com.example.arcus.laboratorijskevjezbe_android.Models.CoursesResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface UdacityAPI {
    @GET("/public-api/v0/courses")
    Call<CoursesResponse> getCourses();
}