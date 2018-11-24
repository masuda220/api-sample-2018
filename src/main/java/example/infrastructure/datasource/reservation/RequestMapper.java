package example.infrastructure.datasource.reservation;

import example.domain.model.reservation.Request;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RequestMapper {
    void register(@Param("request") Request request);

    Request findBy(@Param("id") int id);

    List<Request> listAll();

    int requestNumber();
}
