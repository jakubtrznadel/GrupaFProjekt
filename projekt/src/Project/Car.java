package Project;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String color;
    private String type;
    private int year;
    private String fuel;
    private int horsepower;
    private int mileage;
    private boolean damaged;
    private String gearbox;
    private String drive;
    private String vin;
    private int price;
    private String imported;
    private String plates;
    private String reservation;

    public Car(int id, String brand, String model, String color, String type, int year,
               String fuel, int horsepower, int mileage, boolean damaged, 
               String gearbox, String drive, String vin, int price, 
               String imported, String plates, String reservation) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.type = type;
        this.year = year;
        this.fuel = fuel;
        this.horsepower = horsepower;
        this.mileage = mileage;
        this.damaged = damaged;
        this.gearbox = gearbox;
        this.drive = drive;
        this.vin = vin;
        this.price = price;
        this.imported = imported;
        this.plates = plates;
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean getDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImported() {
        return imported;
    }

    public void setImported(String imported) {
        this.imported = imported;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public String getReservation() {
        return reservation;
    }

    public String getPrivateReservation() {
        if(reservation.matches("#\\d{3}")) return "yes";
        return "no";
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public String toFileString() {
        return brand + ";" + model + ";" + color + ";" + type + ";" + year + ";" +
               fuel + ";" + horsepower + ";" + mileage + ";" + damaged + ";" +
               gearbox + ";" + drive + ";" + vin + ";" + price + ";" +
               imported + ";" + plates + ";" + reservation;
    }
}
