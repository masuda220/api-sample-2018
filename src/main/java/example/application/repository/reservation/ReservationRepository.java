package example.application.repository.reservation;

import example.domain.model.reservation.Request;

import java.util.UUID;

public interface ReservationRepository {
    void register(Request request);
    Request findBy(int id) ;

    int requestNumber();
}
