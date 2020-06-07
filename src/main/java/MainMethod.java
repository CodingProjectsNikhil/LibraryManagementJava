import model.Book;
import model.Booking;

import java.util.ArrayList;
import java.util.List;

public class MainMethod {
    public static void main(String[] args) {
        System.out.println("Yes");
        List<Book> books = new ArrayList<Book>();
        List<Booking> bookings = new ArrayList<Booking>();
        Processing p = new Processing();
        //add book details using this builder function
        books.add(Book.builder()
                .author("Nikhil Jain")
                .availableCount(2)
                .count(2)
                .id(1)
                .publicationYear(2019)
                .subject("English")
                .title("Learn English Speaking")
                .build());

        //check the status of bool like below
        p.status(books);

        //if we just want to issue bool without any status message display
//        p.issueBook("Learn English Speaking","nikhil",3,books,bookings);

        // check the status of the book issued
        p.issueBookWithStatus("Learn English Speaking","nikhil",3,books,bookings);
        p.status(books);
        p.issueBookWithStatus("Learn English Speaking","ravi",2,books,bookings);
        p.issueBookWithStatus("Learn English Speaking","arpita",4,books,bookings);

        //gives the details of the book and also returns Book Object also if book is not available tells next available date
        p.searchBook("Learn English Speaking", books, bookings);
    }

}
