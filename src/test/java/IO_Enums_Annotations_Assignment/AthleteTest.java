package IO_Enums_Annotations_Assignment;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {

    @Test
    void convertSkiTimeInSeconds_stringSpecified_stringConverted() {


        assertEquals(160, Athlete.convertSkiTimeInSeconds("2:40"));

    }

    @Test
    void countCharOccurrencesInString() {
        assertEquals(3, Athlete.countCharOccurrencesInString("xooxox"));
    }

    @Test
    void countCharOccurrencesInArrayOfStrings() {
        assertEquals(7, Athlete.countCharOccurrencesInArrayOfStrings(new String[]{"xxoox", "xooxo", "xxxoo"}));
    }

    @Test
    void calculateTotalTimeResultsInSeconds() {
        assertEquals(180, Athlete.calculateTotalTimeResultsInSeconds("2:10", new String[]{"xxoox", "xooxo", "xxxxx"}));
    }

    @Test
    void calculateTotalTimeInMinutes() {
        assertEquals("3:00", Athlete.calculateTotalTimeInMinutes("2:10", new String[]{"xxoox", "xooxo", "xxxxx"}));
    }

    @Test
    void compareTo() {
        Athlete athlete1 = new Athlete(1, "Jude Bellingham", CountryCode.UK, "2:40", new String[]{"xxoox", "xooxo", "xxxxo"});
        Athlete athlete2 = new Athlete(14, "Marek Hamsik", CountryCode.SK, "3:40", new String[]{"xxxxx", "xxxxo", "xxxxo"});

        assertEquals(-1, athlete1.compareTo(athlete2));

    }

}