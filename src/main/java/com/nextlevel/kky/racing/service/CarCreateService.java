package com.nextlevel.kky.racing.service;

import com.nextlevel.kky.racing.core.Car;
import com.nextlevel.kky.racing.core.CarNameValidator;
import com.nextlevel.kky.racing.core.IntegerGenerator;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarCreateService {

    private final IntegerGenerator integerGenerator;

    public CarCreateService(IntegerGenerator integerGenerator) {
        this.integerGenerator = integerGenerator;
    }

    public List<Car> create(String[] carNames) {
        if (!CarNameValidator.checkValidation(carNames)) {
            throw new InvalidParameterException("유효하지 않은 이름 입니다!");
        }

        return Arrays.stream(carNames)
                .map(name -> new Car(name, integerGenerator, 0))
                .collect(Collectors.toList());
    }
}
