package com.rsjava.securityauthorize.car.mapper;

import com.rsjava.securityauthorize.car.model.CarEntity;
import com.rsjava.securityauthorize.car.request.CarRequest;
import com.rsjava.securityauthorize.car.response.CarResponse;

public class CarMapper {

    public static CarEntity mapToEntity(CarRequest request) {
        return new CarEntity(
                request.getBrand(),
                request.getModel(),
                request.getYear(),
                request.getPrice()
        );
    }

    public static CarResponse mapToResponse(CarEntity entity) {
        return new CarResponse(
                entity.getUuid(),
                entity.getId(),
                entity.getBrand(),
                entity.getModel(),
                entity.getYear(),
                entity.getPrice(),
                entity.getCreationDateTime());
    }
}
