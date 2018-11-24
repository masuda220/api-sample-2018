package example.presentation.reservation;

import example.domain.model.reservation.Request;

import example.application.service.ReservationService;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class RequestQueryResolver implements GraphQLQueryResolver {

    ReservationService reservationService;

    RequestQueryResolver(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public List<Request> requests() {
        return reservationService.listAll();
    }

    public Request request(int id) {
        return reservationService.findBy(id);
    }

}
