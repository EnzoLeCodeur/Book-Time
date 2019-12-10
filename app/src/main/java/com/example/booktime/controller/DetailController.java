package com.example.booktime.controller;

import android.content.Intent;
import android.util.Log;

import com.example.booktime.API.BookTimeAPICall;
import com.example.booktime.model.Book;
import com.example.booktime.view.DetailActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

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
                String acheter = restDetailResponse.getSaleInfo().getBuyLink();
                String epub = restDetailResponse.getAccessInfo().getEpub().getAcsTokenLink();
                Boolean is_epub = restDetailResponse.getAccessInfo().getEpub().getAvailable();
                String pdf = restDetailResponse.getAccessInfo().getPdf().getAcsTokenLink();
                Boolean is_pdf = restDetailResponse.getAccessInfo().getPdf().getAvailable();
                String online = restDetailResponse.getAccessInfo().getWebReaderLink();
                List<String> authors = restDetailResponse.getVolumeInfo().getAuthors();
                List<String> categories = restDetailResponse.getVolumeInfo().getCategories();
                String subtitle = restDetailResponse.getVolumeInfo().getSubtitle();
                String publisher  = restDetailResponse.getVolumeInfo().getPublisher();
                String publishedDate = restDetailResponse.getVolumeInfo().getPublishedDate();
                String description = restDetailResponse.getVolumeInfo().getDescription();
                Integer pageCount = restDetailResponse.getVolumeInfo().getPageCount();
                String language = restDetailResponse.getVolumeInfo().getLanguage();
                String previewLink = restDetailResponse.getVolumeInfo().getPreviewLink();
                String infoLink = restDetailResponse.getVolumeInfo().getInfoLink();
                String image = "";
                if(restDetailResponse.getVolumeInfo().getImageLinks() != null) {
                    image = restDetailResponse.getVolumeInfo().getImageLinks().getThumbnail();
                }

                activity.showDetails(title, acheter, epub, is_epub, pdf, is_pdf, online, authors, categories, subtitle, publisher, publishedDate, description, pageCount, language, previewLink, infoLink, image);
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Log.d("ERREUR", "API K.O.");
            }
        });
    }
}
