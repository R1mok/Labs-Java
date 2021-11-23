package ru.mephi.lab5;

import java.time.*;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class HomeWork2 {
    public static void main(String[] args) {
        ZoneId BOS = ZoneId.of("America/New_York");
        ZoneId SFO = ZoneId.of("America/Los_Angeles");
        ZoneId BLR = ZoneId.of("Asia/Calcutta");

        // Filight 123
        LocalDateTime flight123 = LocalDateTime.of(2014, Month.JUNE, 13, 22, 30);
        ZonedDateTime SFOFlight123 = ZonedDateTime.of(flight123, SFO);
        ZonedDateTime inBoston = SFOFlight123.withZoneSameInstant(BOS);
        System.out.println("What is the local time in Boston when the flight takes off? " + inBoston.toLocalDateTime());
        ZonedDateTime inSFO = SFOFlight123.plusMinutes(30).plusHours(5);
        ZonedDateTime inBostonArrives = inSFO.withZoneSameInstant(BOS);
        System.out.println("What is the local time at Boston Logan airport when the flight arrives? " + inBostonArrives.toLocalDateTime());
        System.out.println("What is the local time in San Francisco when the flight arrives? " + inSFO.toLocalDateTime());
        System.out.println("===============");

        // Flight 456
        LocalDateTime flight456Leave = LocalDateTime.of(2014, Month.JUNE, 28, 22, 30);
        ZonedDateTime flight456SFO = ZonedDateTime.of(flight456Leave, SFO);
        ZonedDateTime flight456SFOArrive = flight456SFO.plusHours(22);
        ZonedDateTime flight456BLRArrive = flight456SFOArrive.withZoneSameInstant(BLR);
        LocalDateTime meeting = LocalDateTime.of(2014, Month.JUNE, 30, 9, 0);
        ZonedDateTime meetingBLR = ZonedDateTime.of(meeting, BLR);
        System.out.println("Will the traveler make a meeting in Bangalore Monday at 9 AM local time?");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("hh:mm a");
        System.out.println("Flight 456 arrive in local time of BLR in " + flight456BLRArrive.format(formatter1) + " ");
        System.out.println("Meeting local time is " + meetingBLR.format(formatter1));
        if (flight456BLRArrive.compareTo(meetingBLR) > 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
        System.out.println("===============");
        System.out.println("Flight 456 arrive in local time of SFO in " + flight456SFOArrive.format(formatter1));
        if (flight456BLRArrive.getHour() > 22 && flight456SFOArrive.getHour() < 6){
            System.out.println("Not reasonable time");
        } else {
            System.out.println("Reasonable time");
        }

        System.out.println("===============");
        // flight 123
        LocalDateTime flight123Leave = LocalDateTime.of(2014, Month.NOVEMBER, 1, 22, 30);
        ZonedDateTime flight123LeaveSFO = ZonedDateTime.of(flight123Leave, SFO);
        ZonedDateTime flight123ArriveSFO = flight123LeaveSFO.plusHours(5).plusMinutes(30);
        ZonedDateTime flight123ArriveBOS = flight123ArriveSFO.withZoneSameInstant(BOS);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM hh:mm a");
        System.out.println("What day and time does the flight arrive in Boston? " + flight123ArriveBOS.format(formatter2));
        System.out.println("What happened? Some magic idk");
    }
}
