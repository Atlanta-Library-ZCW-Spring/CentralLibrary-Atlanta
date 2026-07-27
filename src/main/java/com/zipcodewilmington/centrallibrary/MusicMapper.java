package com.zipcodewilmington.centrallibrary;

public class MusicMapper {
   
    int missingIdCounter = 1000;
    public Music mapToMusic (RawMusicRecord raw) {

        String id = "M" + missingIdCounter;
        missingIdCounter++;

        String title = raw.track_name + " " + raw.release_date;
        String location = "Unknown";
        String artist = raw.artist_name;
        String track = raw.track_name;
        String genre = raw.genre;
        int duration = 0;

        return new Music(id, title, location, artist, track, genre, duration);
    }
}
