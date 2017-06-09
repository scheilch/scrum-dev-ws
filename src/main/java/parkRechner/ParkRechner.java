package parkRechner;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Created by webermar on 30.05.2017.
 */
public class ParkRechner {

    private static final int PREIS_PRO_STUNDE = 2;

    public int parke(final Instant startDate, final Instant endDate){
        final long fullTimeInDays = ChronoUnit.DAYS.between(startDate, endDate);
        final long weeks = fullTimeInDays/7;
        final long days = fullTimeInDays - weeks * 7;

        Instant newDate = endDate.minus(fullTimeInDays,ChronoUnit.DAYS);
        final long hours = ChronoUnit.HOURS.between(startDate, newDate);

        newDate = newDate.minus(hours,ChronoUnit.HOURS);
        final long minutes = ChronoUnit.MINUTES.between(startDate, newDate);

        int result = PREIS_PRO_STUNDE;
        if (hours == 0) {
            result = PREIS_PRO_STUNDE;
        } else if ((hours <= 5)&&(hours > 0)) {
            result = berechnePreisFuerStunden((int) hours);
        } else {
            result = 10;
        }

        return result;
    }

    private int berechnePreisFuerStunden(int hours) {

        int preis = 0;

        if (hours == 0) {
            preis = PREIS_PRO_STUNDE;
        } else {
            preis = hours * PREIS_PRO_STUNDE;
        }
        return preis;
    }
}
