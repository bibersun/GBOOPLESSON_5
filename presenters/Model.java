package seminar.presenters;

import seminar.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();


    int reservationTable(Date date, int tableNo, String name);


//    int changeReservationTable(int oldReservation, Date orderDate, int tableNo, String name);

    void dropReservationTable(int oldReservation);
}
