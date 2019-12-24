package parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
        @Test
        public void givenAllottedDriver_ShouldReturnSameDriver() {
            Drivers drivers = new Drivers("Allen");
            Assert.assertEquals("Allen", drivers.getName());
        }

    @Test
    public void givenParkedCar_ShouldBeUnParkedTheSame() {
        Car car = new Car("Innova");
        Assert.assertEquals("Innova",car.getCarName());
    }

    @Test
    public void givenParkingLot_IfOccupied_ShouldReturnBooleanEquality() {
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        int occupiedLot = parkingLotManager.getOccupiedLot();
        Assert.assertEquals(0,occupiedLot);
    }

    @Test
    public void givenParkingLot_IfOneCarIsParked_ShouldReturnBooleanEquality() {
        Car car = new Car("Lambo");
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        parkingLotManager.loadVehicleData(car);
        int occupiedLot = parkingLotManager.getOccupiedLot();
        Assert.assertEquals(1,occupiedLot);
    }

    @Test
    public void givenParkingLot_IfOneCarIsParkedWithFullData_ShouldReturnBooleanEquality() {
//        String carName, String numberPlate, String colorOfCar, Double timeOfParkingCar, Double allottedTime
        Car car1 = new Car("maruti","MH05-DO1017","Red",11.55,3.0);
        Car car2 = new Car("maruti","MH05-DO10217","Red",11.55,3.0);
        Car car3 = new Car("maruti","MH05-DO10317","Red",11.55,3.0);
        Car car4 = new Car("maruti","MH05-DO10417","Red",11.55,3.0);
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        parkingLotManager.loadVehicleData(car1);
        parkingLotManager.loadVehicleData(car3);
        parkingLotManager.loadVehicleData(car2);
        parkingLotManager.loadVehicleData(car4);
        int occupiedLot = parkingLotManager.getOccupiedLot();
        Assert.assertEquals(4,occupiedLot);
    }
}
