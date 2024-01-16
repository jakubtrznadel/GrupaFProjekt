package Project.Actions;

import Project.*;

import java.util.List;
import java.util.Scanner;

public class SellAction {
    private final Scanner scanner = new Scanner(System.in);

    public String execute(List<Car> cars, String[] parameters, BudgetManager budgetManager) {
        Car newCar = createCarFromUserInput();
        if (newCar != null) {
            int id = generateCarId(cars);
            newCar.setId(id);

            if (Math.random() < 0.5) {
                double discountPercent = 0.10 + Math.random() * 0.4;
                int currentPrice = newCar.getPrice();
                double discount = discountPercent * currentPrice;
                System.out.println("You're unlucky! You've met an angry salesman. He will buy the car only for this price:");
                System.out.println("Current price: " + currentPrice);
                System.out.println("Discounted price: " + (currentPrice - (int) discount));
                System.out.print("Do you want to continue with this price? (yes/no): ");
                String continueSale = scanner.nextLine().trim().toLowerCase();

                if (!continueSale.equals("yes")) {
                    return "Sale aborted. Car not added to the inventory.\n";
                }

                newCar.setPrice((int) (currentPrice - discount));
            }

            cars.add(newCar);
            budgetManager.sellCar(newCar.getPrice());
            try {
                CarLoader.saveCars(cars, "cars.txt");
                return "Car added to the inventory with ID: " + id + "\n";
            } catch (Exception e) {
                return "Failed to save the car to the file. Error: " + e.getMessage() + "\n";
            }
        }
        return "Failed to add the car to the inventory.\n";
    }

    private Car createCarFromUserInput() {
        try {
            Car newCar = new Car(0, null, null, null, null, 0, null, 0, 0, false, null, null, null, 0, null, null, null);

            System.out.println("Please enter car details:");

            System.out.print("Brand: ");
            newCar.setBrand(scanner.nextLine().trim());

            System.out.print("Model: ");
            newCar.setModel(scanner.nextLine().trim());

            System.out.print("Color: ");
            newCar.setColor(scanner.nextLine().trim());

            System.out.print("Type: ");
            newCar.setType(scanner.nextLine().trim());

            System.out.print("Year: ");
            newCar.setYear(Integer.parseInt(scanner.nextLine().trim()));

            System.out.print("Fuel: ");
            newCar.setFuel(scanner.nextLine().trim());

            System.out.print("Horsepower: ");
            newCar.setHorsepower(Integer.parseInt(scanner.nextLine().trim()));

            System.out.print("Mileage: ");
            newCar.setMileage(Integer.parseInt(scanner.nextLine().trim()));

            System.out.print("Damaged (true/false): ");
            newCar.setDamaged(Boolean.parseBoolean(scanner.nextLine().trim()));

            System.out.print("Gearbox: ");
            newCar.setGearbox(scanner.nextLine().trim());

            System.out.print("Drive: ");
            newCar.setDrive(scanner.nextLine().trim());

            System.out.print("VIN: ");
            newCar.setVin(scanner.nextLine().trim());

            System.out.print("Price: ");
            newCar.setPrice(Integer.parseInt(scanner.nextLine().trim()));

            System.out.print("Imported (If not, enter Poland): ");
            String importedValue = scanner.nextLine().trim();
            newCar.setImported(importedValue);

            if ("Poland".equalsIgnoreCase(importedValue)) {
                System.out.print("Plates: ");
                newCar.setPlates(scanner.nextLine().trim());
            } else {
                newCar.setPlates("none");
            }

            System.out.print("Reservation (#XXX, If not, leave blank): ");
            String reservationInput = scanner.nextLine().trim();
            if (reservationInput.isEmpty()) {
                newCar.setReservation(null);
            } else {
                newCar.setReservation(reservationInput);
            }


            return newCar;
        } catch (Exception e) {
            System.err.println("Error occurred while creating a new car: " + e.getMessage() + "\n");
            return null;
        }
    }

    private int generateCarId(List<Car> cars) {
        return cars.size() + 1;
    }
}
