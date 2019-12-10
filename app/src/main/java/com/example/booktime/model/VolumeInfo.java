
package com.example.booktime.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VolumeInfo {

    public String getTitle() {
        return title;
    }

    public String title;

    public String getSubtitle() {
        return subtitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public List<String> getCategories() {
        return categories;
    }

    public String getLanguage() {
        return language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public String subtitle;
    public List<String> authors = null;
    public String publisher;
    public String publishedDate;
    public String description;
    public Integer pageCount;
    public List<String> categories = null;
    public ImageLinks imageLinks;
    public String language;
    public String previewLink;
    public String infoLink;


    public ImageLinks getImageLinks() {
        return imageLinks;
    }

}
