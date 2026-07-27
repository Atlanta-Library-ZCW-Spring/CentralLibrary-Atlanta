package com.zipcodewilmington.centrallibrary;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

    public class RawPeriodicalRecord {
        public String title;
        public String publisher;
        public String issn;
        public String location;
        public String publicationDate;
        public Integer pages;
        public String volume;
        public String issue;
        // public String location;

    }

