package Project.Actions;

import Project.BudgetManager;
import Project.Car;

import java.util.Comparator;
import java.util.List;

public class SortAction {
    public String execute(List<Car> cars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No parameter provided.\n";
        }

        String sortField = parameters[0];
        boolean descending = sortField.startsWith("-");
        if (descending) {
            sortField = sortField.substring(1);
        }

        Comparator<Car> comparator;
        switch (sortField) {
            case "brand" -> comparator = Comparator.comparing(Car::getBrand).thenComparing(Car::getModel);
            case "year" -> comparator = Comparator.comparingInt(Car::getYear);
            case "horsepower" -> comparator = Comparator.comparingInt(Car::getHorsepower);
            case "price" -> comparator = Comparator.comparingInt(Car::getPrice);
            case "mileage" -> comparator = Comparator.comparingInt(Car::getMileage);
            default -> {
                return "Unknown sort type: " + sortField;
            }
        }

        if (descending) {
            comparator = comparator.reversed();
        }

        cars.sort(comparator);
        return "List of cars has been sorted by: " + parameters[0] + "\n";
    }
}
