package Project.Actions;

import Project.*;
import java.util.List;

public class BudgetAction {
    public static String execute(List<Car> cars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            int budget = budgetManager.getBudget();
            return "Current Budget: " + budget + " $\n";
        }

        int updatedBudget = Integer.parseInt(parameters[0]);

        int budget = budgetManager.updateBudget(updatedBudget);

        return "Budget updated to: " + budget + " $\n";
    }
}
