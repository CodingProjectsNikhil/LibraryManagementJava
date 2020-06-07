package model;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class Booking {

    public int bookId;
    public String userId;
    public int duration;
    public Date dueDate;
//    public int totalCount;
}
