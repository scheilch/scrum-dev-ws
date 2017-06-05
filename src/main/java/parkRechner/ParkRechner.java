package parkRechner;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Created by webermar on 30.05.2017.
 */
public class ParkRechner {

    public int parke(final Instant startDate, final Instant endDate){
        final long fullTimeInDays = ChronoUnit.DAYS.between(startDate, endDate);
        final long weeks = fullTimeInDays/7;
        final long days = fullTimeInDays - weeks * 7;

        Instant newDate = endDate.minus(fullTimeInDays,ChronoUnit.DAYS);
        final long hours = ChronoUnit.HOURS.between(startDate, newDate);

        newDate = newDate.minus(hours,ChronoUnit.HOURS);
        final long minutes = ChronoUnit.MINUTES.between(startDate, newDate);

        int result = 2;

        return result;
    }
}
