package ru.mephi.lab5;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;


public class HomeWork1 {
    public static void main(String[] args) {
        // Lincoln
        LocalDate LincolnsBdy = LocalDate.of(1809, 2, 12);
        LocalDate LincolnsDdy = LocalDate.of(1855, 4, 15);
        System.out.println("Lincoln died at " + ChronoUnit.YEARS.between(LincolnsBdy, LincolnsDdy));
        System.out.println("Lincoln lived " + ChronoUnit.DAYS.between(LincolnsBdy, LincolnsDdy) + " days");

        System.out.println("=================");
        // Cumberbatch
        LocalDate CumberbatchBdy = LocalDate.of(1976, Month.JULY, 19);
        System.out.println("Is Cumberbatch born in a leap year? " + CumberbatchBdy.isLeapYear());
        System.out.println("How many days in the year he was born? " + CumberbatchBdy.lengthOfYear());
        System.out.println("How many decades old is he? " + ChronoUnit.DECADES.between(CumberbatchBdy, LocalDate.now()));
        System.out.println("What was the day of the week on his 21st birthday? " + CumberbatchBdy.plusYears(21).getDayOfWeek());

        System.out.println("=================");
        // Train
        LocalTime trainDeparts = LocalTime.of(13, 45);
        ZonedDateTime trainDepartsBoston = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(), trainDeparts), ZoneId.of("America/New_York"));
        LocalTime trainArrives = LocalTime.of(19, 25);
        ZonedDateTime trainsArrivesNewYork = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(), trainArrives), ZoneId.of("America/New_York"));
        System.out.println("How many minutes long is the train ride? " + ChronoUnit.MINUTES.between(trainDepartsBoston, trainsArrivesNewYork));
        ZonedDateTime trainsArrivesNewYorkDelay = trainsArrivesNewYork.plusHours(1).plusMinutes(19);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("hh:mm a");
        System.out.println("If the train was delayed 1 hour 19 minutes, what is the actual arrival time? " + trainsArrivesNewYorkDelay.format(formatter1));

        System.out.println("=================");
        // Flight
        LocalDateTime flightDepart = LocalDateTime.of(LocalDate.now().getYear(), Month.MARCH, 24, 21, 15);
        ZonedDateTime flightToBoston = ZonedDateTime.of(flightDepart, ZoneId.of("America/New_York"));
        OffsetDateTime offsetToFlight = flightToBoston.toOffsetDateTime();
        ZonedDateTime flightInMiami = offsetToFlight.atZoneSameInstant(ZoneId.of("America/New_York"));
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM hh:mm a");
        flightInMiami = flightInMiami.plusHours(4).plusMinutes(15);
        System.out.println("When does it arrive in Miami? " + flightInMiami.format(formatter2));
        System.out.println("When does it arrive if the flight is delays 4 hours 27 minutes? " + flightInMiami.plusHours(4).plusMinutes(27).format(formatter2));

        System.out.println("=================");
        // School semester
        MonthDay.of(Month.SEPTEMBER, 7);
        int whichYear = 2021; // укажите год, в котором нужно посмотреть начало и длительность семестра
        LocalDate startSem = LocalDate.of(whichYear, Month.SEPTEMBER, 7);
        TemporalAdjuster startSemester = temporal -> {
            while (temporal.get(ChronoField.DAY_OF_WEEK) != 2) {
                temporal = temporal.plus(Period.ofDays(1));
            }
            return temporal;
        };
        LocalDate startOfSem = (LocalDate) startSemester.adjustInto(startSem);
        System.out.println(startOfSem);
        TemporalAdjuster daysInSemester = temporal -> {
            int days = 0;
            LocalDate vacation = LocalDate.of(startOfSem.getYear() + 1, Month.JUNE, 25);
            while (!temporal.equals(vacation)) {
                if ((temporal.get(ChronoField.MONTH_OF_YEAR) == 12 || temporal.get(ChronoField.MONTH_OF_YEAR) == 3) && temporal.get(ChronoField.DAY_OF_MONTH) <= 14){
                    temporal = temporal.plus(Period.ofWeeks(2));
                }
                if (temporal.get(ChronoField.DAY_OF_WEEK) >= 1 && temporal.get(ChronoField.DAY_OF_WEEK) <= 5) {
                    days += 1;
                }
                temporal = temporal.plus(Period.ofDays(1));
            }
            System.out.println("Students study " + days + " days in this year");
            return temporal;
        };
        daysInSemester.adjustInto(startOfSem);
        // meeting
        System.out.println("=================");

    }

}
