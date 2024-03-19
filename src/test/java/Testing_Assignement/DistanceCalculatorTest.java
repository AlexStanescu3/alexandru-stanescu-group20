package Testing_Assignement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    @Test
    public void whenAddingCmAndMm_thenSuccess() {
        assertEquals(200.0, DistanceCalculator.calculate("10 cm + 100 mm"), 0.001);
    }

    @Test
    public void whenSubtractingMmFromDm_thenSuccess() {
        assertEquals(1000.0, DistanceCalculator.calculate("20 dm - 1000 mm"), 0.001);
    }

    @Test
    public void whenMixingUnitsInComplexExpression_thenSuccess() {
        assertEquals(901000.0, DistanceCalculator.calculate("1 km - 100 m + 100 cm"), 0.001);
    }

    @Test
    public void whenAddingDecimals_thenSuccess() {
        assertEquals(990.0, DistanceCalculator.calculate("1.1 m + 0.02 m - 1.3 dm"), 0.001);
    }

    @Test
    public void whenInputHasUnknownUnit_thenIllegalArgumentException() {
        try{
            DistanceCalculator.convertToMm(10 , "inches");
        } catch (Exception e){
            assertEquals("Unknown unit: inches", e.getMessage());
        }
    }

    @Test
    public void whenExpectingNegativeResult_thenCorrectlyCalculated() {
        assertEquals(-2196900.0, DistanceCalculator.calculate("10 cm + 3 m - 2.2 km"), 0.001);
    }

    @Test
    public void whenStringExpressionIsNotAsPattern_thenThrowException() {
        DistanceCalculator.calculate("10mm + 1cm - 3 dm");
    }

    @Test
    public void whenInputHasUnsupportedOperator_thenThrowException() {
        DistanceCalculator.calculate("80 km * 1 m - 7 mm");
    }

    @Test
    void convertToOutputFormat_cmOutput_convertToCm() {
        assertEquals(10, DistanceCalculator.convertToOutputFormat(100.00, "cm") );
    }

    @Test
    void convertToOutputFormat_mmOutput_convertToMm() {
        assertEquals(100, DistanceCalculator.convertToOutputFormat(100.00, "mm") );
    }

    @Test
    void convertToOutputFormat_dmOutput_convertToDm() {
        assertEquals(1, DistanceCalculator.convertToOutputFormat(100.00, "dm") );
    }

    @Test
    void convertToOutputFormat_mOutput_convertToM() {
        assertEquals(1, DistanceCalculator.convertToOutputFormat(1000.00, "m") );
    }

    @Test
    void convertToOutputFormat_kmOutput_convertToKm() {
        assertEquals(1, DistanceCalculator.convertToOutputFormat(1000000.00, "km") );
    }

    @Test
    public void whenOutputHasUnknownUnit_thenIllegalArgumentException() {
        try{
            DistanceCalculator.convertToOutputFormat(100 , "inches");
        } catch (Exception e){
            assertEquals("Unknown output format: inches", e.getMessage());
        }
    }
}