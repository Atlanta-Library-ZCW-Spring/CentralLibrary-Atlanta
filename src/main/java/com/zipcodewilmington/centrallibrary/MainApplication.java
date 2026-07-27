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

///END OF LOADERS




///////////////////////////////COMMAND lINE INTERFACE//////////////////////

Scanner scanner = new Scanner(System.in);

System.out.println("=== CENTRAL LIBRARY ATLANTA ===");
System.out.println("Are you a (1) Librarian or (2) Member?");
String roleChoice = scanner.nextLine().trim();

Librarian loggedInLibrarian = null;
LibraryMember loggedInMember = null;

if (roleChoice.equals("1")) {
    System.out.print("Enter your employee ID: ");
    String employeeId = scanner.nextLine().trim();
    for (Librarian librarian : centralLibraryAtlanta.getLibrarians()) {
        if (librarian.getEmployeeId().equals(employeeId)) {
            loggedInLibrarian = librarian;
            break;
        }
    }
    if (loggedInLibrarian == null) {
        System.out.println("No librarian found with that ID. Exiting.");
        return;
    }
    System.out.println("Welcome, " + loggedInLibrarian.getName() + ".");

} else if (roleChoice.equals("2")) {
    System.out.print("Enter your member ID: ");
    String memberId = scanner.nextLine().trim();
    for (LibraryMember member : centralLibraryAtlanta.getMembers()) {
        if (member.getMemberId().equals(memberId)) {
            loggedInMember = member;
            break;
        }
    }
    if (loggedInMember == null) {
        System.out.println("No member found with that ID. Exiting.");
        return;
    }
    System.out.println("Welcome, " + loggedInMember.getName() + ".");

} else {
    System.out.println("Invalid choice. Exiting.");
    return;
}

boolean running = true;

while (running) {

    if (loggedInLibrarian != null) {
        // ===== LIBRARIAN MENU =====
        System.out.println("\n--- Librarian Menu (" + loggedInLibrarian.getName() + ") ---");
        System.out.println("1. Search catalog");
        System.out.println("2. Add item to library");
        System.out.println("3. Remove item from library");
        System.out.println("4. View late fee report");
        System.out.println("0. Quit");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            System.out.print("Search keyword: ");
            String keyword = scanner.nextLine();
            List<LibraryItem> results = centralLibraryAtlanta.search(keyword);
            System.out.println("Found " + results.size() + " results:");
            for (LibraryItem item : results) {
                System.out.println("- " + item.getItemType() + ": " + item.getTitle());
            }

        } else if (choice.equals("2")) {
            System.out.print("New book title: ");
            String title = scanner.nextLine();
            Book newBook = new Book("B-NEW1", title, "Unknown", "Unknown Author", "N/A", 0, "Unknown");
            loggedInLibrarian.addItemToLibrary(newBook);
            System.out.println("Added: " + title);

        } else if (choice.equals("3")) {
            System.out.print("Exact title to remove: ");
            String title = scanner.nextLine();
            LibraryItem toRemove = null;
            for (LibraryItem item : centralLibraryAtlanta.getItems()) {
                if (item.getTitle().equalsIgnoreCase(title)) {
                    toRemove = item;
                    break;
                }
            }
            if (toRemove != null) {
                loggedInLibrarian.removeItemFromLibrary(toRemove);
                System.out.println("Removed: " + title);
            } else {
                System.out.println("No item found with that title.");
            }

        } else if (choice.equals("4")) {
            centralLibraryAtlanta.generateLateFeeReport();

        } else if (choice.equals("0")) {
            running = false;
            System.out.println("Goodbye, " + loggedInLibrarian.getName() + ".");

        } else {
            System.out.println("Invalid option.");
        }

    } else {
        // ===== MEMBER MENU =====
        System.out.println("\n--- Member Menu (" + loggedInMember.getName() + ") ---");
        System.out.println("1. Search catalog");
        System.out.println("2. Reserve an item");
        System.out.println("3. Borrow an item");
        System.out.println("4. Return an item");
        System.out.println("0. Quit");
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            System.out.print("Search keyword: ");
            String keyword = scanner.nextLine();
            List<LibraryItem> results = centralLibraryAtlanta.search(keyword);
            System.out.println("Found " + results.size() + " results:");
            for (LibraryItem item : results) {
                System.out.println("- " + item.getItemType() + ": " + item.getTitle());
            }

        } else if (choice.equals("2")) {
            System.out.print("Item title to reserve: ");
            String title = scanner.nextLine();
            for (LibraryItem item : centralLibraryAtlanta.getItems()) {
                if (item.getTitle().equalsIgnoreCase(title) && item instanceof Reservable) {
                    ((Reservable) item).reserve(loggedInMember);
                    System.out.println("Reserved: " + item.getTitle());
                    break;
                }
            }

        } else if (choice.equals("3")) {
            System.out.print("Item title to borrow: ");
            String title = scanner.nextLine();
            for (LibraryItem item : centralLibraryAtlanta.getItems()) {
                if (item.getTitle().equalsIgnoreCase(title)) {
                    loggedInMember.borrowItem(item);
                    break;
                }
            }

        } else if (choice.equals("4")) {
            System.out.print("Item title to return: ");
            String title = scanner.nextLine();
            System.out.print("Days late: ");
            int daysLate = Integer.parseInt(scanner.nextLine());
            for (LibraryItem item : loggedInMember.getBorrowedItems()) {
                if (item.getTitle().equalsIgnoreCase(title)) {
                    loggedInMember.returnItem(item, daysLate);
                    break;
                }
            }

        } else if (choice.equals("0")) {
            running = false;
            System.out.println("Goodbye, " + loggedInMember.getName() + ".");

        } else {
            System.out.println("Invalid option.");
        }
    }
}
scanner.close();

///////////////////////////////COMMAND lINE INTERFACE//////////////////////



/*


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

System.out.println("Total Books:" = centralLibraryAtlanta.countItemsByType(Book.class));
System.out.println("Total DVDs:" + centralLibraryAtlanta.countItemsByItemsyTyper(DVD.class));
System.out.println("Total Music:" + centralLibraryAtlanta.countItemsByType(Music.class));
System.out.println("Total Periodicals:" + cantralLibraryAtlanta.countItemsByTyper(Periodical.class));



*/



}// ends main






}