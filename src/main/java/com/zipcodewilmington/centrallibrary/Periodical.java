package com.zipcodewilmington.centrallibrary;

public class Periodical extends LibraryItem {

    private String issueNumber;
    private String publicationDate;
    private String publisher;
    private String issn;
    private int volume;
    public Periodical(
            String id,
            String title,
            String location,
            String issueNumber,
            String publicationDate,
            String publisher) {

        super(id, title, location);

        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
        this.publisher = publisher;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.25;
    }

    @Override
    public int getMaxBorrowDays() {
        return 7;
    }

    @Override
    public String getItemType() {
        return "Periodical";
    }

    @Override
    public java.util.List<String> getSearchableFields() {
        return java.util.List.of(getTitle(), issueNumber, publisher);
    }
}