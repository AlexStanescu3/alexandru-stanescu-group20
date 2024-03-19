package Testing_Assignement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DistanceCalculator  {

    public static double calculate(String expression) {
        // Regular expression to match numbers with optional decimal points and units
        Pattern pattern = Pattern.compile("(\\d*\\.?\\d+)\\s*(mm|cm|dm|m|km)\\s*([+-])");
        Matcher matcher = pattern.matcher(expression);

        double totalMm = 0;
        char operator = '+'; // Default operator is addition

        while (matcher.find()) {
            double value = Double.parseDouble(matcher.group(1));
            String unit = matcher.group(2);
            char nextOperator = matcher.group(3).charAt(0);

            // Convert value to mm
            double valueInMm = convertToMm(value, unit);

            // Perform addition or subtraction based on the operator
            if (operator == '+') {
                totalMm += valueInMm;
            } else if (operator == '-') {
                totalMm -= valueInMm;
            }

            operator = nextOperator; // Update the operator for the next iteration
        }

        // Handle the last number in the expression
        String[] parts = expression.split("[+-]");
        if (parts.length > 1) {
            String lastPart = parts[parts.length - 1].trim();
            String[] lastValueParts = lastPart.split("\\s+");
            double lastValue = Double.parseDouble(lastValueParts[0]);
            String lastUnit = lastValueParts.length > 1 ? lastValueParts[1] : ""; // Unit of the last value

            // Convert the last value to millimeters based on its unit
            lastValue = convertToMm(lastValue, lastUnit);

            totalMm = performLastOperation(totalMm, lastValue, operator);
        }

        return totalMm;
    }

    public static double convertToMm(double value, String unit) {
        switch (unit) {
            case "mm":
                return value;
            case "cm":
                return value * 10;
            case "dm":
                return value * 100;
            case "m":
                return value * 1000;
            case "km":
                return value * 1000000;
            default:
                throw new IllegalArgumentException("Unknown unit: " + unit);
        }
    }

    public static double performLastOperation(double totalMm, double lastValue, char operator) {
        if (operator == '+') {
            totalMm += lastValue;
        } else if (operator == '-') {
            totalMm -= lastValue;
        }
        return totalMm;
    }

    public static double convertToOutputFormat(double mm, String outputFormat) {
        switch (outputFormat) {
            case "mm":
                return mm;
            case "cm":
                return mm / 10;
            case "dm":
                return mm / 100;
            case "m":
                return mm / 1000;
            case "km":
                return mm / 1000000;
            default:
                throw new IllegalArgumentException("Unknown output format: " + outputFormat);
        }
    }
}




