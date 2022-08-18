package com.example.qlty;

import com.example.qlty.Model.Appointment;
import com.example.qlty.Model.Client;
import com.example.qlty.Model.MEF;
import com.example.qlty.Model.Services;
import com.example.qlty.Model.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {
    //link api: http://localhost:6969/api/v1/users
    Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();

    ApiServices apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.12:8090/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServices.class);

    @GET("api/users/")
    Call<List<Users>> GetUsers();

    @GET("api/Services-name/")
    Call<List<Services>> GetServices();

    @GET("api/MEFs/")
    Call<List<MEF>> GetMEFByClientId();

    @GET("api/Clients/")
    Call<List<Client>> GetClientsByUID();

    @POST("api/users/")
    Call<Users> addUser(@Body Users users);

    @POST("api/Appointment/")
    Call<Appointment> addAppointment(@Body Appointment appointment);
}
