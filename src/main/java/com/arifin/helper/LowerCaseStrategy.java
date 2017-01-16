package com.arifin.helper;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * Created by ojiepermana on 1/12/2017.
 */
public class LowerCaseStrategy extends PropertyNamingStrategy.PropertyNamingStrategyBase {
    @Override
    public String translate(String input) {
        return input.toLowerCase();
    }
}
