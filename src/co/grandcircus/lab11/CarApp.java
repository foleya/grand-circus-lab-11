package co.grandcircus.lab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CarApp {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		Car car1 = new Car("Ford", "Escape", 2016, 36999.99);
		Car car2 = new Car("Ford", "Fusion", 2013, 32999.99);
		Car car3 = new Car("Ford", "Taurus", 2018, 41999.99);
		UsedCar car4 = new UsedCar("Jeep", "Wrangler", 2000, 12999.99, 35987.6);
		UsedCar car5 = new UsedCar("Jeep", "Compass", 2007, 9999.99, 80921.2);
		UsedCar car6 = new UsedCar("Jeep", "Cherokee", 1997, 6999.99, 301733.6);

		CarLot myLot = new CarLot();
		myLot.addCar(car1);
		myLot.addCar(car2);
		myLot.addCar(car3);
		myLot.addCar(car4);
		myLot.addCar(car5);
		myLot.addCar(car6);

		// Main Menu Loop
		String mainMenuChoice = "";
		ArrayList<String> mainMenuOptions = new ArrayList<String>(Arrays.asList("List All Cars", "Add A Car",
				"Remove A Car", "Lookup A Car By Parking Space", "Quit Car App"));

		do {
			mainMenuChoice = getValidMenuChoice(scnr, mainMenuOptions);

			switch (mainMenuChoice) {

			case ("List All Cars"):
				myLot.listCars();
				System.out.println("Hit enter to return to the main menu");
				scnr.nextLine();
				break;

			case ("Add A Car"):
				myLot.addCar(getCarDetails(scnr));
				System.out.println("Car added! Hit enter to return to the main menu.");
				scnr.nextLine();
				break;
				
			case ("Remove A Car"):
				// TODO: Refactor this logic ...
				if (myLot.getLot().size() == 0) {
					// Lot is empty
					System.out.println("\n-- Sorry! The lot is empty! --\n");
					System.out.println("Hit enter to return to the main menu.");
					scnr.nextLine();
					break;
				} else {
					// Lot has cars in it
					System.out.println("Which car would you like to remove from the lot?");

					// Generate a list of the cars (String) for the getValidMenuChoice method
					ArrayList<String> carMenu = new ArrayList<String>();
					for (Car car : myLot.getLot()) {
						carMenu.add(car.toString());
					}

					// Let user choose car to remove (String).
					String carChoice = getValidMenuChoice(scnr, carMenu);

					// Lookup the (int) index of that car (String) in the lot
					int indexOfCarChoice = carMenu.indexOf(carChoice);

					// Remove that car from the lot (by index)
					myLot.removeCar(indexOfCarChoice);
					// TODO: Better Formatting
					System.out.println("\nOk! [" + carChoice + "] has been removed!");
					System.out.println("Hit enter to return to the main menu.");
					scnr.nextLine();
					break;
				}

			case ("Lookup A Car By Parking Space"):
				break;

			case ("Quit Car App"):
				System.out.println("\nOk, goodbye!");

			}

		} while (!mainMenuChoice.equals("Quit Car App"));

		scnr.close();

	}

	// TODO: Add validation!
	private static Car getCarDetails(Scanner scnr) {
		// Prompt User for Car Details
		System.out.println("To add a car to the lot, please enter...");
		// Get Make
		System.out.println("The car's make:");
		String make = scnr.nextLine();
		// Get Model
		System.out.println("The car's model:");
		String model = scnr.nextLine();
		// Get Year
		System.out.println("The car's year:");
		int year = Integer.parseInt(scnr.nextLine());
		// Get Price
		System.out.println("The car's price:");
		double price = Double.parseDouble(scnr.nextLine());

		// Check if new or used
		System.out.println("Is the car used? (y/N)");
		if (scnr.nextLine().toLowerCase().trim().equals("y")) {
			System.out.println("Enter its mileage:");
			double mileage = Double.parseDouble(scnr.nextLine());
			return new UsedCar(make, model, year, price, mileage);
		} else {
			return new Car(make, model, year, price);
		}
	}

	public static void displayMenu(ArrayList<String> menuOptions) {
		int optionNum = 1;
		for (String option : menuOptions) {
			System.out.println(optionNum + ". " + option);
			optionNum++;
		}
	}

	public static void validateChoiceInOptions(int userInput, int numOptions) {
		if (userInput < 1 || userInput > numOptions) {
			throw new IllegalArgumentException();
		}
	}

	public static String getValidMenuChoice(Scanner scnr, ArrayList<String> menuOptions) {
		displayMenu(menuOptions);
		boolean inputIsValid = false;
		System.out.println("Please select an option (1-" + menuOptions.size() + "):");
		int menuChoice = 0;
		do {
			try {
				menuChoice = Integer.parseInt(scnr.nextLine());
				validateChoiceInOptions(menuChoice, menuOptions.size());
				inputIsValid = true;
			} catch (IllegalArgumentException ex) {
				System.out.println("You must enter an option numbered 1-" + menuOptions.size() + "):");
			}
		} while (!inputIsValid);

		return menuOptions.get(menuChoice - 1);
	}

}
