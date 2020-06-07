import model.Book;
import model.Booking;

import java.util.*;

public class Processing {

    public Boolean issueBook(String title, String userId, int duration, List<Book> books, List<Booking> bookings) {
        int index = 0;
        Date startDate = Calendar.getInstance().getTime();

        for (Book bookValue : books
        ) {
            if (title == bookValue.title && bookValue.availableCount > 0) {
                for (Booking bookingValue : bookings
                ) {
                    if (bookingValue.userId == userId && bookValue.id == bookingValue.bookId) {
                        System.out.println("UserName is same.");
                        return false;
                    }
                }
                bookValue.setAvailableCount(--bookValue.availableCount);
//                bookValue.availableCount = ;
                books.set(index, bookValue);
                bookings.add(Booking.builder()
                        .bookId(bookValue.id)
                        .duration(duration)
                        .userId(userId)
                        .dueDate(getDueDate(startDate, duration))
                        .build());
                return true;
            }
            index++;
        }
        return false;
    }
    public void issueBookWithStatus(String title, String userId, int duration, List<Book> books, List<Booking> bookings){
        if(issueBook(title,userId,duration,books,bookings)){
            System.out.println("Book Issued");
        }else{
            System.out.println("Book not Available");
        }
    }

    public Date getDueDate(Date startDate, int duration) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DATE, duration);
        return cal.getTime();
    }

    public void status(List<Book> books) {
        int booksIssued = 0;
        int booksAvailable = 0;
        List<Book> issuedBooks = new ArrayList<Book>();
        System.out.println("Issued Books Details : ");
        for (Book bookValue : books
        ) {
            booksIssued = booksIssued + bookValue.count - bookValue.availableCount;
            booksAvailable = booksAvailable + bookValue.availableCount;
            if (bookValue.availableCount < bookValue.count) {
                issuedBooks.add(bookValue);
                bookDetailsDisplay(bookValue);
            }
        }
        System.out.println("Total Book Issued : " + booksIssued);
        System.out.println("Total Book Available : " + booksAvailable);
//        System.out.println(issuedBooks.);
    }

    public void bookDetailsDisplay(Book bookValue) {
        System.out.println("Id : " + bookValue.getId() +
                ", Title : " + bookValue.getTitle() +
                ", Author : " + bookValue.getAuthor() +
                ", Subject : " + bookValue.getSubject() +
                ", Publishing Year : " + bookValue.getPublicationYear() +
                ", Availability : " + bookValue.getAvailableCount()
        );
    }

    public Book searchBook(String title, List<Book> books, List<Booking> bookings) {
        for (Book bookValue : books
        ) {
            if (title == bookValue.title && bookValue.availableCount == 0) {
                bookDetailsDisplay(bookValue);
                checkMinAvailableDate(bookValue.id,bookings);
            } else if (title == bookValue.title) {
                bookDetailsDisplay(bookValue);
                return bookValue;
            }
        }
        return null;
    }
    public void checkMinAvailableDate(int id, List<Booking> bookings){
        Date minDate = null;
        for (Booking bookingValue: bookings
             ) {
            if(bookingValue.bookId == id){
                if(minDate == null){
                    minDate = bookingValue.dueDate;
                }
                if(minDate.compareTo(bookingValue.dueDate) < 0){
                    continue;
                }else{
                    minDate = bookingValue.dueDate;
                }
            }
        }
            System.out.println("Next Available Date : " + minDate);
    }
}

