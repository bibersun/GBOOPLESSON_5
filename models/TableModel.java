package seminar.models;

import seminar.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {
    private Collection<Table> tables;


    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : loadTables()) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();

            }

        }
        throw new RuntimeException("Некорректный номер столика");
    }


    @Override
    public void dropReservationTable(int oldReservation) {
        for (Table table : loadTables()) {
            if (!table.getReservations().isEmpty()) {
                table.getReservations().removeIf(reservation -> reservation.getId() == oldReservation);
            }

        }
    }

}
