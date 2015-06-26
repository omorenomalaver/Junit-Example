import javaconvertorextension.Convertor;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CheckExpectValues { 

    // define a conversor object
    Convertor conversor = new Convertor();
    // this parameter is used to define round precision 
    private static double deltaValue = 1e-15;

    /**
     * this function goes to evaluate centimeter conversion to inches
     */
    @Test
    public void evaluateExpectedEqualsCmInches() {
        double expected = 11.81;
        double actual = conversor.calculate(0, 30);
        System.out.println(" CM to Inches Expected: " + expected + " Actual: " + actual);
        assertEquals(expected, actual, deltaValue);
    }
    
    /**
     * this function goes to evaluate meters conversion to feet
     */
    @Test
    public void evaluateExpectedEqualsMeterFeet() {
        double expected = 98.42;
        double actual = conversor.calculate(1, 30);
        System.out.println(" Meter to Feet Expected: " + expected + " Actual: " + actual);
        assertEquals(expected, actual, deltaValue);
    }
    
    /**
     * this function goes to evaluate celsius conversion to Fahrenheit
     */
    @Test
    public void evaluateExpectedEqualsCelsiusFahrenheit() {
        double expected = 86;
        double actual = conversor.calculate(2, 30);
        System.out.println(" C to F Expected: " + expected + " Actual: " + actual);
        assertEquals(expected, actual, deltaValue);
    }

    /**
     * this function goes to evaluate centimeters conversion to feet
     */
    @Test
    public void evaluateExpectedEqualsCMFeet() {
        double expected = 0.98;
        double actual = conversor.calculate(3, 30);
        System.out.println(" CM to FEET Expected: " + expected + " Actual: " + actual);
        assertEquals(expected, actual, deltaValue);
    }

    /**
     * this function goes to evaluate miles conversion to kilometers
     */
    @Test
    public void evaluateExpectedEqualsMilesKilometres() {
        double expected = 482.80;
        double actual = conversor.calculate(4, 300);
        System.out.println(" MI KM Expected: " + expected + " Actual: " + actual);
        assertEquals(expected, actual, deltaValue);
    }
}
