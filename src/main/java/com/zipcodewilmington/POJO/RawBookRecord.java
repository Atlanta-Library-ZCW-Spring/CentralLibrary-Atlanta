package com.zipcodewilmington.POJO;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

    public class RawBookRecord {
        public String title;
        public List<String> authors;
        public List<String> author_lifespan;
        public String isbn;
        public Integer numberOfPages;
        public String genre;
        public List<String> subjects;
        public String locc;
        public String recordID;

    }

