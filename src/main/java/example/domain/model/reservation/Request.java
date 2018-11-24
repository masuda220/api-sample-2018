package example.domain.model.reservation;

import example.domain.type.Remarks;

import java.util.UUID;

public class Request {
    int id;
    Remarks remarks;

    public Request(int id, Remarks remarks) {
        this.id = id;
        this.remarks = remarks;
    }

    public Request() {

    }
}
