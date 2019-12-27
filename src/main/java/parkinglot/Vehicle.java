package parkinglot;

public class Vehicle {

    private String carName;
    private String numberPlate;
    private String colorOfCar;
    private Double timeOfParkingCar ;
    private Double allottedTime;
    private Integer parkingLotNumber;

    public Vehicle(String carName, String numberPlate, String colorOfCar, Double timeOfParkingCar, Double allottedTime) {
        this.carName = carName;
        this.numberPlate = numberPlate;
        this.colorOfCar = colorOfCar;
        this.timeOfParkingCar = timeOfParkingCar;
        this.allottedTime = allottedTime;
    }


    public Vehicle(String carName) {
    this.carName = carName;
    }

    public String getNumberPlate() { return numberPlate; }

    public String getCarName() {
        return carName;
    }

    public Integer getParkingLotNumber() { return parkingLotNumber; }

    public void setParkingLotNumber(Integer parkingLotNumber) { this.parkingLotNumber = parkingLotNumber; }

}
