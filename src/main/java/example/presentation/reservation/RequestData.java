package example.presentation.reservation;

import example.domain.model.reservation.Request;
import example.domain.type.Remarks;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestData {
    Remarks remarks;
    LocalDate date;
    LocalTime startTime;

    public Request asModel(int id) {
        return new Request(id, remarks, date, startTime);
    }
}
