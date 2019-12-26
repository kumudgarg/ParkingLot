package parkinglot;

public class ParkingLotException extends Exception{
    public enum ParkingSecurity {
        PARKING_LOT_IS_FULL,PARKING_LOT_IS_EMPTY;
    }

    public ParkingSecurity type;

    public ParkingLotException(String ExceptionMessage, ParkingSecurity parkingSecurity) {
        super(ExceptionMessage);
        this.type = parkingSecurity;
    }

}
