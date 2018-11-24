package example.infrastructure.datasource.reservation;

import example.domain.model.reservation.Request;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RequestMapper {
    void register(@Param("request") Request request);

    Request findBy(@Param("id") int id);

    int requestNumber();
}
