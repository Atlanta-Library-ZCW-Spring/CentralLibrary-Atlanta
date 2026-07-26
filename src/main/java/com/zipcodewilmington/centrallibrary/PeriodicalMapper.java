package com.zipcodewilmington.centrallibrary;

public class PeriodicalMapper {
    int missingIdCounter = 1000;

    public Periodical mapToPeriodical(RawPeriodicalRecord raw) {

        String id = "P" + missingIdCounter;
        missingIdCounter++;

        String title = raw.title;
        String publisher = raw.publisher;
        String issn = raw.issn;

        String location = raw.location;
        if (location == null) {
            location = "Unknown";
        }

        String publicationDate = raw.publicationDate;

        int volume;
        if (raw.volume == null) {
            volume = 0;
        } else {
            volume = Integer.parseInt(raw.volume);
        }

        String issueNumber = raw.issue;

        return new Periodical(id, title, location, publisher, issn, volume, issueNumber, publicationDate);
    }
}



// package com.zipcodewilmington.centrallibrary;

//  class PeriodicalMapper {
//     int missingIdCounter = 1000;
//      public Periodical mapToPeriodical (RawPeriodicalRecord raw) {

//         String 
//          String title = raw.title;
//          String publisher = raw.publisher;
//          String issn = raw.issn;
//          String location = raw.location;

//          if (location == null) {
//             location = "Unknown";
//          } else {
//             location = raw.location;
//          }

//          String publicationDate = raw.publicationDate;
//          Integer pages = raw.pages;
//          String volume = raw.volume;

//          if (raw.volume == null) {
//             volume = "N/A";
//         } else {
//             volume = raw.volume.intValue();
//         }
//          String issue = raw.issue;
        

//         return new Periodical(id, title, location, publisher, issn, volume, issueNumber, publicationDate);
//     }
// }
