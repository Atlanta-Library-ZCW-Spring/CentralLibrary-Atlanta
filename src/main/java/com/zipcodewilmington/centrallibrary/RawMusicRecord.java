package com.zipcodewilmington.centrallibrary;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class RawMusicRecord {
    public String artist_name;
    public String track_name;
    public String genre;
    public String release_date;
}
