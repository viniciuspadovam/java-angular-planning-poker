package com.br.viniciuspadovam.planningpoker.vote.enums;

import com.br.viniciuspadovam.planningpoker.vote.interfaces.EstimateValue;

public enum Fibonacci implements EstimateValue {

	ONE(1), 
	TWO(2), 
	THREE(3), 
	FIVE(5), 
	EIGHT(8), 
	THIRTEEN(13), 
	TWENTYONE(21), 
	THIRTYFOUR(34), 
	FIFTHYFIVE(55);

	private int timeValue;

	private Fibonacci(int timeValue) {
		this.timeValue = timeValue;
	}
	
	public int getTimeValue() {
		return timeValue;
	}
	
	public static boolean contains(int number) {
        for (Fibonacci fib : Fibonacci.values()) {
            if (fib.timeValue == number) {
                return true;
            }
        }
        return false;
    }
	
}
