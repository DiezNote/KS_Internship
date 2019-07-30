package com.dieznote.ks_internship.api;

import com.dieznote.ks_internship.models.NetResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/api/v2/pokemon/")
    Call<NetResponse> searchRepos(@Query("q") String query);

    /*@GET("/users/{username}/repos")
    Call<List<ResponseItem>> getReposByUserName(@Path("username") String username);*/
}
