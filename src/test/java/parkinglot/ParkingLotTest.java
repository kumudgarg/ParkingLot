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
}
