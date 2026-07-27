package com.zipcodewilmington.centrallibrary;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;
import java.util.*;

/**
 * Created by n3pjk on 6/9/2025.
 */
public class MainApplication {
    public static void main(String [] args) throws Exception {

//Addresses

Address address1 = new Address ("123 Main St", "Alexandra", "DE", "12345");
Address address2 = new Address ("456 Oak St", "Bookville", "MD", "12347");
Address address3 = new Address ("654 Maple St", "Media", "PA", "12346");
Address address4 = new Address ("600 Washington St","Wilmington","DE","19810");
Address address5 = new Address ("123 Candyland Ave", "Chester", "PA","19010");
Address address6 = new Address ("111 MLK Blvd", "Wilmington", "DE", "19805") ;
Address address7 = new Address ("800 Marshall St", "Middletown", "DE", "19702");


//Library 
Library centralLibraryAtlanta = new Library("Central Library Atlanta", address1);


//Librarian

Librarian hypatia = new Librarian (
    "Hypatia", 
    40,
    "hypatia@library.com",
    "555-0000",
    "L001",
    "Management",
    45000,
    centralLibraryAtlanta
);

Librarian krisYounger = new Librarian (
    "Kris Younger",
    65,
    "KrisGettingYounger@library.com",
    "123-4567",
    "L002",
    "Management Assistant",
    40000,
    centralLibraryAtlanta
);

//Members
LibraryMember alice = new LibraryMember(
    "Alice Johnson",
    25,
    "alice@email.com",
    "555-1234",
    "M001",
    "07/24/2026",
    address2,
    centralLibraryAtlanta
);

LibraryMember bob = new LibraryMember(
    "Bob Wilson",
    35,
    "bob@email.com",
    "555-4321",
    "M002",
    "07/24/2026",
    address3,
    centralLibraryAtlanta
);

LibraryMember danStabb = new LibraryMember(
    "Dan Stabb",
    21,
    "DanStabb@email.com",
    "001-0002",
    "M003",
    "07/24/2026",
    address4,
    centralLibraryAtlanta
);

LibraryMember paulKnight = new LibraryMember(
    "Paul Knight",
    26,
    "PaulTheDarkKnight@email.com",
    "678-4321",
    "M004",
    "07/24/2026",
    address5,
    centralLibraryAtlanta
);

LibraryMember gloriaBell = new LibraryMember(
    "Gloria Bell",
    23,
    "GloriaRingingBell@email.com",
    "912-8630",
    "M005",
    "07/24/2026",
    address6,
    centralLibraryAtlanta
);

LibraryMember jessicaYearwood = new LibraryMember(
    "Jessica Yearwood",
    21,
    "JessTheBest@email.com",
    "824-9156",
    "M006",
    "07/24/2026",
    address7,
    centralLibraryAtlanta
);

centralLibraryAtlanta.addLibrarian(hypatia);
centralLibraryAtlanta.addLibrarian(krisYounger);
centralLibraryAtlanta.addMember(alice);
centralLibraryAtlanta.addMember(bob);
centralLibraryAtlanta.addMember(danStabb);
centralLibraryAtlanta.addMember(paulKnight);
centralLibraryAtlanta.addMember(gloriaBell);
centralLibraryAtlanta.addMember(jessicaYearwood);
// centralLibraryAtlanta.addItem();

//LOADERS
ObjectMapper mapper = new ObjectMapper();
BookMapper bookMapper = new BookMapper();
PeriodicalMapper periodicalMapper = new PeriodicalMapper();
DVDMapper dvdMapper = new DVDMapper();
MusicMapper musicMapper = new MusicMapper();

///BookLoader
    File bookFile = new File("src/main/resources/data/booksout.json");
    List<RawBookRecord> rawBooks = mapper.readValue(bookFile, new TypeReference<List<RawBookRecord>>() {});

    for (RawBookRecord raw : rawBooks) {
    Book book = bookMapper.mapToBook(raw);
    centralLibraryAtlanta.addItem(book);
}

///PERIODOCALS LOADER
    File periodicalFile = new File("src/main/resources/data/clean_periodicals.json");
    List<RawPeriodicalRecord> rawPeriodicals = mapper.readValue(periodicalFile, new TypeReference<List<RawPeriodicalRecord>>() {});

    for (RawPeriodicalRecord raw : rawPeriodicals) {
    Periodical periodical = periodicalMapper.mapToPeriodical(raw);
    centralLibraryAtlanta.addItem(periodical);
}

/// DVD LOADER
    File dvdFile = new File("src/main/resources/data/dvdout_panda.json");
    List<RawDVDRecord> rawDVDs = mapper.readValue(dvdFile, new TypeReference<List<RawDVDRecord>>() {});

    for (RawDVDRecord raw : rawDVDs) {
    DVD dvd = dvdMapper.mapToDVD(raw);
    centralLibraryAtlanta.addItem(dvd);
}


/// MUSIC LOADER
    File musicFile = new File("src/main/resources/data/music_data.json");
    List<RawMusicRecord> rawMusic = mapper.readValue(musicFile, new TypeReference<List<RawMusicRecord>>() {});

    for (RawMusicRecord raw : rawMusic) {
    Music music = musicMapper.mapToMusic(raw);
    centralLibraryAtlanta.addItem(music);
}

System.out.println("Total items loaded: " + centralLibraryAtlanta.getItems().size());


//Librian output
System.out.println("Librarians:");

System.out.println(hypatia.getName());

System.out.println(krisYounger.getName());

//Member output
System.out.println("Members:");

System.out.println(danStabb.getName());

System.out.println(gloriaBell.getName());

System.out.println(jessicaYearwood.getName());

System.out.println(paulKnight.getName());

System.out.println(alice.getName());

System.out.println(bob.getName());
}// ends main






}