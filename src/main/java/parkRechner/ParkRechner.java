package parkRechner;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Created by webermar on 30.05.2017.
 */
public class ParkRechner {

    public static final int PRICE_PER_HOUR = 2;

    public int parkeAufParkplatz(final Instant startDate, final Instant endDate){
        return parke(startDate, endDate, 60, 10);
    }

    public int parkeInDerGarage(final Instant startDate, final Instant endDate){
        return parke(startDate, endDate, 72, 12);
    }

    private int parke(Instant startDate, Instant endDate, int maxPriceWeek, int maxPriceDay) {
        final long fullTimeInDays = ChronoUnit.DAYS.between(startDate, endDate);
        final long weeks = fullTimeInDays/7;
        final long days = fullTimeInDays - weeks * 7;

        Instant newDate = endDate.minus(fullTimeInDays,ChronoUnit.DAYS);
        final long hours = ChronoUnit.HOURS.between(startDate, newDate);

        newDate = newDate.minus(hours,ChronoUnit.HOURS);
        final long minutes = ChronoUnit.MINUTES.between(startDate, newDate);

        long result;
        long priceWeeks = weeks * maxPriceWeek;
        long priceDays = days * maxPriceDay;
        long priceHours = calculatePriceHours(maxPriceDay, hours, minutes);

        if(priceDays + priceHours > maxPriceWeek){
            priceDays = maxPriceWeek;
            priceHours = 0;
        }
        result = priceWeeks + priceDays + priceHours;
        return (int) result;
    }

    private long calculatePriceHours(int maxPriceDay, long hours, long minutes) {
        long priceHours = hours * PRICE_PER_HOUR;
        if(minutes > 0){
            priceHours += PRICE_PER_HOUR;
        }
        if(priceHours > maxPriceDay){
            priceHours = maxPriceDay;
        }
        return priceHours;
    }
}
