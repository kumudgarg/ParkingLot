package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotManager {
    private final Integer PARKING_LOT_SIZE = 4;
    Map<String, Car> carParkedInParkingLot;


    public ParkingLotManager() {
        this.carParkedInParkingLot = new HashMap<>();
    }

    public void loadVehicleData(Car car) throws ParkingLotException {
       if (!isParkingLotsFull())
        carParkedInParkingLot.put(car.getNumberPlate(),car);

    }

    public int getOccupiedLot() {
        return carParkedInParkingLot.size();
    }

    public boolean isParkingLotsFull() throws ParkingLotException {
        if (getOccupiedLot() > PARKING_LOT_SIZE-1)
            throw new ParkingLotException("this parking lot is full,redirect to another parking lot building",ParkingLotException.ParkingSecurity.PARKING_LOT_IS_FULL);
        return false;
    }

    public boolean getUnparkVehicle(String numberPlate) throws ParkingLotException {
        if(!carParkedInParkingLot.isEmpty()){
            carParkedInParkingLot.remove(numberPlate);
            return true; }
        throw new ParkingLotException("there is no vehicle in parking lot",ParkingLotException.ParkingSecurity.PARKING_LOT_IS_EMPTY);
    }
}
