package com.anuj.retrofitsample.Interface;

import com.anuj.retrofitsample.Items.User;
import com.anuj.retrofitsample.Items.UserCred;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APICalls {
    @POST("users")
    Call<User> registerUser(@Body User user);

    @DELETE("/route3")
    Call<String > function3(@Header("Authorization") String auth_key);
}
