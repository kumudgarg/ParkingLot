package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotManager {
    Map<String, Car> carParkedInParkingLot;

    public ParkingLotManager() {
        this.carParkedInParkingLot = new HashMap<>();
    }

    public void loadVehicleData(Car car) {
        carParkedInParkingLot.put(car.getNumberPlate(),car);

    }

    public int getOccupiedLot() {
        return carParkedInParkingLot.size();
    }
}
