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
import android.widget.TextView;

import com.example.booktime.R;
import com.example.booktime.model.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


public class ToReadFrag extends Fragment {

    private static final String PREFS_TO_READ = "PREFS_TO_READ";
    private static final String PREFS = "PREFS";
    SharedPreferences sharedPreferences;

    private RecyclerView recyclerView;
    List<Book> aLireList;

    public ToReadFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        sharedPreferences = getActivity().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String listJson = sharedPreferences.getString(PREFS_TO_READ, null);
        Type listType = new TypeToken<List<Book>>(){}.getType();
        aLireList = gson.fromJson(listJson, listType);

        if(aLireList == null || aLireList.isEmpty()) {

            view = inflater.inflate(R.layout.fragment_liste_vide, container, false);
            TextView txtTop = view.findViewById(R.id.txtTop);
            txtTop.setText("Ta liste de films à voir est vide !");
            TextView txtBot = view.findViewById(R.id.txtBot);
            txtBot.setText("Ajoutez les films que vous voulez voir");
        } else  {
            view = inflater.inflate(R.layout.fragment_to_read, container, false);
            recyclerView = view.findViewById(R.id.my_recycler_view);
            showList(aLireList);
        }

        return view;
    }

    public void showList(List<Book> input) {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter mAdapter = new BookTimeAdapter(input, null, aLireList, getActivity(), null, null);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

}
