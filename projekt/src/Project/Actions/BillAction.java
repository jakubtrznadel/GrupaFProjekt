package Project.Actions;

import Project.BudgetManager;
import Project.Car;

import java.util.List;

public class BillAction {
    public String execute(List<Car> cars, String[] parameters, BudgetManager budgetManager) {
        int totalBill = 0;
        StringBuilder sb = new StringBuilder();

        sb.append("List of purchased cars:\n");
        sb.append("| ID  | Brand           |   Model        | Price  |\n");
        sb.append("---------------------------------------------------\n");

        for (Car car : BuyAction.getPurchasedCars()) {
            sb.append(String.format("| %-3d | %-15s | %-14s | %-6d |\n",
                    car.getId(),
                    car.getBrand(),
                    car.getModel(),
                    car.getPrice()));
            totalBill += car.getPrice();
        }

        sb.append("---------------------------------------------------\n");
        sb.append("Total Bill: ").append(totalBill).append("\n");
        return sb.toString();
    }
}
