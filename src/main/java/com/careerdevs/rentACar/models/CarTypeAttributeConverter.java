package com.careerdevs.rentACar.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CarTypeAttributeConverter implements AttributeConverter<CarType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CarType carType) {
        if (carType == null) return null;

        return switch (carType) {
            case SEDAN -> 1;
            case SUV -> 2;
            case TRUCK -> 3;
            default -> throw new IllegalArgumentException(carType + "not supported yet.");
        };
    }

    @Override
    public CarType convertToEntityAttribute(Integer dbValue) {
        if (dbValue == null) return null;

        return switch (dbValue) {
            case 1 -> CarType.SEDAN;
            case 2 -> CarType.SUV;
            case 3 -> CarType.TRUCK;
            default -> throw new IllegalArgumentException(dbValue + "not supported yet.");
        };
    }
}
