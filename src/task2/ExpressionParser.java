package task2;

/**
 * A recursive parser for mathematical expressions that supports basic arithmetic operations,
 * floating-point numbers, and parentheses.
 * 
 * Supported operations:
 * - Addition (+)
 * - Subtraction (-)
 * - Multiplication (*)
 * - Division (/)
 * - Parentheses for grouping
 * 
 * The parser follows standard mathematical operator precedence:
 * 1. Parentheses
 * 2. Multiplication and Division (left to right)
 * 3. Addition and Subtraction (left to right)
 */
public class ExpressionParser {
    private String expression;
    private int position;

    public ExpressionParser(String expression) {
        // Remove all whitespace from the expression
        this.expression = expression.replaceAll("\\s+", "");
        this.position = 0;
    }

    public double evaluate() throws IllegalArgumentException {
        try {
            double result = parseExpression();
            if (position != expression.length()) {
                throw new IllegalArgumentException("Invalid expression: Unexpected characters at end");
            }
            return result;
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid expression: Unexpected end of input");
        }
    }

    private double parseExpression() {
        double left = parseTerm();

        while (position < expression.length()) {
            char operator = expression.charAt(position);
            if (operator != '+' && operator != '-') {
                break;
            }
            position++;
            double right = parseTerm();
            
            if (operator == '+') {
                left += right;
            } else {
                left -= right;
            }
        }
        return left;
    }

    private double parseTerm() {
        double left = parseFactor();

        while (position < expression.length()) {
            char operator = expression.charAt(position);
            if (operator != '*' && operator != '/') {
                break;
            }
            position++;
            double right = parseFactor();
            
            if (operator == '*') {
                left *= right;
            } else {
                if (right == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                left /= right;
            }
        }
        return left;
    }

    private double parseFactor() {
        if (position >= expression.length()) {
            throw new IllegalArgumentException("Unexpected end of expression");
        }
        
        char currentChar = expression.charAt(position);
        
        if (currentChar == '(') {
            position++;
            double result = parseExpression();
            if (position >= expression.length() || expression.charAt(position) != ')') {
                throw new IllegalArgumentException("Missing closing parenthesis");
            }
            position++;
            return result;
        }
        
        // Handle negative numbers in expressions like "-3 * -2"
        if (currentChar == '-' && (position == 0 || isOperator(expression.charAt(position - 1)))) {
            position++;
            return -parseFactor();
        }
        
        return parseNumber();
    }

    private double parseNumber() {
        StringBuilder numberStr = new StringBuilder();
        char currentChar = expression.charAt(position);
        
        // Parse digits and decimal point
        while (position < expression.length() && 
               (Character.isDigit(expression.charAt(position)) || 
                expression.charAt(position) == '.')) {
            numberStr.append(expression.charAt(position));
            position++;
        }
        
        if (numberStr.length() == 0) {
            throw new IllegalArgumentException("Invalid number format at position " + position);
        }
        
        try {
            return Double.parseDouble(numberStr.toString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + numberStr);
        }
    }

    // Helper method to check if a character is an operator
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}