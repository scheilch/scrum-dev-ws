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

    @Test
    public void testParke2h(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-01T02:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(4,payment);
    }

    @Test
    public void testParke3h(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-01T03:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(6,payment);
    }

    @Test
    public void testParke6h(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-01T06:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(10,payment);
    }

    @Test
    public void testParke24h(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-02T00:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(10,payment);
    }

    @Test
    public void testParke1d1h(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-02T01:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(12,payment);
    }

    @Test
    public void testParke1d3h(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-02T03:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(16,payment);
    }

    @Test
    public void testParke1d6h(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-02T06:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(20,payment);
    }

    @Test
    public void testParke2d(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-03T00:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(20,payment);
    }

    @Test
    public void testParke2d4h(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-03T04:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(28,payment);
    }

    @Test
    public void testParke6d(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-07T00:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(60,payment);
    }

    @Test
    public void testParke6d6h(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-07T06:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(60,payment);
    }

    @Test
    public void testParke1W(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-08T00:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(60,payment);
    }

    @Test
    public void testParke3W(){
        ParkRechner parkRechner = new ParkRechner();
        Instant startTime = Instant.parse("2017-03-01T00:00:00Z");
        Instant endTime = Instant.parse("2017-03-21T00:00:00Z");
        final int payment = parkRechner.parke(startTime,endTime);
        Assert.assertEquals(180,payment);
    }

}