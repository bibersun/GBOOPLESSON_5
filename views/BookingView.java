package seminar.views;

import seminar.models.Reservation;
import seminar.models.Table;
import seminar.presenters.View;
import seminar.presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void showTables(Collection<Table> tables) {
        System.out.println("Распределение брони по столам");
        for (Table table : tables) {
            System.out.println(table);
            if (!table.getReservations().isEmpty()) {
                for (Reservation reservation : table.getReservations()) {
                    System.out.println("Бронь № " + reservation.getId());
                }

            }

        }
        System.out.println(" ");
        System.out.println(" ");
    }

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик забронирован, номер резерва %d\n", reservationNo);
        } else {
            System.out.println("Не забронировано");
        }
    }

    @Override
    public void showDropReservationTableResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Бронь снята, номер резерва %d\n", reservationNo);
        } else {
            System.out.println("Не снято");
        }
    }


    public void reservationTable(Date orderDate, int tableNo, String name) {
        System.out.println("Возбуждается событие...");
        System.out.println("Рассылка ...");
        for (ViewObserver observer : observers) {
            observer.onReservationTable(orderDate, tableNo, name);
        }
    }

    public void changeReservationTable(int oldReservation, Date orderDate, int tableNo, String name) {
        System.out.println("Возбуждается событие изменения...");
        System.out.println("Рассылка ...");
        for (ViewObserver observer : observers) {
            observer.onChangeReservationTable(oldReservation, orderDate, tableNo, name);
        }
    }

    public void dropReservationTable(int oldReservation) {
        System.out.println("Возбуждается событие удаления...");
        System.out.println("Рассылка ...");
        for (ViewObserver observer : observers) {
            observer.onDropReservationTable(oldReservation);
        }
    }

}
