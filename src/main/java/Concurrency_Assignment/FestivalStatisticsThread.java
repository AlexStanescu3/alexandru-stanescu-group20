package Concurrency_Assignment;

import java.util.Queue;

public class FestivalStatisticsThread extends Thread {
    private FestivalGate gate;
    private boolean running;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
        this.running = true;
    }

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Queue<TicketType> ticketQueue = gate.getTicketQueue();
            int totalAttendees = ticketQueue.size();
            int fullCount = 0, fullVIPCount = 0, freePassCount = 0, oneDayCount = 0, oneDayVIPCount = 0;

            for (TicketType ticket : ticketQueue) {
                switch (ticket) {
                    case FULL:
                        fullCount++;
                        break;
                    case FULL_VIP:
                        fullVIPCount++;
                        break;
                    case FREE_PASS:
                        freePassCount++;
                        break;
                    case ONE_DAY:
                        oneDayCount++;
                        break;
                    case ONE_DAY_VIP:
                        oneDayVIPCount++;
                        break;
                }
            }


            System.out.println(totalAttendees + " people entered");
            System.out.println(fullCount + " have full tickets");
            System.out.println(fullVIPCount + " have full VIP passes");
            System.out.println(freePassCount + " have free passes");
            System.out.println(oneDayCount + " have one-day passes");
            System.out.println(oneDayVIPCount + " have one-day VIP passes");
        }
    }
}
