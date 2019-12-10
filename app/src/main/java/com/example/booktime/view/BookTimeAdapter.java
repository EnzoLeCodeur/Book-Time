package com.example.booktime.view;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booktime.R;
import com.example.booktime.model.Book;
import com.squareup.picasso.Picasso;


public class BookTimeAdapter extends RecyclerView.Adapter<BookTimeAdapter.ViewHolder> {

    public static final String CLE_DONNEES_ID_BOOK = "idBook";

    private Context context;
    private List<Book> values;
    private List<Book> fL;
    private List<Book> aLL;
    private final OnFavoriteClickListener lF;
    private final OnALireClickListener lA;
    private List<String> authors;
    private String text = "";

    public interface OnALireClickListener {
        void onALireAdded(Book item);
        void onALireRemove(Book item);
    }
    public interface OnFavoriteClickListener {
        void onFavoriteAdded(Book item);
        void onFavoriteRemove(Book item);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView imgView;
        public Button btnFavoris;
        public Button btnALire;
        public View layout;

        public ViewHolder(final View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.firstLine);
            txtFooter = v.findViewById(R.id.secondLine);
            imgView = v.findViewById(R.id.icon);
            btnFavoris = v.findViewById(R.id.favoris_btn);
            btnALire = v.findViewById(R.id.a_lire_btn);
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public BookTimeAdapter(List<Book> myDataset,
                           List<Book> favorisList,
                           List<Book> aLireList,
                           Context context,
                           OnFavoriteClickListener listenerF,
                           OnALireClickListener listenerA) {

        values = myDataset;
        this.context = context;
        fL = favorisList;
        aLL = aLireList;
        lF = listenerF;
        lA = listenerA;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BookTimeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Book currentBook = values.get(position);

        holder.txtHeader.setText(currentBook.getVolumeInfo().getTitle());
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent randomIntent = new Intent(context, DetailActivity.class);
                randomIntent.putExtra(CLE_DONNEES_ID_BOOK, currentBook.getId());
                context.startActivity(randomIntent);
            }
        });
        authors = currentBook.getVolumeInfo().getAuthors();

        if(authors != null) {
            for(int i=0; i< authors.size(); i++) {
                text = authors.get(i)+"\n";
            }
        } else {
            text= "Auteur inconnu\n";
        }
        holder.txtFooter.setText(text);

        if(currentBook.getVolumeInfo().getImageLinks() != null) {
            Picasso.with(context).load(currentBook.getVolumeInfo().getImageLinks().getThumbnail()).into(holder.imgView);
        }

        if(fL != null) {
            for (int i = 0; i < fL.size(); i++) {
                if (fL.get(i).getId().equals(currentBook.getId())) {
                    currentBook.setEst_favoris(true);
                    holder.btnFavoris.setText("♥");
                }
            }
        }

        holder.btnFavoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentBook.getEst_favoris()) {
                    holder.btnFavoris.setText("favoris");
                    Toast.makeText(v.getContext(), currentBook.getVolumeInfo().getTitle() + " supprimé des favoris", Toast.LENGTH_SHORT).show();
                    lF.onFavoriteRemove(currentBook);
                } else {
                    holder.btnFavoris.setText("♥");
                    Toast.makeText(v.getContext(), currentBook.getVolumeInfo().getTitle() + " ajouté aux favoris", Toast.LENGTH_SHORT).show();
                    lF.onFavoriteAdded(currentBook);
                }
            }
        });

        if(aLL != null) {
            for (int i = 0; i < aLL.size(); i++) {
                if (aLL.get(i).getId() == currentBook.getId()) {
                    currentBook.setEst_a_lire(true);
                    holder.btnALire.setText("☺");
                }
            }
        }

        holder.btnALire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentBook.getEst_a_lire()) {
                    holder.btnALire.setText("à lire");
                    Toast.makeText(v.getContext(), currentBook.getVolumeInfo().getTitle() + " supprimé des livres à lire", Toast.LENGTH_SHORT).show();
                    lA.onALireRemove(currentBook);
                } else {
                    holder.btnALire.setText("☺");
                    Toast.makeText(v.getContext(), currentBook.getVolumeInfo().getTitle() + " ajouté aux livres à lire", Toast.LENGTH_SHORT).show();
                    lA.onALireAdded(currentBook);
                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if(!values.isEmpty()) {
            return values.size();
        } else {
            return 0;
        }
    }

}
