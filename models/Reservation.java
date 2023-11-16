package seminar.models;

import java.util.Date;

public class Reservation {
    public static int counter = 1000;
    private int id;
    private Date date;
    private String name;
    private final Table table;

    public int getId() {
        return id;
    }


    public Reservation(Table table, Date date, String name) {
        this.date = date;
        this.name = name;
        this.table = table;
        id = ++counter;
    }
}
