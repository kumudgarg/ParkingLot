package parkinglot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    Car[] carRegisters;

    @Before
    public void setUp() throws Exception {
        Car car1 = new Car("maruti", "MH05-DO1017", "Red", 11.55, 3.0);
        Car car2 = new Car("maruti", "MH05-DO10217", "Red", 11.55, 3.0);
        Car car3 = new Car("maruti", "MH05-DO10317", "Red", 11.55, 3.0);
        Car car4 = new Car("maruti", "MH05-DO10417", "Red", 11.55, 3.0);
        carRegisters = new Car[]{car1, car2, car3, car4};
    }

    @Test
    public void givenParkedCar_ShouldBeUnParkedTheSame() {
        Car car = new Car("Innova");
        Assert.assertEquals("Innova", car.getCarName());
    }

    @Test
    public void whenParkVehicleInParkingLots_ShouldReturnTotalParksVehicle() {
        try {
            int count = 0;
            ParkingLotManager parkingLotManager = new ParkingLotManager();
            for (Car car : carRegisters) {
                parkingLotManager.loadVehicleData(car);
            }
            Assert.assertEquals(4,carRegisters.length );
            } catch (ParkingLotException e) {
                e.printStackTrace();
            }

        }

    @Test
    public void givenParkingLot_IfOccupied_ShouldReturnOccupiedLotSize() {
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        int occupiedLot = parkingLotManager.getOccupiedLot();
        Assert.assertEquals(0, occupiedLot);
    }

    @Test
    public void givenParkingLot_IfOneCarIsParked_ShouldReturnSingleOccupiedParkingLots() {
        try {
            Car car = new Car("Lambo");
            ParkingLotManager parkingLotManager = new ParkingLotManager();
            parkingLotManager.loadVehicleData(car);
            int occupiedLot = parkingLotManager.getOccupiedLot();
            Assert.assertEquals(1, occupiedLot);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ParkingSecurity.PARKING_LOT_IS_FULL, e.type);
        }
    }

    @Test
    public void givenParkingLot_IfFourCarIsParkedWithFullData_ShouldReturnTotalOccupiedParkingLots() {
        try {
            ParkingLotManager parkingLotManager = new ParkingLotManager();
            for (Car car : carRegisters) {
                parkingLotManager.loadVehicleData(car);
            }
            int occupiedLot = parkingLotManager.getOccupiedLot();
            Assert.assertEquals(4, occupiedLot);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ParkingSecurity.PARKING_LOT_IS_FULL, e.type);
        }
    }

    @Test
    public void givenParkingLotData_IfVehicleUnpark_ShouldReturnRestOccupiedLots() {
        try {
            ParkingLotManager parkingLotManager = new ParkingLotManager();
            for (Car car : carRegisters) {

                parkingLotManager.loadVehicleData(car);
            }
            parkingLotManager.getUnparkVehicle("MH05-DO10217");
            Assert.assertEquals(3, parkingLotManager.getOccupiedLot());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkingLotSize_IfLotsLimitFull_ShouldReturnCustomExceptionType() {
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        try {
            for (Car car : carRegisters) {
                parkingLotManager.loadVehicleData(car);
            }
            parkingLotManager.getOccupiedLot();
            boolean lotsFull = parkingLotManager.isParkingLotsFull();
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ParkingSecurity.PARKING_LOT_IS_FULL, e.type);
        }
    }

    @Test
    public void givenParkingLot_IfParkingLotIsFull_ShouldThrowSecurityAlertException() {
        try {
            ParkingLotManager parkingLotManager = new ParkingLotManager();
            for (Car car : carRegisters) {
                parkingLotManager.loadVehicleData(car);
            }
            Car car5 = new Car("maruti", "MH05-DO10517", "Red", 11.55, 3.0);
            parkingLotManager.loadVehicleData(car5);
            int occupiedLot = parkingLotManager.getOccupiedLot();
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ParkingSecurity.PARKING_LOT_IS_FULL, e.type);
        }
    }



    @Test
    public void givenParkingLotData_IfVehicleUnpark_ShouldInformForEmptySpace() {
        try {
            ParkingLotManager parkingLotManager = new ParkingLotManager();
            for (Car car : carRegisters) {

                parkingLotManager.loadVehicleData(car);
            }
            parkingLotManager.getUnparkVehicle("MH05-DO10217");
            boolean lotsFull = parkingLotManager.isParkingLotsFull();
            Assert.assertFalse(lotsFull);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenEmptyParkingLotData_ShouldThrowCustomExceptionType() {
        try {
            ParkingLotManager parkingLotManager = new ParkingLotManager();
            parkingLotManager.getUnparkVehicle("MH05-DO10217");
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ParkingSecurity.PARKING_LOT_IS_EMPTY, e.type);
        }
    }

}

