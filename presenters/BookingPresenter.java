package seminar.presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateTableUI() {
        view.showTables(model.loadTables());

    }

    @Override
    public void onReservationTable(Date dateOrder, int tableNo, String name) {
        System.out.println("Презентер реагирует...");
        try {
            int reservationNo = model.reservationTable(dateOrder, tableNo, name);
            view.showReservationTableResult(reservationNo);
        } catch (RuntimeException e) {
            view.showReservationTableResult(-1);
        }
    }

    public void onDropReservationTable(int olReservation) {
        System.out.println("Презентер реагирует на удаление...");
        try {
            model.dropReservationTable(olReservation);
            view.showDropReservationTableResult(olReservation);
        } catch (RuntimeException e) {
            view.showDropReservationTableResult(-1);
        }


    }

    public void onChangeReservationTable(int oldReservation, Date dateOrder, int tableNo, String name) {
        System.out.println("Презентер реагирует на изменение...");
        try {
            model.dropReservationTable(oldReservation);
            int reservationNo = model.reservationTable(dateOrder, tableNo, name);
            view.showReservationTableResult(reservationNo);
            view.showDropReservationTableResult(oldReservation);
        } catch (RuntimeException e) {
            view.showReservationTableResult(-1);
        }


    }
}
