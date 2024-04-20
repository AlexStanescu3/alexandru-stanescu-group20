package Concurrency_Assignment;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();

        for (int i = 0; i <= 100; i++) {
            TicketType ticketType = TicketType.randomTicketType();
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);
            attendee.start();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Run simulation for 30 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop statistics thread
        statisticsThread.stopThread();


    }


}

