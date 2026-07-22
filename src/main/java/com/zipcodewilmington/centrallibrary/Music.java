package com.zipcodewilmington.centrallibrary;

public class Music extends LibraryItem {

    private String artist;
    private String album;
    private String genre;
    private int duration;

    public Music(
            String id,
            String title,
            String location,
            String artist,
            String album,
            String genre,
            int duration) {

        super(id, title, location);

        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
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
        return java.util.List.of(getTitle(), artist, album, genre);
    }
}