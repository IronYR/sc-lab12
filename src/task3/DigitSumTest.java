package task3;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Test class for DigitSum functionality.
 * Tests various scenarios including edge cases and typical use cases.
 */
public class DigitSumTest {

    @Test
    public void testZero() {
        assertEquals(0, DigitSum.sumOfDigits(0), 
            0.0001);
    }

    @Test
    public void testSingleDigit() {
        assertEquals(5, DigitSum.sumOfDigits(5), 
        		0.0001);
        assertEquals(9, DigitSum.sumOfDigits(9), 
        		0.0001);
    }

    @Test
    public void testMultipleDigits() {
        assertEquals(6, DigitSum.sumOfDigits(123), 
        		0.0001);
        assertEquals(15, DigitSum.sumOfDigits(12345), 
        		0.0001);
        assertEquals(54, DigitSum.sumOfDigits(999999), 
        		0.0001);
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(6, DigitSum.sumOfDigits(-123), 
        		0.0001);
        assertEquals(15, DigitSum.sumOfDigits(-12345), 
        		0.0001);
    }

    @Test
    public void testLargeNumber() {
        assertEquals(46, DigitSum.sumOfDigits(Integer.MAX_VALUE), 
        		0.0001);

    }
}