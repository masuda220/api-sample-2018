package example.application.service;

import example.domain.model.reservation.Request;

import example.application.repository.reservation.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public void register(Request request) {
        reservationRepository.register(request);
    }

    // TODO id should be ReservationNumber
    public Request findBy(int id) {
        return reservationRepository.findBy(id);
    }

    public int requestNumber() {
        return reservationRepository.requestNumber();
    }
}
