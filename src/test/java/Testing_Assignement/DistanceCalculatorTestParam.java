package Testing_Assignement;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)

public class DistanceCalculatorTestParam {

    private static Object[] distanceExpressions() {
        return new Object[] {
               new Object[]{"1 m + 10 cm + 1 mm", 1101.00},
               new Object[]{"1 dm - 10 cm + 1 mm", 1.00},
               new Object[]{"50 cm + 100 cm - 15 dm", 0.00},
        };
    }


    @Test
    @Parameters(method = "distanceExpressions")
    public void distanceCalculatorCalculate(String expression, double expectedResult) {
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        distanceCalculator.calculate(expression);
        assertEquals(expectedResult,distanceCalculator.calculate(expression),0.001);
    }
}
