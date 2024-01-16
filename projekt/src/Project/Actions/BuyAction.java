package Project.Actions;

import Project.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuyAction {
    private static final List<Car> purchasedCars = new ArrayList<>();

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

        Car carToBuy = null;
        for (Car car : cars) {
            if (car.getId() == carId) {
                carToBuy = car;
                break;
            }
        }

        if (carToBuy != null) {
            if (isCarReserved(carToBuy)) {
                return "Car with ID " + carId + " is reserved.\n";
            }

            if (budgetManager.canPurchase(carToBuy.getPrice())) {
                purchasedCars.add(carToBuy);
                cars.remove(carToBuy);
                budgetManager.purchaseCar(carToBuy.getPrice());

                try {
                    CarLoader.saveCars(cars, "cars.txt");
                    return "Car with ID " + carId + " got purchased.\n";
                } catch (IOException e) {
                    return "Error according to save file.\n";
                }
            } else {
                return "You're to poor.\n";
            }
        } else {
            return "Car with ID " + carId + " was not found.\n";
        }
    }

    public static List<Car> getPurchasedCars() {
        return purchasedCars;
    }

    private boolean isCarReserved(Car car) {
        return car.getReservation() != null && car.getReservation().matches("#\\d{3}");
    }
}
