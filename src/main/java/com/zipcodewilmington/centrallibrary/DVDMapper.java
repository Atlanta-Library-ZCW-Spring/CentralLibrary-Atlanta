package com.zipcodewilmington.centrallibrary;

public class DVDMapper {
    int missingIdCounter = 1000;
    public DVD mapToDVD (RawDVDRecord raw) {

        String id = raw.recordID;

            if (id == null) {
            id = "D" + missingIdCounter;
            missingIdCounter++;
        } 
        
        

        String title = raw.title;
        String location = "unknown";
        String director = raw.director;

        int duration;
        if (raw.duration == null) {
            duration = 0;
        } else {
            duration = raw.duration.intValue();
        }

        String rating = raw.rating;
        String genre = raw.genre;
        

        return new DVD(id, title, location, director, duration, rating, genre);
    }
}
