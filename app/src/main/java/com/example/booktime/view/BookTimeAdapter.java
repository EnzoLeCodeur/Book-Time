package com.example.booktime.view;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booktime.R;
import com.example.booktime.model.Book;
import com.squareup.picasso.Picasso;
import java.text.*;


public class BookTimeAdapter extends RecyclerView.Adapter<BookTimeAdapter.ViewHolder> {

    public static final String CLE_DONNEES_ID_BOOK = "idFilm";

    private Context context;
    private List<Book> values;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView imgView;
        public View layout;

        public ViewHolder(final View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.firstLine);
            txtFooter = v.findViewById(R.id.secondLine);
            imgView = v.findViewById(R.id.icon);
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public BookTimeAdapter(List<Book> myDataset) {
        values = myDataset;
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
    public void onBindViewHolder(ViewHolder holder, final int position) {


        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Book currentBook = values.get(position);

        holder.txtHeader.setText(currentBook.getTitle());
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent randomIntent = new Intent(context, DetailActivity.class);
                randomIntent.putExtra(CLE_DONNEES_ID_BOOK, currentBook.getId());
                context.startActivity(randomIntent);
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
