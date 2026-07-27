package com.zipcodewilmington.centrallibrary;

public class Book extends LibraryItem implements Reservable {

    private String author;
    private String isbn;
    // private int pages;
    private Integer pages; //changed b/c I decided to kee[ numberOfPages nullable since the source data is null in every record and int in java can never be null as it defaults 0 silentrly.]
    private String genre;

    private boolean isReserved;
    private LibraryMember reservedBy;

    public Book(
            String id,
            String title,
            String location,
            String author,
            String isbn,
            Integer pages,
            String genre) {

        super(id, title, location);

        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPages() {
        return pages;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.50;
    }

    @Override
    public int getMaxBorrowDays() {
        return 14;
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public java.util.List<String> getSearchableFields() {
        // return java.util.List.of(getTitle(), author, isbn, genre);
        return java.util.Arrays.asList(getTitle(), author, isbn, genre); //tolerates nulls
    }


    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public LibraryMember getReserved() {
        return reservedBy;
    }

    @Override
    public void reserve(LibraryMember member) {
        if (!isReserved) {
            isReserved = true;
            reservedBy = member;
        } else {
            System.out.println("This item is already reserved by someone else.");
        }
    }

    @Override
    public void cancelReserve() {
        isReserved = false;
        reservedBy = null;
    }

}