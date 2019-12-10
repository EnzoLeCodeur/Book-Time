package com.example.booktime.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.booktime.R;
import com.example.booktime.controller.DetailController;
import com.example.booktime.model.Book;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public DetailActivity() {}
    private DetailController detailController;

    public String idBook = "";
    private String text = "  Auteur(s) :\n";
    private String textC = "  Catégorie(s) :\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        this.idBook = intent.getStringExtra(BookTimeAdapter.CLE_DONNEES_ID_BOOK);
        detailController = new DetailController(this);
        detailController.onCreate();
    }

    public void showDetails(String title, final String acheter, final String epub, Boolean is_epub, final String pdf, Boolean is_pdf,
                            final String online, List<String> authors, List<String> categories, String subtitle, String publisher, String publishedDate,
                            String description, Integer pageCount, String language, final String previewLink, final String infoLink, String image) {
        TextView textTitle = findViewById(R.id.title);
        textTitle.setText(title);

        Button acheterbtn = findViewById(R.id.buy);
        acheterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( acheter ) );
                startActivity(intent);
            }
        });

        Button epubbtn = findViewById(R.id.epub);
        if(is_epub) {
            epubbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(epub));
                    startActivity(intent);
                }
            });
        }

        Button pdfbtn = findViewById(R.id.pdf);
        if(is_pdf) {
            pdfbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdf));
                    startActivity(intent);
                }
            });
        }

        Button onlinebtn = findViewById(R.id.online);
        onlinebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(online));
                startActivity(intent);
            }
        });

        TextView txtauthors = findViewById(R.id.auteur);
        if(authors != null) {
            for(int i=0; i< authors.size(); i++) {
                text += authors.get(i)+"\n";
            }
        } else {
            text= "Auteur inconnu\n";
        }
        txtauthors.setText(text);

        TextView txtcategorie = findViewById(R.id.categorie);
        if (categories != null) {
            for (String item : categories) {
                textC += item+"\n";
            }
        }
        txtcategorie.setText(textC);

        TextView txtSubtitle = findViewById(R.id.subtitle);
        txtSubtitle.setText(subtitle);

        TextView txtpublisher = findViewById(R.id.publisher);
        txtpublisher.setText(String.format("  Editeur :\n%s", publisher));

        TextView txtdate = findViewById(R.id.date);
        txtdate.setText(String.format("  Date de publication :\n %s", publishedDate));


        final TextView txtdesc = findViewById(R.id.description);
        txtdesc.setVisibility(View.GONE);
        txtdesc.setText(description);
        TextView txtdesctitle = findViewById(R.id.desc_title);
        txtdesctitle.setText(String.format("Description (see more) :"));
        txtdesctitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtdesc.setVisibility( txtdesc.isShown()
                        ? View.GONE
                        : View.VISIBLE );
            }
        });


        TextView txtpagecount = findViewById(R.id.pagecount);
        txtpagecount.setText(String.format("  Nombre de pages :\n %s", pageCount));

        TextView txtlangue = findViewById(R.id.language);
        txtlangue.setText(String.format("  Langue :\n %s", language));

        Button previewbtn = findViewById(R.id.preview);
        previewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(previewLink));
                startActivity(intent);
            }
        });

        Button infobtn = findViewById(R.id.info);
        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(infoLink));
                startActivity(intent);
            }
        });

        ImageView img = findViewById(R.id.imagedetail);
        if(!image.equals("")) {
            Picasso.with(this).load(image).into(img);
        }

    }

}
