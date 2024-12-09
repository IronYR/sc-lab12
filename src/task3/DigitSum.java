package task3;
/**
 * A utility class that provides methods to calculate the sum of digits in a number recursively.
 * 
 * Time Complexity: O(log n) where n is the input number
 * Space Complexity: O(log n) due to recursive call stack
 * 
 * The algorithm works by repeatedly extracting the last digit using modulo
 * and recursively processing the remaining digits using integer division.
 */
public class DigitSum {
    
    /**
     * Calculates the sum of digits for any integer (positive or negative).
     * For negative numbers, the absolute value is used.
     *
     * @param number the input number
     * @return the sum of all digits in the number
     * @example sumOfDigits(123) returns 6 (1 + 2 + 3)
     * @example sumOfDigits(-123) returns 6 (1 + 2 + 3)
     */
    public static int sumOfDigits(int number) {
        // Convert negative numbers to positive
        number = Math.abs(number);
        return sumOfDigitsRecursive(number);
    }

    /**
     * Internal recursive helper method to calculate the sum of digits.
     *
     * @param number the non-negative number to process
     * @return the sum of all digits
     */
    private static int sumOfDigitsRecursive(int number) {
        // Base case: when number becomes 0
        if (number == 0) {
            return 0;
        }
        
        // Get the last digit using modulo and add it to the recursive sum
        // of the remaining digits
        return (number % 10) + sumOfDigitsRecursive(number / 10);
    }
}