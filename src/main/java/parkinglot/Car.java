package parkinglot;

public class Car {
    private String carName;
    private String numberPlate;
    private String colorOfCar;
    private Double timeOfParkingCar ;
    private Double allottedTime;
    private String driverType;

    public Car() {
    }
    public Car(String carName, String numberPlate, String colorOfCar, Double timeOfParkingCar, Double allottedTime) {
        this.carName = carName;
        this.numberPlate = numberPlate;
        this.colorOfCar = colorOfCar;
        this.timeOfParkingCar = timeOfParkingCar;
        this.allottedTime = allottedTime;

    }

    public Car(String carName) {
    this.carName = carName;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getCarName() {
        return carName;
    }
}
