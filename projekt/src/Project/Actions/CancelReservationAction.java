package Project.Actions;


import java.io.IOException;
import java.util.List;
import java.util.Objects;

import Project.BudgetManager;
import Project.Car;
import Project.CarLoader;

public class CancelReservationAction {

    public String execute(List<Car> cars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No reservation number provided.\n";
        }

        String carReservation = parameters[0];

        Car car = findCarByReservation(cars, carReservation);
        if (car == null) {
            return "Car with reservation number " + carReservation + " not found.\n";
        }

        if (car.getReservation() == null || car.getReservation().isEmpty()) {
            return "Car with reservation number " + carReservation + " does not have an active reservation.\n";
        }

        
        car.setReservation("null");

        try {
            CarLoader.saveCars(cars, "cars.txt"); 
            return "Reservation for Car with reservation number " + carReservation + " has been cancelled.\n";
        } catch (IOException e) {
            return "Error saving changes to file.\n";
        }
    }

    private Car findCarByReservation(List<Car> cars, String reservation) {
        for (Car car : cars) {
            if (Objects.equals(car.getReservation(), reservation)) {
                return car;
            }
        }
        return null;
    }
}
