package junit;

import parkRechner.ParkRechner;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

/**
 * Created by webermar on 31.05.2017.
 */
public class ParkRechnerTest {

    @Test
    public void testParkeUnter1h(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-01T00:44:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(2,payment);
    }

}