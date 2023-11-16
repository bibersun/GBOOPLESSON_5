package seminar;

import seminar.models.Table;
import seminar.models.TableModel;
import seminar.presenters.BookingPresenter;
import seminar.views.BookingView;

import java.util.Date;

public class Program {

    public static void main(String[] args) {


        TableModel tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.updateTableUI();
        bookingView.reservationTable(new Date(), 2, "Sergey");
        bookingView.reservationTable(new Date(), 2, "Sergey");
        bookingPresenter.updateTableUI();

        System.out.println("замена брони со второго столика на 3");
//        bookingPresenter.updateTableUI();
        bookingView.changeReservationTable(1001, new Date(), 3, "Сергей");
        bookingPresenter.updateTableUI();
        System.out.println("удаление брони 1002");
        bookingView.dropReservationTable(1002);
        bookingPresenter.updateTableUI();

    }

}
