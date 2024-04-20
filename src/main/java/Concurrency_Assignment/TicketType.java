package Concurrency_Assignment;

import java.util.Random;

public enum TicketType {
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    private static final Random PRNG = new Random();

    public static TicketType randomTicketType()  {
        TicketType[] ticketTypes = values();
        return ticketTypes[PRNG.nextInt(ticketTypes.length)];
    }

}
