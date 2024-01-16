import Project.*;
import Project.Actions.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Car> cars = CarLoader.loadCars("cars.txt");
        List<Car> filteredcars = new ArrayList<>(cars);
        Scanner scanner = new Scanner(System.in);
        int initialBudget=0;

        BudgetManager budgetManager = new BudgetManager(initialBudget);


        Router router = new Router(new Route[]{
                new Route("list", ListAction.class, "execute"),
                new Route("buy", BuyAction.class, "execute"),
                new Route("bill", BillAction.class, "execute"),
                new Route("sell", SellAction.class, "execute"),
                new Route("filter:brand", FilterAction.class, "brand"),
                new Route("filter:model", FilterAction.class, "model"),
                new Route("filter:color", FilterAction.class, "color"),
                new Route("filter:type", FilterAction.class, "type"),
                new Route("filter:year", FilterAction.class, "year"),
                new Route("filter:fuel", FilterAction.class,"fuel"),
                new Route("filter:horsepower", FilterAction.class,"Horsepower"),
                new Route("filter:mileage", FilterAction.class,"Mileage"),
                new Route("filter:damaged", FilterAction.class,"damaged"),
                new Route("filter:gearbox", FilterAction.class,"gearbox"),
                new Route("filter:drive", FilterAction.class,"drive"),
                new Route("filter:imported", FilterAction.class,"imported"),
                new Route("filter:price", FilterAction.class,"price"),
                new Route("filter:reserved", FilterAction.class,"isReserved"),
                new Route("sort", SortAction.class,"execute"),
                new Route("reserve", ReserveCarAction.class, "execute"),
                new Route("cancel", CancelReservationAction.class, "execute"),
                new Route("delete", DeleteAction.class, "execute"),
                new Route("budget", BudgetAction.class, "execute"),

        });

        String menu = """
                Available operations:
                1.  Type 'list' or 'list <x>' to show list of cars
                2.  Type 'buy <id>' to purchase car
                3.  Type 'bill' to see the bill
                4.  Type 'sell' to sell your car
                5.  Type 'filter:<criterion> <x>' to filter cars
                6.  Type 'sort <criterion>' to sort cars
                7.  Type 'reserve <id>' to reserve a car
                8.  Type 'cancel <id>' to cancel the reservation
                9.  Type 'delete <id>' to delete the car
                10. Type 'budget' to see your budget or budget <x> to update your budget
                11. Type 'clear' to clear filters
                12. Type 'quit' to quit the program
                """;

        System.out.println("Welcome to our car shop!");
        System.out.println(menu);

            while (true) {
                System.out.print("Command: ");
                String userInput = scanner.nextLine().trim();
                if (userInput.equals("quit")) break;
                if (userInput.equals("clear")) {
                    filteredcars.clear();
                    filteredcars.addAll(cars);
                    System.out.println("Filters and sorting has been restored.\n");
                    continue;
                }

                Route route = router.match(userInput.split(" ")[0]);
                if (route == null) {
                    System.out.println("Command does not exist.\n");
                    continue;
                }

                String[] parameters = userInput.split(" ").length > 1
                        ? userInput.substring(userInput.indexOf(" ") + 1).split(" ")
                        : new String[0];

                Method method = route.getActionClass().getMethod(route.getMethod(), List.class, String[].class, BudgetManager.class);
                String result;
                if (userInput.equals("buy") || userInput.equals("sell")) {
                    result = (String) method.invoke(route.getActionClass().getDeclaredConstructor().newInstance(), cars, parameters, budgetManager);
                    filteredcars.clear();
                    filteredcars.addAll(cars);
                } else {
                    result = (String) method.invoke(route.getActionClass().getDeclaredConstructor().newInstance(), filteredcars, parameters, budgetManager);

                }
                System.out.println(result);
            }
        scanner.close();}
}