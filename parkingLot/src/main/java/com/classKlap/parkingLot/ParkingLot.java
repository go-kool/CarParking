package com.classKlap.parkingLot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import com.classKlap.parkingLot.pojo.Car;

public class ParkingLot {
	private TreeSet<Integer> parkingSlots;
	private TreeMap<Integer, Car> parkedCars = new TreeMap<Integer, Car>();
	private Map<String, Car> isCarExist = new HashMap<String, Car>();

	public TreeSet<Integer> getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(TreeSet<Integer> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	public TreeMap<Integer, Car> getParkedCars() {
		return parkedCars;
	}

	public void setParkedCars(TreeMap<Integer, Car> parkedCars) {
		this.parkedCars = parkedCars;
	}

	public Map<String, Car> getIsCarExist() {
		return isCarExist;
	}

	public void setIsCarExist(Map<String, Car> isCarExist) {
		this.isCarExist = isCarExist;
	}

	public String createParkingSloat(int size) {
		if (size <= 0) {
			return "Parking sloat can not be created";
		} else {
			parkingSlots = new TreeSet<Integer>();
			for (int i = 1; i <= size; i++)
				parkingSlots.add(i);
			return "Parking Lot is Created";
		}
	}

	public String parkACar(String regNumber, String color) {
		if (this.getIsCarExist().containsKey(regNumber)) {
			return "Car already exist with this \"+regNumber+\" number in parking slot";
		} else if (this.getParkingSlots().size() != 0) {
			int slotNumber = this.parkingSlots.first();
			Car car = new Car(regNumber, color);
			this.parkedCars.put(slotNumber, car);
			this.parkingSlots.remove(slotNumber);
			this.isCarExist.put(regNumber, car);
			return "Allocated slot number: " + slotNumber;
		} else
			return "Sorry , parking lot is full";
	}

	public String removingACarFromASlot(int slotNumber) {

		if (this.parkedCars.containsKey(slotNumber)) {
			this.isCarExist.remove(this.parkedCars.get(slotNumber).getCarNumber());
			this.parkedCars.remove(slotNumber);
			this.parkingSlots.add(slotNumber);

			return "Slot number " + slotNumber + " is free";
		}

		else if (this.parkingSlots.contains(slotNumber)) {
			return "Slot is already free";
		}

		else {
			return "Slot number does not exist";
		}
	}
	public String regNumberOfCarForAColor(String color) {
		String s="";
		if(this.parkedCars.size()>0) {
			Iterator<Entry<Integer, Car>> iterator = this.parkedCars.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Car> element = (Map.Entry<Integer, Car>) (iterator.next());
				Car car = element.getValue();
				if (car.getColor().equalsIgnoreCase(color))
					s += car.getCarNumber() + ", ";
			}
		}
		else
			s= "Not found  ";
		return s.substring(0, s.length() - 2);
	}

	public String slotNumberOfCarForAColor(String color) {
		String s = "";
		if (this.getParkingSlots().size() != 0) {
			for (Map.Entry<Integer, Car> integer : this.getParkedCars().entrySet()) {
				Car car = integer.getValue();
				if (car.getColor().equalsIgnoreCase(color))
					s += integer.getKey() + ", ";
			}
			return s;
		} else {
			return "Not found ";
		}
	}

	public String slotNumberOfCarForRegNumber(String regNumber) {
		if (this.parkedCars.size() > 0) {
			Iterator<Entry<Integer, Car>> iterator = this.parkedCars.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Car> element = (Map.Entry<Integer, Car>) (iterator.next());
				Car car = element.getValue();
				if (car.getCarNumber().equals(regNumber))
					return element.getKey().toString();
			}
		}
		return "Not found";
	}

	public String status() {
		String s = "";
		if (this.parkedCars.size() > 0) {
			Iterator<Entry<Integer, Car>> iterator = this.parkedCars.entrySet().iterator();
			s = "Slot No. Registration No Color\n";
			while (iterator.hasNext()) {
				Map.Entry<Integer, Car> element = (Map.Entry<Integer, Car>) (iterator.next());
				s += element.getKey() + " " + element.getValue().getCarNumber() + " " + element.getValue().getColor()
						+ "\n";
			}
		} else
			s = "No Car found in the Parking Slot";
		return s;
	}
}
