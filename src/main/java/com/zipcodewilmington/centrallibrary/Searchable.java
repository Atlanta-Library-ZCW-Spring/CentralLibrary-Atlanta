package com.zipcodewilmington.centrallibrary;

import java.util.*;

public interface Searchable {
    List<String> getSearchableFields(); //this is a promise saying any class using the Searchable interface has to utilize the method getSearchableFields that's supposed ot return a List of strings. The interface doesn't build the list, it just requires that one exists. --A J-note :)
    //because the above has no body the every class that implements searchable has to write their own. 

    default boolean matchesKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return false;
        } 
        
        for (String field : getSearchableFields()) {
            if (field != null && field.toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}
