package com.example.booktime.controller;

import android.util.Log;

import com.example.booktime.API.BookTimeAPICall;
import com.example.booktime.model.Book;
import com.example.booktime.view.DetailActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailController {

    private DetailActivity activity;
    private Gson gson;
    static final String BASE_URL = "https://www.googleapis.com/books/v1/";

    public DetailController(DetailActivity activity) {
        this.activity = activity;
    }

    public void onCreate() {
        gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        BookTimeAPICall restAPI = retrofit.create(BookTimeAPICall.class);

        Call<Book> call = restAPI.getBookDetail(activity.idBook);

        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                Book restDetailResponse = response.body();
                String title = restDetailResponse.getVolumeInfo().getTitle();
                activity.showDetails(title);
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Log.d("ERREUR", "API K.O.");
            }
        });
    }
}
