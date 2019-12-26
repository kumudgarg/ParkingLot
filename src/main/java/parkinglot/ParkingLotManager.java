package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotManager {

    private final Integer PARKING_LOT_SIZE = 4;
    Map<String, Car> carParkedInParkingLot;
    Map<String, Integer> parkingLotNumberOfCars;
    Integer[] parkedSpots;
    Integer[] unParkedSpots;

    public ParkingLotManager() {

        this.carParkedInParkingLot = new HashMap<>();
        this.parkingLotNumberOfCars = new HashMap<>();
        parkedSpots = new Integer[PARKING_LOT_SIZE];
        unParkedSpots = new Integer[PARKING_LOT_SIZE];

        for (int parkingSopts =0; parkingSopts<=PARKING_LOT_SIZE-1;parkingSopts++){
            unParkedSpots[parkingSopts] = parkingSopts;
            parkedSpots[parkingSopts] = 0;
        }
    }

    public void loadVehicleData(Car car) throws ParkingLotException {
        if (!isParkingLotsFull())
            carParkedInParkingLot.put(car.getNumberPlate(), car);
            parkingLotNumberOfCars.put(car.getNumberPlate(),unParkedSpots[0]);
    }

    public int getOccupiedLot() {
        return carParkedInParkingLot.size();
    }

    public boolean isParkingLotsFull() throws ParkingLotException {
        if (getOccupiedLot() > PARKING_LOT_SIZE - 1)
            throw new ParkingLotException("this parking lot is full,redirect to another parking lot building", ParkingLotException.ParkingSecurity.PARKING_LOT_IS_FULL);
        return false;
    }

    public boolean getUnparkVehicle(String numberPlate) throws ParkingLotException {
        if (!carParkedInParkingLot.isEmpty()) {
            carParkedInParkingLot.remove(numberPlate);
            return true;
        }
        throw new ParkingLotException("there is no vehicle in parking lot", ParkingLotException.ParkingSecurity.PARKING_LOT_IS_EMPTY);
    }

}
