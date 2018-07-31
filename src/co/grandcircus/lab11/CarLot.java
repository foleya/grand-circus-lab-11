package co.grandcircus.lab11;

import java.util.ArrayList;

public class CarLot {

	private ArrayList<Car> lot;

	public CarLot() {
		this.lot = new ArrayList<Car>();
	}

	public CarLot(ArrayList<Car> lot) {
		this.lot = lot;
	}

	public void addCar(Car car) {
		lot.add(car);
	}

	public void removeCar(Car car) {
		lot.remove(car);

	}
	
	public void removeCar(int index) {
		lot.remove(index);
	}
	
	public void listCars() {
		if (lot.size() == 0) {
			System.out.println("\n-- Sorry! The lot is empty! --\n");
		} else {
			for (Car car : lot) {
				System.out.println(car);
			}
		}

	}

	public void lookupCarInPosition(int position) {

	}

	public ArrayList<Car> getLot() {
		return lot;
	}

	public void setLot(ArrayList<Car> lot) {
		this.lot = lot;
	}

}
