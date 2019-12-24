package parkinglot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
        @Test
        public void givenAllottedDriver_ShouldReturnSameDriver() {
            Drivers drivers = new Drivers("Allen");
            Assert.assertEquals("Allen", drivers.getName());
        }
}
