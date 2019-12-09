package com.example.booktime.API;

import com.example.booktime.model.Book;
import com.example.booktime.model.ListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BookTimeAPICall {

    @GET("volumes?q=%22%22&maxResults=40")
    Call<ListResponse> getListBook(@Query("startIndex") int index);

    @GET("volumes/{id}")
    Call<Book> getBookDetail(@Path("id") String id);

    /*
    call la liste :
    https://www.googleapis.com/books/v1/volumes?q=%22%22&maxResults=40&startIndex=0
    q="" tous les livres
    startindex += 40 pour changer de page
    */

    /*
    "selflink" : lien de l'appel api du livre avec l'id
     */

    /*
    Api key : AIzaSyCCAkI-DNlW3-AGEsydwz8ileskJflCV8M
     */
}
