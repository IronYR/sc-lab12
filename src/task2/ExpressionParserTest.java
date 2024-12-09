package task2;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExpressionParserTest {
    
    @Test
    public void testBasicOperations() {
        assertEquals(8.0, new ExpressionParser("3 + 5").evaluate(), 0.0001);
        assertEquals(10.0, new ExpressionParser("3 * 2 + 4").evaluate(), 0.0001);
        assertEquals(14.0, new ExpressionParser("2 + 3 * 4").evaluate(), 0.0001);
        assertEquals(2.5, new ExpressionParser("5 / 2").evaluate(), 0.0001);
    }

    @Test
    public void testParentheses() {
        assertEquals(20.0, new ExpressionParser("(2 + 3) * 4").evaluate(), 0.0001);
        assertEquals(14.0, new ExpressionParser("2 + (3 * 4)").evaluate(), 0.0001);
        assertEquals(25.0, new ExpressionParser("(5 * (2 + 3))").evaluate(), 0.0001);
    }

    @Test
    public void testFloatingPointNumbers() {
        assertEquals(5.5, new ExpressionParser("2.5 + 3").evaluate(), 0.0001);
        assertEquals(7.5, new ExpressionParser("2.5 * 3").evaluate(), 0.0001);
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(-1, new ExpressionParser("-1").evaluate(), 0.0001);
        assertEquals(-8, new ExpressionParser("-3 - 5").evaluate(), 0.0001);
        assertEquals(2.0, new ExpressionParser("-3 * -2 - 4").evaluate(), 0.0001);
    }

    @Test
    public void testInvalidExpressions() {
        assertThrows(IllegalArgumentException.class, () -> 
            new ExpressionParser("2 + ").evaluate());
        assertThrows(IllegalArgumentException.class, () -> 
            new ExpressionParser("2 + 3 *").evaluate());
        assertThrows(IllegalArgumentException.class, () -> 
            new ExpressionParser("(2 + 3").evaluate());
        assertThrows(IllegalArgumentException.class, () -> 
            new ExpressionParser("2 / 0").evaluate());
    }
}