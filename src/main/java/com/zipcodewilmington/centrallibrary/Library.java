package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private String name;
    private Address address;

    private List<LibraryItem> items;
    private List<LibraryMember> members;
    private List<Librarian> librarians;

    // Constructor
    public Library(String name, Address address) {
        this.name = name;
        this.address = address;

        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.librarians = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public List<LibraryMember> getMembers() {
        return members;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    // Library methods
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
    }

    public void removeMember(LibraryMember member) {
        members.remove(member);
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    public void displayAllItems() {
        for (LibraryItem item : items) {

            String type = item.getItemType();
            String title = item.getTitle();

            String status;
            if (item.isAvailable()) {
                status = "Available";
            } else {
                status = "Checked Out";
            }

            System.out.println(type + " | " + title + " | " + status);
        }
    }

    // Searching method
    public List<LibraryItem> search(String keyword) {
        List<LibraryItem> searchResults = new ArrayList<>();

        int bookCount = 0;
        int dvdCount = 0;
        int periodicalCount = 0;
        int musicCount = 0;

        for (LibraryItem libraryItem : items) {

            if (libraryItem.matchesKeyword(keyword)) {

                if (libraryItem instanceof Book && bookCount < 10) {
                    searchResults.add(libraryItem);
                    bookCount++;
                } else if (libraryItem instanceof DVD && dvdCount < 10) {
                    searchResults.add(libraryItem);
                    dvdCount++;
                } else if (libraryItem instanceof Periodical && periodicalCount < 10) {
                    searchResults.add(libraryItem);
                    periodicalCount++;
                } else if (libraryItem instanceof Music && musicCount < 10) {
                    searchResults.add(libraryItem);
                    musicCount++;
                }
            }
        }

        return searchResults;
    }

    public void generateLateFeeReport() {
        for (LibraryMember checkedMember : members) {
            System.out.println(
                checkedMember.getName()
                + " has $"
                + checkedMember.getOutstandingFees()
                + " in late fees."
            );
        }
    }
}