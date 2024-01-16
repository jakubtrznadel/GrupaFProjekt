package Project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarLoader implements IsReserved {

    public static List<Car> loadCars(String filename) throws IOException {
        List<Car> cars = new ArrayList<>();
        File file = new File(filename);
        int id = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                if (data.length != 16) {
                    throw new IllegalArgumentException("Wrong line format: " + line + "\n");
                }
                try {
                    
                    id++;
                    String brand = data[0];
                    String model = data[1];
                    String color = data[2];
                    String type = data[3];
                    int year = Integer.parseInt(data[4]);
                    String fuel = data[5];
                    int horsepower = Integer.parseInt(data[6]);
                    int mileage = Integer.parseInt(data[7]);
                    boolean damaged = Boolean.parseBoolean(data[8]);
                    String gearbox = data[9];
                    String drive = data[10];
                    String vin = data[11];
                    int price = Integer.parseInt(data[12]);
                    String imported = data[13];
                    String plates = data[14];
                    String reservation = data[15];
                    cars.add(new Car(id, brand, model, color, type, year, fuel, horsepower, mileage, damaged, gearbox, drive, vin, price, imported, plates, reservation));
                } catch (NumberFormatException e) {
                    System.err.println("Number conversion error in line: " + line + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename + "\n");
            throw e;
        }
        return cars;
    }

    @Override
    public boolean isReserved(String reservation) {
        return reservation != null && reservation.matches("#\\d{3}");
    }

    public static void saveCars(List<Car> cars, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Car car : cars) {
                writer.write(car.toFileString());
                writer.newLine();
            }
        }
    }
}
