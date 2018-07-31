package co.grandcircus.lab11;

public class UsedCar extends Car {
	private double mileage;

	public UsedCar() {
		super();
	}

	public UsedCar(String make, String model, int year, double price, double mileage) {
		super(make, model, year, price);
		this.mileage = mileage;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return String.format("%-10s%-15s%-8d$%-10.2f%.1f miles", getMake(), getModel(), getYear(), getPrice(),
				mileage);
	}

}
