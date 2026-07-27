package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private String name;
    private Address address;


    private List<LibraryItem> items;
    private List<LibraryMember> members;
    private List<Librarian> librarians;
    private List<LibraryItem> items = new ArrayList <>();
    // Scanner scanner = new Scanner(System.in); 

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
            System.out.println(
                    item.getItemType() + " | " +
                    item.getTitle() + " | " +
                    (item.isAvailable() ? "Available" : "Checked Out")
            );
        }
    }

    //Searching method
    

    public List<LibraryItem> search(String keyword) {
        List<LibraryItem> searchResults = new ArrayList<>();
        for (LibraryItem libraryItem : items) {
            if (libraryItem.matchesKeyword(keyword)) {
                searchResults.add(libraryItem);
            }
        }
        return searchResults;
    }

    public void generateLateFeeReport() {
        for (LibraryMember checkedkMember : members) {
            System.out.println(checkedkMember.getName() + " has $" + checkedkMember.getOutstandingFees() + " in late fees.");
        }
    }
        public int countItemsByType(Class<?> type) {
            int count = 0;

            for (LibraryItem item : items) {
                if (type.isInstance(item)) {
                    count++;
                }
            }
            return count;
        }
    
}