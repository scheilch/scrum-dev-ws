package junit;


import jdk.nashorn.internal.ir.annotations.Ignore;
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
    public void setUp() throws Exception {
        this.parkRechner = new ParkRechner();
        this.startTime = Instant.parse("2017-03-01T00:00:00Z");
    }

    @Test
    public void testParkeUnter1h() {
        final Instant endTime = Instant.parse("2017-03-01T00:44:00Z");
        final int payment = parkRechner.parke(startTime, endTime);
        Assert.assertEquals(2, payment);
    }

    @Test
    public void testParkeFuerGenauEineStunde() throws Exception {
        final Instant endTime = Instant.parse("2017-03-01T01:00:00Z");
        final int payment = parkRechner.parke(startTime, endTime);
        Assert.assertEquals(2, payment);
    }
    @Test
    public void testParkeFuerDreiStunden() throws Exception {
        final Instant endTime = Instant.parse("2017-03-01T03:00:00Z");
        final int payment = parkRechner.parke(startTime, endTime);
        Assert.assertEquals(6, payment);
    }
    @Test
     public void testParkeFuerFuenfStunden() throws Exception {
        final Instant endTime = Instant.parse("2017-03-01T05:00:00Z");
        final int payment = parkRechner.parke(startTime, endTime);
        Assert.assertEquals(10, payment);
    }

    @Test
    public void testParkeFuerSechsStunden() throws Exception {
        final Instant endTime = Instant.parse("2017-03-01T06:00:00Z");
        final int payment = parkRechner.parke(startTime, endTime);
        Assert.assertEquals(10, payment);
    }

    //@Test
    public void testParkeFuerVierundzwanzigStunden() throws Exception {
        final Instant endTime = Instant.parse("2017-03-02T00:00:00Z");
        final int payment = parkRechner.parke(startTime, endTime);
        Assert.assertEquals(10, payment);
    }

    //@Test
    public void testParkeFuerEinTag1Stunde() throws Exception {
        final Instant endTime = Instant.parse("2017-03-02T01:00:00Z");
        final int payment = parkRechner.parke(startTime, endTime);
        Assert.assertEquals(12, payment);
    }

}