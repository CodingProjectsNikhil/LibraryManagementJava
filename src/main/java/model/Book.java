package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLOutput;
import java.util.*;

@Getter
@Setter
@Builder
public class Book {
    public int id;
    public String title;
    public String subject;
    public String author;
    public int publicationYear;
    public int count;
    public int availableCount;

//    public void add(Book bookValue){
//        id = bookValue.id;
//        title = bookValue.title;
//        subject = bookValue.subject;
//        author = bookValue.author;
//        publicationYear = bookValue.publicationYear;
//        count = bookValue.count;
//        availableCount = bookValue.count;
//    }


}
