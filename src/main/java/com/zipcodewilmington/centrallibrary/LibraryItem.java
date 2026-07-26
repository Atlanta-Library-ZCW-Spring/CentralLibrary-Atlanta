package com.zipcodewilmington.centrallibrary;
import java.util.List;

public abstract class LibraryItem implements Searchable {

    private String id;
    private String title;
    private String location;
    private boolean available;

    // Constructor
    public LibraryItem(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.available = true;
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getLocation() {
        return location;
    }
    public boolean isAvailable() {
        return available;
    }
    public void checkOut() {
    available = false;
    }
    public void checkIn() {
    available = true;
    }

    // @Override
    // public void matchesKeyword() {
    //     return null;
    // }



    // @Override 
    // public void getSearchableFields() {

    // }
    //I commented this out becase getSeatchableFileds doesn't need to be written in the LibraryItem itself.
    // getSearchableFields is abstract on the intefrace, so the a class that extends from library item needs to implement it but is doesn't have to be here
    //Additionally I believe the classes, sucha s Book.java for example already implements getSearchableFields()

    public abstract double calculateLateFee(int daysLate);

    public abstract int getMaxBorrowDays();

    public abstract String getItemType();

    // public abstract List<String> getSearchableFields();


}


