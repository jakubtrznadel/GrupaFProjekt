package Project.Actions;

import Project.BudgetManager;
import Project.Car;
import Project.CarLoader;

import java.io.IOException;
import java.util.List;


public class DeleteAction {

    public String execute(List<Car> cars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "Car ID not provided.\n";
        }

        int carId;
        try {
            carId = Integer.parseInt(parameters[0]);
        } catch (NumberFormatException e) {
            return "Invalid car ID format.\n";
        }

        Car carToDelete = null;
        for (Car car : cars) {
            if (car.getId() == carId) {
                carToDelete = car;
                break;
            }
        }

        if (carToDelete != null) {
            cars.remove(carToDelete);

            try {
                CarLoader.saveCars(cars, "cars.txt");
                return "Car with ID " + carId + " has been deleted.\n";
            } catch (IOException e) {
                return "Error saving changes to file.\n";
            }
        } else {
            return "Car with ID " + carId + " was not found.\n";
        }
    }
}
