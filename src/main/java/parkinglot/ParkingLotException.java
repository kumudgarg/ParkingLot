package parkinglot;

public class ParkingLotException extends Exception{
    public enum ParkingSecurity {
        PARKING_LOT_IS_FULL;
    }

    public ParkingSecurity type;

    public ParkingLotException(String ExceptionMessage, ParkingSecurity parkingSecurity) {
        super(ExceptionMessage);
        this.type = parkingSecurity;
    }

    public ParkingLotException() {
    }
}
