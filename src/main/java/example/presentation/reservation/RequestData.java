package example.presentation.reservation;

import example.domain.model.reservation.Request;
import example.domain.type.Remarks;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestData {
    Remarks remarks;

    public Request asModel(int id) {
        return new Request(id, remarks);
    }
}
