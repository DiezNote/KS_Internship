package com.dieznote.ks_internship.api;

import com.dieznote.ks_internship.models.ResponseErrorItem;

import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public abstract class ApiCallback<T> implements Callback<T> {
    //todo: наладить имена

    public abstract void success(Response<T> response);

    public abstract void failure(ResponseErrorItem gitRepoError);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (!response.isSuccessful()) {
            Converter<ResponseBody, ResponseErrorItem> converter = RestClient.getInstance().getRetrofit().responseBodyConverter(ResponseErrorItem.class, new Annotation[0]);

            try {
                ResponseErrorItem responseErrorItem = converter.convert(response.errorBody());
                failure(responseErrorItem);
            } catch (Exception e) {
                failure(new ResponseErrorItem("Unhandled error! Code: " + response.code()));
            }
        } else {
            success(response);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        failure(new ResponseErrorItem("Unexpected error! Info: " + t.getMessage()));
    }
}
