package Concurrency_Assignment;

import java.util.Random;

public class FestivalAttendeeThread extends Thread {

    TicketType ticketType;
    FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        gate.addTicket(ticketType);
        System.out.println(Thread.currentThread().getName() + ", Attendee entered to the festival with ticket type: " + this.ticketType);

    }
}
