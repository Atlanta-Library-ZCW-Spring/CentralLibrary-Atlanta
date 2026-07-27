package com.zipcodewilmington.centrallibrary;

public class Music extends LibraryItem implements Reservable {

    private String artist;
    private String track;
    private String genre;
    private int duration;

    private boolean isReserved;
    private LibraryMember reservedBy;
    public Music(
            String id,
            String title,
            String location,
            String artist,
            String track,
            String genre,
            int duration) {

        super(id, title, location);

        this.artist = artist;
        this.track = track;
        this.genre = genre;
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public String gettrack() {
        return track;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
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
        return "Music";
    }

    @Override
    public java.util.List<String> getSearchableFields() {
        return java.util.List.of(getTitle(), artist, track, genre);
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