package org.plopl.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() { calculator = new Calculator(); }

    @Test
    public void itShouldAdd() {
        // When
        int result = calculator.add(2, 3);

        // Then
        assertEquals(5, result);
    }

    @Test
    public void itShouldSubtract() {
        // When
        int result = calculator.subtract(-2, 3);

        // Then
        assertEquals(-5, result);
    }

    @Test
    public void itShouldMultiply() {
        // When
        int result = calculator.multiply(-5, -2);

        // Then
        assertEquals(10, result);
    }

    @Test
    public void itShouldDivide() {
        // When
        float result = calculator.divide(12, 3);

        // Then
        assertEquals(4, result);
    }

    @Test
    public void itShouldThrowDivisionError() {
        // Then
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(3, 0) );
    }
}