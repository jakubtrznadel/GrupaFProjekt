package Project.Actions;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Project.BudgetManager;
import Project.Car;
import Project.CarLoader;

public class ReserveCarAction {

    private CarLoader carLoader = new CarLoader();

    public String execute(List<Car> cars, String[] parameters, BudgetManager budgetManager) {

        if (parameters.length == 0) {
            return "No id provided.\n";
        }

        Scanner scanner = new Scanner(System.in);
        int carId = Integer.parseInt(parameters[0]);

        Car carToReserve = findCarById(cars, carId);
        if (carToReserve == null) {
            return "Car with ID " + carId + " not found.\n";
        }

        if (carLoader.isReserved(carToReserve.getReservation())) {
            return "Car with ID " + carId + " is already reserved.\n";
        }

        System.out.print("Enter reservation code (format: #xxx): ");
        String reservationCode = scanner.next();

        if (!reservationCode.matches("#\\d{3}")) {
            return "Invalid reservation code. It should be in the format #xxx.\n";
        }

        carToReserve.setReservation(reservationCode);
        
        try {
            CarLoader.saveCars(cars, "cars.txt");
            return "Car with ID " + carId + " has been reserved with code " + reservationCode + ".\n";
        } catch (IOException e) {
            return "Error saving changes to file.\n";
        }
    }

    private Car findCarById(List<Car> cars, int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }
}
