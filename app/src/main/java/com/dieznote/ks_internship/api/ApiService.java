package com.dieznote.ks_internship.api;

import com.dieznote.ks_internship.models.NetResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/api/v2/pokemon/{username}")
    Call<NetResponse> searchRepos(@Path("username") String username);
}
