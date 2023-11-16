package seminar.presenters;

import java.util.Date;

public interface ViewObserver {
    void onReservationTable(Date dateOrder, int tableNo, String name);

    void onDropReservationTable(int oldReservation);

    void onChangeReservationTable(int oldReservation, Date dateOrder, int tableNo, String name);

}
