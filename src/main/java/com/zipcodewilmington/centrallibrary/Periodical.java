package com.zipcodewilmington.centrallibrary;

public class Periodical extends LibraryItem {

    private String publisher;
    private String issn;
    private int volume;
    private String issueNumber;
    private String publicationDate;

    public Periodical(
            String id,
            String title,
            String location,
            String publisher,
            String issn,
            int volume,
            String issueNumber,
            String publicationDate) {

        super(id, title, location);

        this.publisher = publisher;
        this.issn = issn;
        this.volume = volume;
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIssn() {
        return issn;
    }

    public int getVolume() {
        return volume;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
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
        // return java.util.List.of(getTitle(), publisher, issn);
        return java.util.Arrays.asList(getTitle(), publisher, issn); //tolereates nulls
    }
}

