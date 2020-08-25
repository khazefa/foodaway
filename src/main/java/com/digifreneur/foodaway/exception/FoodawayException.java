package com.digifreneur.foodaway.exception;

import com.digifreneur.foodaway.config.PropertiesConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodawayException {

    private static PropertiesConfig propertiesConfig;

    @Autowired
    public FoodawayException(PropertiesConfig propertiesConfig) {
        FoodawayException.propertiesConfig = propertiesConfig;
    }

    public static RuntimeException throwException(String messageTemplate, String...args) {
        return new RuntimeException();
    }
}