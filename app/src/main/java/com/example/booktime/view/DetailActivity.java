package com.example.booktime.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.booktime.R;
import com.example.booktime.controller.DetailController;
import com.example.booktime.model.Book;

public class DetailActivity extends AppCompatActivity {

    public DetailActivity() {}
    private DetailController detailController;

    public String idBook = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        this.idBook = intent.getStringExtra(BookTimeAdapter.CLE_DONNEES_ID_BOOK);
        detailController = new DetailController(this);
        detailController.onCreate();
    }

    public void showDetails(String title) {
        TextView textTitle = findViewById(R.id.title);
        textTitle.setText(title);
    }
}
