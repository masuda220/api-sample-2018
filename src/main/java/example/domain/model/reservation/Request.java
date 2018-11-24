package example.domain.model.reservation;

import example.domain.type.Remarks;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Request {
    int id;
    Remarks remarks;
    LocalDate date;
    LocalTime startTime;

    public Request(int id, Remarks remarks, LocalDate date, LocalTime startTime) {
        this.id = id;
        this.remarks = remarks;
        this.date = date;
        this.startTime = startTime;
    }

    public Request() {

    }
}
