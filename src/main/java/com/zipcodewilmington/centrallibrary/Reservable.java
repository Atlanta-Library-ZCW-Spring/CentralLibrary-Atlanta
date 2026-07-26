package com.zipcodewilmington.centrallibrary;
import java.util.*;

public interface Reservable {

    boolean isReserved();

    LibraryMember getReserved();

    void reserve(LibraryMember member);

    void cancelReserve();
} 
