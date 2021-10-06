package utils;

import models.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.getDateStart().before(o2.getDateStart())) {
            return -1;
        } else if (o1.getDateEnd().after(o2.getDateEnd())) {
            return 1;
        } else return 0;
    }
}
