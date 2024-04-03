package com.examples.sencha.healpers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateHelper {
    public static long getDaysDifferent(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        return Math.abs(ChronoUnit.DAYS.between(currentDate, date));
    }
}
