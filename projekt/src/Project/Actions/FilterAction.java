package Project.Actions;

import Project.BudgetManager;
import Project.Car;

import java.util.List;
import java.util.stream.Collectors;

public class FilterAction {
    public String brand(List<Car> filteredcars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No filtration brand summary provided.\n";
        }

        String groupParameter = parameters[0];
        boolean excludeBrand = groupParameter.startsWith("-");
        String brand = excludeBrand ? groupParameter.substring(1) : groupParameter;

        List<Car> filteredCarsByBrand = filteredcars.stream()
                .filter(car -> excludeBrand != car.getBrand().equalsIgnoreCase(brand))
                .toList();

        filteredcars.clear();
        filteredcars.addAll(filteredCarsByBrand);

        return "The car list has been filtered by brand: " + brand + "\n";
    }

    public String model(List<Car> filteredCars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No model filtration criterion specified.\n";
        }

        String groupParameter = parameters[0];
        boolean excludeModel = groupParameter.startsWith("-");
        String model = excludeModel ? groupParameter.substring(1) : groupParameter;

        List<Car> filteredCarsByModel = filteredCars.stream()
                .filter(car -> excludeModel != car.getModel().equalsIgnoreCase(model))
                .toList();

        filteredCars.clear();
        filteredCars.addAll(filteredCarsByModel);

        return "The car list has been filtered by model: " + model + "\n";
    }

    public String color(List<Car> filteredCars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No color filtration criterion specified.\n";
        }

        String groupParameter = parameters[0];
        boolean excludeColor = groupParameter.startsWith("-");
        String color = excludeColor ? groupParameter.substring(1) : groupParameter;

        List<Car> filteredCarsByColor = filteredCars.stream()
                .filter(car -> excludeColor != car.getColor().equalsIgnoreCase(color))
                .toList();

        filteredCars.clear();
        filteredCars.addAll(filteredCarsByColor);

        return "The car list has been filtered by color: " + color + "\n";
    }

    public String type(List<Car> filteredCars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No type filtration criterion specified.\n";
        }

        String groupParameter = parameters[0];
        boolean excludeType = groupParameter.startsWith("-");
        String Type = excludeType ? groupParameter.substring(1) : groupParameter;

        List<Car> filteredCarsByType = filteredCars.stream()
                .filter(car -> excludeType != car.getType().equalsIgnoreCase(Type))
                .toList();

        filteredCars.clear();
        filteredCars.addAll(filteredCarsByType);

        return "The car list has been filtered by type: " + Type + "\n";
    }


    public String year(List<Car> filtereCars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No year filtration criterion specified.\n";
        }

        int yearfilter;
        try {
            yearfilter = Integer.parseInt(parameters[0]);
        } catch (NumberFormatException e) {
            return "Wrong number format: " + parameters[0] + "\n";
        }

        List<Car> FilteredCarsByYear;

        if (yearfilter >= 0) {
            FilteredCarsByYear = filtereCars.stream()
                    .filter(car -> car.getYear() >= yearfilter)
                    .collect(Collectors.toList());
        } else {
            int maxAge = Math.abs(yearfilter);
            FilteredCarsByYear = filtereCars.stream()
                    .filter(animal -> animal.getYear() <= maxAge)
                    .collect(Collectors.toList());
        }

        filtereCars.clear();
        filtereCars.addAll(FilteredCarsByYear);

        return "The car list has been filtered by year: " + yearfilter + "\n";
    }

    public String fuel(List<Car> filteredCars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No fuel filtration criterion specified.\n";
        }

        String groupParameter = parameters[0];
        boolean excludeFuel = groupParameter.startsWith("-");
        String Fuel = excludeFuel ? groupParameter.substring(1) : groupParameter;

        List<Car> filteredCarsByFuel = filteredCars.stream()
                .filter(car -> excludeFuel != car.getFuel().equalsIgnoreCase(Fuel))
                .toList();

        filteredCars.clear();
        filteredCars.addAll(filteredCarsByFuel);

        return "The car list has been filtered by fuel: " + Fuel + "\n";
    }

    public String Horsepower(List<Car> filteredCars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No horsepower filtration criterion specified.\n";
        }

        int horsepowerFilter;
        try {
            horsepowerFilter = Integer.parseInt(parameters[0]);
        } catch (NumberFormatException e) {
            return "Wrong number format: " + parameters[0] + "\n";
        }

        List<Car> filteredCarsByHorsepower;

        if (horsepowerFilter >= 0) {
            filteredCarsByHorsepower = filteredCars.stream()
                    .filter(car -> car.getHorsepower() >= horsepowerFilter)
                    .collect(Collectors.toList());
        } else {
            int maxHorsepower = Math.abs(horsepowerFilter);
            filteredCarsByHorsepower = filteredCars.stream()
                    .filter(car -> car.getHorsepower() <= maxHorsepower)
                    .collect(Collectors.toList());
        }

        filteredCars.clear();
        filteredCars.addAll(filteredCarsByHorsepower);

        return "The car list has been filtered by horsepower: " + horsepowerFilter + "\n";
    }

    public String Mileage(List<Car> filteredCars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No mileage filtration criterion specified.\n";
        }

        int mileageFilter;
        try {
            mileageFilter = Integer.parseInt(parameters[0]);
        } catch (NumberFormatException e) {
            return "Invalid number format: " + parameters[0] + "\n";
        }

        List<Car> filteredCarsByMileage;

        if (mileageFilter >= 0) {
            filteredCarsByMileage = filteredCars.stream()
                    .filter(car -> car.getMileage() >= mileageFilter)
                    .collect(Collectors.toList());
        } else {
            int maxMileage = Math.abs(mileageFilter);
            filteredCarsByMileage = filteredCars.stream()
                    .filter(car -> car.getMileage() <= maxMileage)
                    .collect(Collectors.toList());
        }

        filteredCars.clear();
        filteredCars.addAll(filteredCarsByMileage);

        return "The car list has been filtered by mileage: "+ mileageFilter +"\n";
    }

    public String damaged(List<Car> filteredCars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No damaged status filtration criterion specified.\n";
        }

        String statusParameter = parameters[0].toLowerCase();

        if (statusParameter.equals("yes")) {
            List<Car> damagedCars = filteredCars.stream()
                    .filter(car -> car.getDamaged())
                    .toList();

            filteredCars.clear();
            filteredCars.addAll(damagedCars);

            return "The car list has been filtered to show damaged cars.\n";
        } else if (statusParameter.equals("no")) {
            List<Car> nonDamagedCars = filteredCars.stream()
                    .filter(car -> !car.getDamaged())
                    .toList();

            filteredCars.clear();
            filteredCars.addAll(nonDamagedCars);

            return "The car list has been filtered to show non-damaged cars.\n";
        } else {
            return "Invalid command. Please use 'Yes' or 'No' to filter cars by damaged status.\n";
        }
    }

    public String gearbox(List<Car> filteredCars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No gearbox filtration criterion specified.\n";
        }

        String groupParameter = parameters[0];
        boolean excludeGearbox = groupParameter.startsWith("-");
        String Gearbox = excludeGearbox ? groupParameter.substring(1) : groupParameter;

        List<Car> filteredCarsByGearbox = filteredCars.stream()
                .filter(car -> excludeGearbox != car.getGearbox().equalsIgnoreCase(Gearbox))
                .toList();

        filteredCars.clear();
        filteredCars.addAll(filteredCarsByGearbox);

        return "The car list has been filtered by gearbox: " + Gearbox + "\n";
    }

    public String drive(List<Car> filteredCars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No drive filtration criterion specified.\n";
        }

        String groupParameter = parameters[0];
        boolean excludeDrive = groupParameter.startsWith("-");
        String Drive = excludeDrive ? groupParameter.substring(1) : groupParameter;

        List<Car> filteredCarsByDrive = filteredCars.stream()
                .filter(car -> excludeDrive != car.getDrive().equalsIgnoreCase(Drive))
                .toList();

        filteredCars.clear();
        filteredCars.addAll(filteredCarsByDrive);

        return "The car list has been filtered by drive: " + Drive + "\n";
    }

    public String imported(List<Car> filteredcars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No filtration import summary provided.\n";
        }

        String groupParameter = parameters[0];
        boolean excludeImported = groupParameter.startsWith("-");
        String Imported = excludeImported ? groupParameter.substring(1) : groupParameter;

        List<Car> filteredCarsByImported = filteredcars.stream()
                .filter(car -> excludeImported != car.getImported().equalsIgnoreCase(Imported))
                .toList();

        filteredcars.clear();
        filteredcars.addAll(filteredCarsByImported);

        return "The car list has been filtered by import: " + Imported + "\n";
    }

    public String price(List<Car> filteredCars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No price filtration criterion specified.\n";
        }

        int PriceFilter;
        try {
            PriceFilter = Integer.parseInt(parameters[0]);
        } catch (NumberFormatException e) {
            return "Invalid number format: " + parameters[0] + "\n";
        }

        List<Car> filteredCarsByPrice;

        if (PriceFilter >= 0) {
            filteredCarsByPrice = filteredCars.stream()
                    .filter(car -> car.getPrice() >= PriceFilter)
                    .collect(Collectors.toList());
        } else {
            int maxPrice = Math.abs(PriceFilter);
            filteredCarsByPrice = filteredCars.stream()
                    .filter(car -> car.getPrice() <= maxPrice)
                    .collect(Collectors.toList());
        }

        filteredCars.clear();
        filteredCars.addAll(filteredCarsByPrice);

        return "The car list has been filtered by price: "+ PriceFilter +"\n";
    }

    public String isReserved(List<Car> filteredCars, String[] parameters, BudgetManager budgetManager) {
        if (parameters.length == 0) {
            return "No reservation status filtration criterion specified.\n";
        }

        String statusParameter = parameters[0].toLowerCase();

        if (statusParameter.equals("yes")) {
            List<Car> reservedCars = filteredCars.stream()
                    .filter(car -> car.getReservation() != null && car.getReservation().matches("#\\d{3}"))
                    .toList();

            filteredCars.clear();
            filteredCars.addAll(reservedCars);

            return "The car list has been filtered to show reserved cars.\n";
        } else if (statusParameter.equals("no")) {
            List<Car> nonReservedCars = filteredCars.stream()
                    .filter(car -> car.getReservation() == null || !car.getReservation().matches("#\\d{3}"))
                    .toList();

            filteredCars.clear();
            filteredCars.addAll(nonReservedCars);

            return "The car list has been filtered to show non-reserved cars.\n";
        } else {
            return "Invalid command. Please use 'Yes' or 'No' to filter cars by reservation status.\n";
        }
    }
}
