package Project.Actions;

import Project.BudgetManager;
import Project.Car;

import java.util.List;

public class ListAction {
    public String execute(List<Car> cars, String[] parameters, BudgetManager budgetManager) {
        int limit = cars.size();
        if (parameters.length > 0) {
            try {
                limit = Integer.parseInt(parameters[0]);
                if (limit < 0) {
                    return "Number must be positive.\n";
                }
            } catch (NumberFormatException e) {
                return "Wrong number format: " + parameters[0] + "\n";
            }
        }

        StringBuilder sb = new StringBuilder();
        if (cars.isEmpty()) {
            return "List of cars is empty.\n";
        }

        sb.append("| ID  | Brand           |   Model        | Color   | Type         | Year | Fuel   | Power | Mileage | Damaged | Gearbox   | Drive | VIN                | Imported   | Price    | Plates     | Reservation |\n");
        sb.append("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        int count = 0;
        for (Car car : cars) {
            if (limit > count) {
                sb.append(String.format("| %-3d | %-15s | %-14s | %-7s | %-12s | %-4d | %-6s | %-5d | %-7d | %-7s | %-9s | %-5s | %-18s | %-10s | %-8d | %-10s | %-11s |\n",
                        car.getId(),
                        car.getBrand(),
                        car.getModel(),
                        car.getColor(),
                        car.getType(),
                        car.getYear(),
                        car.getFuel(),
                        car.getHorsepower(),
                        car.getMileage(),
                        car.getDamaged() ? "yes" : "no",
                        car.getGearbox(),
                        car.getDrive(),
                        car.getVin(),
                        car.getImported(),
                        car.getPrice(),
                        car.getPlates(),
                        car.getPrivateReservation()));
                count++;
            }
        }

        return sb.toString();
    }
}
