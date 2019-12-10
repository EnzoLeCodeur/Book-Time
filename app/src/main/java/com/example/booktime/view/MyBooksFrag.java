package com.example.booktime.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.booktime.R;
import com.example.booktime.model.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MyBooksFrag extends Fragment {

    private static final String PREFS_MY_BOOKS = "PREFS_MY_BOOKS";
    private static final String PREFS = "PREFS";
    SharedPreferences sharedPreferences;

    private RecyclerView recyclerView;
    List<Book> bookList;

    public MyBooksFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view;
        sharedPreferences = getActivity().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String listJson = sharedPreferences.getString(PREFS_MY_BOOKS, null);
        Type listType = new TypeToken<List<Book>>(){}.getType();
        bookList = gson.fromJson(listJson, listType);

        if(bookList == null || bookList.isEmpty()) {

            view = inflater.inflate(R.layout.fragment_liste_vide, container, false);
            ImageView img = view.findViewById(R.id.imageView);
            //img.setImageResource(R.drawable.empty_list_fav);
            TextView txtTop = view.findViewById(R.id.txtTop);
            txtTop.setText("Ta liste de films favoris est vide !");
            TextView txtBot = view.findViewById(R.id.txtBot);
            txtBot.setText("Ajoutez des films que vous préférez");

        } else {
            System.out.println(bookList+"RRRRRRRRRRRRRRRRRRRRRRRRR");
            view = inflater.inflate(R.layout.fragment_my_books, container, false);
            recyclerView = view.findViewById(R.id.my_recycler_view);
            showList(bookList);
        }

        return view;

    }

    public void showList(List<Book> input) {
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter mAdapter = new BookTimeAdapter(input, bookList, null, getActivity(), null, null);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

}
