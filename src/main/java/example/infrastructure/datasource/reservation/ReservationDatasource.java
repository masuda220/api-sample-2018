package example.infrastructure.datasource.reservation;

import example.domain.model.reservation.Request;
import example.domain.type.Remarks;

import example.application.repository.reservation.ReservationRepository;

import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ReservationDatasource implements ReservationRepository {

    RequestMapper requestMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    ReservationDatasource(RequestMapper requestMapper) {
        this.requestMapper = requestMapper;
    }

    @Override
    public int requestNumber() {
        return requestMapper.requestNumber();
    }

    @Override
    public void register(Request request) {
      requestMapper.register(request);
    }

    @Override
    public Request findBy(int id) {
        return requestMapper.findBy(id);
    }
}
