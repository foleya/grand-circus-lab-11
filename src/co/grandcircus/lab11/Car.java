package co.grandcircus.lab11;

public class Car {

	private String make;
	private String model;
	private int year;
	private double price;
	
	public Car(String make, String model, int year, double price) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
	}

	public Car() {
		this.make = "";
		this.model = "";
		this.year = 0;
		this.price =0;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// TODO: Better Formatting!
	@Override
	public String toString() {
		return String.format("%-10s%-15s%-8d$%.2f", make, model, year, price);
	}
	
}
