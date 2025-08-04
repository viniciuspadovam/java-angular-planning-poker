package com.br.viniciuspadovam.planningpoker.vote;

import com.br.viniciuspadovam.planningpoker.vote.enums.EstimateType;
import com.br.viniciuspadovam.planningpoker.vote.enums.Fibonacci;
import com.br.viniciuspadovam.planningpoker.vote.interfaces.EstimateValue;

public class EstimateFactory {

    public static Class<? extends EstimateValue> getEnumClass(EstimateType type) {
        return switch (type) {
            case FIBONACCI -> Fibonacci.class;
//            case WORK_DAY -> WorkDay.class;
        };
    }

    public static boolean isValueValid(EstimateType type, int value) {
        return switch (type) {
            case FIBONACCI -> Fibonacci.contains(value);
//            case WORK_DAY -> WorkDay.contains(value);
        };
    }
	
}
