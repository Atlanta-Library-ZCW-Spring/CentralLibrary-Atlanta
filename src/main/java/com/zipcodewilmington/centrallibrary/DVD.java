package com.zipcodewilmington.centrallibrary;

public class DVD extends LibraryItem implements Reservable{

    private String director;
    private int duration;
    private String rating;
    private String genre;

    private boolean isReserved;
    private LibraryMember reservedBy;

    public DVD(
            String id,
            String title,
            String location,
            String director,
            int duration,
            String rating,
            String genre) {

        super(id, title, location);

        this.director = director;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }

    public String getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.00;
    }

    @Override
    public int getMaxBorrowDays() {
        return 7;
    }

    @Override
    public String getItemType() {
        return "DVD";
    }

    @Override
    public java.util.List<String> getSearchableFields() {
        // return java.util.List.of(getTitle(), director, genre);
        return java.util.Arrays.asList(getTitle(), director, genre); //tolerates nulls
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