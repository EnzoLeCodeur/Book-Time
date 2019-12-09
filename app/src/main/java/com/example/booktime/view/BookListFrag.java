package com.example.booktime.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booktime.R;
import com.example.booktime.controller.MenuController;
import com.example.booktime.model.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


public class BookListFrag extends Fragment {

    public int index = 0;
    public int idpage = 1;
    private RecyclerView recyclerView;
    private MenuController menuController;

    SharedPreferences sharedPreferences;
    private static final String PREFS = "PREFS";
    private static final String PREFS_MY_BOOKS = "PREFS_MY_BOOKS";
    private static final String PREFS_TO_READ = "PREFS_TO_READ";

    public BookListFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);
        recyclerView = view.findViewById(R.id.my_recycler_view);
        sharedPreferences = getActivity().getSharedPreferences(PREFS, Context.MODE_PRIVATE);

        menuController = new MenuController(this);
        start(view);

        return view;
    }

    public void start(View view) {

        final TextView page = view.findViewById(R.id.page);
        page.setText(String.format("Page %d", this.idpage));

        Button precedent = view.findViewById(R.id.precedent);
        Button suivant = view.findViewById(R.id.suivant);

        precedent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous(page, v);
            }
        });
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(page);
            }
        });

        reload();

    }
    public void showList(List<Book> input) {
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        String listJson = sharedPreferences.getString(PREFS_MY_BOOKS, null);
        Type listType = new TypeToken<List<Book>>() {}.getType();
        Gson gson = new Gson();
        List<Book> favorisList = gson.fromJson(listJson, listType);

        String listJson2 = sharedPreferences.getString(PREFS_TO_READ, null);
        Type listType2 = new TypeToken<List<Book>>(){}.getType();
        List<Book> aLireList = gson.fromJson(listJson2, listType2);

        RecyclerView.Adapter mAdapter = new BookTimeAdapter(
                input,
                favorisList,
                aLireList,
                getActivity(),
                new BookTimeAdapter.OnFavoriteClickListener() {
                    @Override
                    public void onFavoriteAdded(Book item) {
                        menuController.onFavoriteAdded(item);
                    }

                    @Override
                    public void onFavoriteRemove(Book item) { menuController.onFavoriteRemove(item); }
                },
                new BookTimeAdapter.OnALireClickListener() {
                    @Override
                    public void onALireAdded(Book item) {
                        menuController.onALireAdded(item);
                    }

                    @Override
                    public void onALireRemove(Book item) {
                        menuController.onALireRemove(item);
                    }
                });
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    public void next (TextView txtPage) {
        index+=40;
        idpage++;
        txtPage.setText(String.format("Page %d", this.idpage));
        reload();
    }

    public void previous (TextView txtPage, View view) {
        if(index !=0) {
            index-=40;
            idpage--;
            txtPage.setText(String.format("Page %d", this.idpage));
            reload();
        } else {
            Toast.makeText(view.getContext(), "Vous êtes à la 1ère page !", Toast.LENGTH_SHORT).show();
        }
    }

    public void reload() {
        menuController.onCreate();
    }
}
