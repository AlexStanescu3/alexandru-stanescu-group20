package IO_Enums_Annotations_Assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SkiBiathlonStandings {
    public static void main(String[] args) {

        List<Athlete> athletes = new ArrayList<Athlete>();


        File myFile = new File("C:" + File.separator +
                "Users" + File.separator +
                "user" + File.separator +
                "Desktop" + File.separator +
                "Java" + File.separator +
                "alexandru-stanescu-group20" + File.separator +
                "alexandru-stanescu-group20" + File.separator +
                "src" + File.separator +
                "main" + File.separator +
                "java" + File.separator +
                "IO_Enums_Annotations_Assignment" + File.separator +
                "SkiBiathlonStandings.csv" + File.separator);

        System.out.println("List of athletes imported from CSV file: ");


        try {
            BufferedReader br = new BufferedReader(new FileReader(myFile));
            br.readLine();
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Athlete athlete = new Athlete();
                athlete.setAthleteNumber(Integer.valueOf(values[0]));
                athlete.setAthleteName(values[1]);
                athlete.setCountryCode(CountryCode.valueOf(values[2]));
                athlete.setSkiTimeResult(values[3]);
                athlete.setShootingResults(new String[]{values[4], values[5], values[6]});
                athletes.add(athlete);

                System.out.println(athlete.toString());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Sort athletes based on final time
        Collections.sort(athletes);

        // Identify top three athletes
        Athlete winner = athletes.get(0);
        Athlete runnerUp = athletes.get(1);
        Athlete thirdPlace = athletes.get(2);

        System.out.println();
        System.out.println();

        // Print results
        System.out.println("Standing results: ");
        System.out.println();
        System.out.println("Winner - " + winner.getAthleteName() + " " + Athlete.calculateTotalTimeInMinutes(winner.getSkiTimeResult(), winner.getShootingResults()));
        System.out.println("Runner-up - " + runnerUp.getAthleteName() + " " + Athlete.calculateTotalTimeInMinutes(runnerUp.getSkiTimeResult(), runnerUp.getShootingResults()));
        System.out.println("Third Place - " + thirdPlace.getAthleteName() + " " + Athlete.calculateTotalTimeInMinutes(thirdPlace.getSkiTimeResult(), thirdPlace.getShootingResults()));

    }
}
