package com.zipcodewilmington.centrallibrary;

public class BookMapper {
    
    public Book mapToBook (RawBookRecord raw) {
        String id = raw.recordID;
        String title = raw.title;
        String location = raw.locc;
        String author = raw.authors.get(0);
        if (raw.authors.size() > 1) {
            author = author + " et al.";
        }
        String isbn = raw.isbn;
        Integer pages = raw.numberOfPages;
        String genre = raw.genre;

        return new Book(id, title, location, author, isbn, pages, genre);
    }
}
