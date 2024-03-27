package IO_Enums_Annotations_Assignment;

import java.util.Arrays;

public class Athlete implements Comparable<Athlete> {
    private int athleteNumber;
    private String athleteName;
    private CountryCode countryCode;
    private String skiTimeResult;
    private String[] shootingResults;

    public Athlete() {
    }

    public Athlete(int athleteNumber, String athleteName, CountryCode countryCode, String skiTimeResult, String[] shootingResults) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.shootingResults = shootingResults;
    }


    public int getAthleteNumber() {
        return athleteNumber;
    }

    public void setAthleteNumber(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public void setSkiTimeResult(String skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public String[] getShootingResults() {
        return shootingResults;
    }

    public void setShootingResults(String[] shootingResults) {
        this.shootingResults = shootingResults;
    }


    public static int convertSkiTimeInSeconds(String timeString) {
        String[] parts = timeString.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    public static int countCharOccurrencesInString(String str) {
        int count = 0;
        char targetChar = 'o';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == targetChar) {
                count++;
            }
        }
        return count;
    }

    public static int countCharOccurrencesInArrayOfStrings(String[] strings) {
        int totalCount = 0;
        char targetChar = 'o';
        for (String str : strings) {
            totalCount += countCharOccurrencesInString(str);
        }
        return totalCount;
    }

    public static int calculateTotalTimeResultsInSeconds(String timeString, String[] strings) {
        return convertSkiTimeInSeconds(timeString) + countCharOccurrencesInArrayOfStrings(strings) * 10;
    }

    public static String calculateTotalTimeInMinutes(String timeString, String[] strings) {
        int totalSeconds = calculateTotalTimeResultsInSeconds(timeString, strings);
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }



    @Override
    public String toString() {
        return "Athlete{" +
                "athleteNumber=" + athleteNumber +
                ", athleteName='" + athleteName + '\'' +
                ", countryCode=" + countryCode +
                ", skiTimeResult='" + skiTimeResult + '\'' +
                ", shootingResults=" + Arrays.toString(shootingResults) +
                '}';
    }

    @Override
    public int compareTo(Athlete o) {
        return Integer.compare(calculateTotalTimeResultsInSeconds(this.skiTimeResult,this.shootingResults), calculateTotalTimeResultsInSeconds(o.skiTimeResult,o.shootingResults));
    }


}
