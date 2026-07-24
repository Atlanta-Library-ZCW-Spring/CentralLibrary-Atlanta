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
            System.out.println(
                    item.getItemType() + " | " +
                    item.getTitle() + " | " +
                    (item.isAvailable() ? "Available" : "Checked Out")
            );
        }
    }
    
}