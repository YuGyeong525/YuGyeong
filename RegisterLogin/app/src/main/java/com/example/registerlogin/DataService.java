package com.example.registerlogin;
import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class DataService {
    private String BASE_URL = "http://3.88.102.16:8080/";
    UserApi userApi;

    public DataService(Context context) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Retrofit retrofitClient =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        userApi = retrofitClient.create(UserApi.class);
    }
}

interface UserApi {
    @POST("user/signup")
    Call<ResponseDto> signUp(@Body UserRequestDto.SignUp signup);

    @POST("user/login")
    Call<ResponseDto> login(@Body UserRequestDto.Login login);

    @GET("user/test")
    Call<String> test();
}