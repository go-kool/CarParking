package com.classKlap.parkingLot.pojo;

import java.util.regex.Pattern;

public class Car {

	private String carNumber;
	private String color;

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Car(String carNumber, String color) {
		super();
		this.carNumber = carNumber;
		this.color = color;
	}
}