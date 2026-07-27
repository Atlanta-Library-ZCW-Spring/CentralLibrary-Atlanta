package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember extends Person {
    private String memberId;
    private String membershipDate;
    private List<LibraryItem> borrowedItems;
    private double outstandingFees;
    private Address address;
    private Library library;


    public LibraryMember(String name, int age, String email, String phoneNumber,
                      String memberId, String membershipDate, Address address, Library library) {
    super(name, age, email, phoneNumber);
    this.memberId = memberId;
    this.membershipDate = membershipDate;
    this.address = address;
    this.borrowedItems = new ArrayList<>();
    this.outstandingFees = 0.0;
    this.library = library;
} // calls super which runs Person's contructor and lets Person set its own private fields internally.

    public String getMemberId () {
        return memberId;
    }

    public String getMembershipDate () {
        return membershipDate;
    }

    public List<LibraryItem> getBorrowedItems() {
    return borrowedItems;
}

    public double getOutstandingFees () {
        return outstandingFees;
    }

    public Address getAddress () {
        return address;
    }

    public Library getLibrary() {
        return library;
    }

    public boolean borrowItem(LibraryItem item) {
        if (item.isAvailable()) {
            item.checkOut();
            borrowedItems.add(item);
            return true;
        } else {
            System.out.println("This item is unavailable please choose something else");
            return false;
        }
}


    public void returnItem(LibraryItem item, int daysLate) {
        item.checkIn();
        borrowedItems.remove(item);
        double fee = item.calculateLateFee(daysLate);
        this.outstandingFees += fee;
    }
    
    public void payFees (double amount) {
        this.outstandingFees -= amount;
    }
}
