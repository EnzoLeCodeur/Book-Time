package com.example.booktime.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Movie;
import android.util.Log;

import com.example.booktime.model.Book;
import com.example.booktime.view.BookListFrag;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class MenuController {

    private BookListFrag activity;

    private static final String PREFS = "PREFS";
    private static final String PREFS_MY_BOOKS = "PREFS_FAVORITE";
    private static final String PREFS_TO_READ = "PREFS_TO_SEE";
    private SharedPreferences sharedPreferences;

    private List<Book> listBook;

    public MenuController(BookListFrag activity) { this.activity = activity;}

    public void onCreate() {

        sharedPreferences = activity.getActivity().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        loadAPI();
    }

    public void loadAPI() {

        for(Book i : listBook) {
            listBook.add(i);
        }
        activity.showList(listBook);
    }
}
