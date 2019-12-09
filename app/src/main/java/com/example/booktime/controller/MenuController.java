package com.example.booktime.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Movie;
import android.util.Log;

import com.example.booktime.API.BookTimeAPICall;
import com.example.booktime.model.Book;
import com.example.booktime.model.ListResponse;
import com.example.booktime.view.BookListFrag;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuController {

    private BookListFrag activity;

    private static final String PREFS = "PREFS";
    private static final String PREFS_MY_BOOKS = "PREFS_MY_BOOKS";
    private static final String PREFS_TO_READ = "PREFS_TO_READ";
    private SharedPreferences sharedPreferences;
    private Gson gson;
    static final String BASE_URL = "https://www.googleapis.com/books/v1/";
    private List<Book> listBook;

    public MenuController(BookListFrag activity) { this.activity = activity;}

    public void onCreate() {

        sharedPreferences = activity.getActivity().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        start();
    }

    public void start() {

        gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        BookTimeAPICall restAPI = retrofit.create(BookTimeAPICall.class);

        Call<ListResponse> call = restAPI.getListBook(activity.index);

        call.enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                ListResponse restListResponse = response.body();
                listBook = restListResponse.getItems();
                activity.showList(listBook);
            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {
                Log.d("ERREUR", call+""+t);
            }
        });
    }

    public void onFavoriteAdded(Book currentBook) {
        List<Book> favoriteList = getFavoriteList();
        currentBook.setEst_favoris(true);
        favoriteList.add(currentBook);
        saveFavoriteList(favoriteList);
    }

    public void onFavoriteRemove(Book currentBook) {
        List<Book> favoriteList = getFavoriteList();
        currentBook.setEst_favoris(false);
        for (int i = 0; i < favoriteList.size(); i++) {
            System.out.println(favoriteList.get(i).getId() +"RRRRRRRRRRRRRRRRRRRRRRRRRRr"+currentBook.getId());
            if(favoriteList.get(i).getId().equals(currentBook.getId())){
                System.out.println(favoriteList.get(i).getId() +"WWWWWWWWWWWWWWWWWWWWWWWWWWWW"+currentBook.getId());
                favoriteList.remove(i);
                saveFavoriteList(favoriteList);
            }
        }
    }

    private void saveFavoriteList(List<Book> listBook) {
        String listJson = gson.toJson(listBook);
        sharedPreferences
                .edit()
                .putString(PREFS_MY_BOOKS, listJson)
                .apply();
    }

    private List<Book> getFavoriteList() {
        String jsonList = sharedPreferences.getString(PREFS_MY_BOOKS, null);
        if(jsonList != null){
            String listJson = sharedPreferences.getString(PREFS_MY_BOOKS, null);
            Type listType = new TypeToken<List<Book>>(){}.getType();
            return gson.fromJson(listJson, listType);
        } else {
            return new ArrayList<>();
        }
    }

    public void onALireAdded(Book currentBook) {
        List<Book> aLireList = getALireList();
        currentBook.setEst_a_lire(true);
        aLireList.add(currentBook);
        saveALireList(aLireList);
    }

    public void onALireRemove(Book currentBook) {
        List<Book> aLireList = getALireList();
        currentBook.setEst_a_lire(false);
        for (int i = 0; i < aLireList.size(); i++) {
            System.out.println(aLireList.get(i).getId() +"RRRRRRRRRRRRRRRRRRRRRRRRRRr"+currentBook.getId());
            if(aLireList.get(i).getId().equals(currentBook.getId())){
                System.out.println(aLireList.get(i).getId() +"WWWWWWWWWWWWWWWWWWWWWWWW"+currentBook.getId());
                aLireList.remove(i);
                saveALireList(aLireList);
            }
        }
    }

    private void saveALireList(List<Book> listBook) {
        String listJson = gson.toJson(listBook);
        sharedPreferences
                .edit()
                .putString(PREFS_TO_READ, listJson)
                .apply();
    }

    private List<Book> getALireList() {
        String jsonList = sharedPreferences.getString(PREFS_TO_READ, null);
        if(jsonList != null){
            String listJson = sharedPreferences.getString(PREFS_TO_READ, null);
            Type listType = new TypeToken<List<Book>>(){}.getType();
            return gson.fromJson(listJson, listType);
        } else {
            return new ArrayList<>();
        }
    }
}
