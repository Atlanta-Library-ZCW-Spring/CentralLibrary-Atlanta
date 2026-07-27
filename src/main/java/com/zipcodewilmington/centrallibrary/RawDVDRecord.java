package com.zipcodewilmington.centrallibrary;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

    public class RawDVDRecord {
        public String recordID;
        public String title;
        public String director;
        public Double duration;
        public String rating;
        public String genre;
        // public String location;

    }

