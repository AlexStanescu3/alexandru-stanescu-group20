package Final_exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogisticApplication {

    private static final int pricePerKm = 1;

    public static void main(String[] args) {

        List<Package> packages = new ArrayList<Package>();


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
                "Final_exam" + File.separator +
                "Logistics.csv.csv" + File.separator);


        try {
            BufferedReader br = new BufferedReader(new FileReader(myFile));
            br.readLine();
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Package aPackage = new Package();
                aPackage.setTargetLocation(String.valueOf(values[0]));
                aPackage.setTargetDistanceInKm(Integer.parseInt(values[1]));
                aPackage.setPackageValue(Integer.parseInt(values[2]));
                aPackage.setDeliveryDate(String.valueOf(values[3]));
                packages.add(aPackage);

                System.out.println(aPackage.toString());
                System.out.println();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

//I don't have time anymore