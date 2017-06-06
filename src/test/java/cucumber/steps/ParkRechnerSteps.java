package cucumber.steps;

import parkRechner.ParkRechner;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by webermar on 30.05.2017.
 */
public class ParkRechnerSteps {

    private ParkRechner parkRechner;
    private int parkPreis;

    private Instant startTime = Instant.parse("2017-03-01T00:00:00Z");

    private static Map<String, Instant> endTimes() {
        final Map<String, Instant> numMap = new HashMap<>();
        numMap.put("30 min", Instant.parse("2017-03-01T00:30:00Z"));
        numMap.put("1 h", Instant.parse("2017-03-01T01:00:00Z"));
        numMap.put("3 h", Instant.parse("2017-03-01T03:00:00Z"));
        numMap.put("5 h", Instant.parse("2017-03-01T05:00:00Z"));
        numMap.put("6 h", Instant.parse("2017-03-01T06:00:00Z"));
        numMap.put("7 h", Instant.parse("2017-03-01T07:00:00Z"));
        numMap.put("24 h", Instant.parse("2017-03-02T00:00:00Z"));
        numMap.put("1 day, 1h", Instant.parse("2017-03-02T01:00:00Z"));
        numMap.put("1 day, 3h", Instant.parse("2017-03-02T03:00:00Z"));
        numMap.put("1 day, 6h", Instant.parse("2017-03-02T06:00:00Z"));
        numMap.put("1 day, 7h", Instant.parse("2017-03-02T07:00:00Z"));
        numMap.put("6 days", Instant.parse("2017-03-07T00:00:00Z"));
        numMap.put("6 days, 6h", Instant.parse("2017-03-07T06:00:00Z"));
        numMap.put("7 days", Instant.parse("2017-03-08T00:00:00Z"));
        numMap.put("1 week, 2days", Instant.parse("2017-03-10T00:00:00Z"));
        numMap.put("3 weeks", Instant.parse("2017-03-21T00:00:00Z"));
        return Collections.unmodifiableMap(numMap);
    }


    @Before
    public void setUp() {
        parkRechner = new ParkRechner();
    }

    @Given("^The parking lot is open$")
    public void parking_lot_is_open() throws Throwable {
        assertNotNull(parkRechner);
    }

    @When("^I park for (.*)$")
    public void park_x_min(String time) {
        parkPreis = parkRechner.parkeAufParkplatz(startTime, endTimes().get(time));
    }

    @When("^I park in the garage for (.*)$")
    public void park_x_min_garage(String time) {
        parkPreis = parkRechner.parkeInDerGarage(startTime, endTimes().get(time));
    }

    @Then("^I pay (\\d+) Euro$")
    public void the_preis_should_be(int result) throws Throwable {
        assertEquals(result, parkPreis);
    }

}
