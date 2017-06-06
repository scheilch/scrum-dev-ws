package junit;

import org.junit.Before;
import parkRechner.ParkRechner;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

/**
 * Created by webermar on 31.05.2017.
 */
public class ParkRechnerTest {

    private ParkRechner parkRechner;
    private Instant startTime;

    @Before
    public void setUp(){
        parkRechner = new ParkRechner();
        startTime = Instant.parse("2017-03-01T00:00:00Z");
    }

    @Test
    public void testParkeUnter1h(){
        Instant endTime = Instant.parse("2017-03-01T00:44:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(2,payment);
    }

    @Test
    public void testParke2h(){
        Instant endTime = Instant.parse("2017-03-01T02:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(4,payment);
    }

    @Test
    public void testParke3h(){
        Instant endTime = Instant.parse("2017-03-01T03:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(6,payment);
    }

    @Test
    public void testParke6h(){
        Instant endTime = Instant.parse("2017-03-01T06:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(10,payment);
    }

    @Test
    public void testParke24h(){
        Instant endTime = Instant.parse("2017-03-02T00:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(10,payment);
    }

    @Test
    public void testParke1d1h(){
        Instant endTime = Instant.parse("2017-03-02T01:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(12,payment);
    }

    @Test
    public void testParke1d3h(){
        Instant endTime = Instant.parse("2017-03-02T03:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(16,payment);
    }

    @Test
    public void testParke1d6h(){
        Instant endTime = Instant.parse("2017-03-02T06:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(20,payment);
    }

    @Test
    public void testParke2d(){
        Instant endTime = Instant.parse("2017-03-03T00:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(20,payment);
    }

    @Test
    public void testParke2d4h(){
        Instant endTime = Instant.parse("2017-03-03T04:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(28,payment);
    }

    @Test
    public void testParke6d(){
        Instant endTime = Instant.parse("2017-03-07T00:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(60,payment);
    }

    @Test
    public void testParke6d6h(){
        Instant endTime = Instant.parse("2017-03-07T06:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(60,payment);
    }

    @Test
    public void testParke1W(){
        Instant endTime = Instant.parse("2017-03-08T00:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(60,payment);
    }

    @Test
    public void testParke3W(){
        Instant endTime = Instant.parse("2017-03-21T00:00:00Z");
        final int payment = parkRechner.parkeAufParkplatz(startTime,endTime);
        Assert.assertEquals(180,payment);
    }

    @Test
    public void testParkeUnter1hGarage(){
        Instant endTime = Instant.parse("2017-03-01T00:44:00Z");
        final int payment = parkRechner.parkeInDerGarage(startTime,endTime);
        Assert.assertEquals(2,payment);
    }

    @Test
    public void testParke3hGarage(){
        Instant endTime = Instant.parse("2017-03-01T03:00:00Z");
        final int payment = parkRechner.parkeInDerGarage(startTime,endTime);
        Assert.assertEquals(6,payment);
    }

}