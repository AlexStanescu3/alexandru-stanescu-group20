package Concurrency_Assignment;

import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate {
    private Queue<TicketType> ticketQueue;

    public FestivalGate() {
        ticketQueue = new LinkedList<>();
    }

    public synchronized void addTicket(TicketType ticketType) {
        ticketQueue.add(ticketType);
    }

    // Get ticket queue
    public synchronized Queue<TicketType> getTicketQueue() {
        return ticketQueue;
    }

    @Override
    public String toString() {
        return "FestivalGate{" +
                "ticketQueue=" + ticketQueue +
                '}';
    }
}
