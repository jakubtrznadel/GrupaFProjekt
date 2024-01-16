package Project;

public class BudgetManager {
    private static int budget;

    public BudgetManager(int initialBudget) {
        this.budget = initialBudget;
    }

    public boolean canPurchase(int amount) {
        return amount <= budget;
    }

    public void purchaseCar(int amount) {
        if (canPurchase(amount)) {
            budget -= amount;
        }
    }

    public int updateBudget(int updatedBudget) {
        return budget = updatedBudget;
    }
    public void sellCar(int amount) {
        budget += amount;
    }

    public int getBudget() {
        return budget;
    }

}
