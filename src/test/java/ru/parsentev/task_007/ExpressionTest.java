package ru.parsentev.task_007;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
//@Ignore
public class ExpressionTest {
    @Test
    public void calc() {
        Expression expr = new Expression("2+2");
        double result = expr.calc();
        assertThat(result, is(4d));

        expr = new Expression("7.23+2.45");
        result = expr.calc();
        assertEquals(result, 9.68, 0.0001);

        expr = new Expression("0+2");
        result = expr.calc();
        assertEquals(result, 2, 0.0001);
    }

    @Test(expected = IllegalStateException.class)
    public void noValid() {
        new Expression("2+").calc();
    }

    @Test
    public void calcExponentiation() {
        Expression expr = new Expression("2exp2");
        double result = expr.calc();
        assertEquals(result, 4, 0.0001);

        expr = new Expression("5exp2");
        result = expr.calc();
        assertEquals(result, 25, 0.0001);

        expr = new Expression("7exp3");
        result = expr.calc();
        assertEquals(result, 343, 0.0001);

    }


    @Test
    public void calcSubstruction() {
        Expression expr = new Expression("2-3");
        double result = expr.calc();
        assertThat(result, is(-1d));

        expr = new Expression("2-2");
        result = expr.calc();
        assertEquals(result, 0, 0.0001);

        expr = new Expression("7-2");
        result = expr.calc();
        assertEquals(result, 5, 0.0001);

        expr = new Expression("7.5-2.3");
        result = expr.calc();
        assertEquals(result, 5.2, 0.0001);

    }

    @Test
    public void calcMultiplication() {
        Expression expr = new Expression("2*3");
        double result = expr.calc();
        assertThat(result, is(6d));

        expr = new Expression("2*2.1");
        result = expr.calc();
        assertEquals(result, 4.2, 0.0001);

        expr = new Expression("2.5*4");
        result = expr.calc();
        assertEquals(result, 10, 0.0001);
    }

    @Test
    public void calcDivision() {
        Expression expr = new Expression("8/4");
        double result = expr.calc();
        assertEquals(result, 2d, 0.0001);

        expr = new Expression("8.4/2.1");
        result = expr.calc();
        assertEquals(result, 4, 0.0001);

        expr = new Expression("15.6/3");
        result = expr.calc();
        assertEquals(result, 5.2, 0.0001);
    }

    @Test
    public void calcNegativeNumbersAdd() {
        Expression expr = new Expression("-2.1+2.1");
        double result = expr.calc();
        assertEquals(result, 0, 0.0001);

        expr = new Expression("-2+-2");
        result = expr.calc();
        assertEquals(result, -4, 0.0001);

        expr = new Expression("2+-2");
        result = expr.calc();
        assertEquals(result, 0, 0.0001);
    }

    @Test
    public void calcNegativeNumbersSubstraction() {
        Expression expr = new Expression("-2.1-2.1");
        double result = expr.calc();
        assertEquals(result, -4.2, 0.0001);

        expr = new Expression("-2--2");
        result = expr.calc();
        assertEquals(result, 0, 0.0001);

        expr = new Expression("2--2");
        result = expr.calc();
        assertEquals(result, 4, 0.0001);
    }

    @Test
    public void calcNegativeNumbersMultiplication() {
        Expression expr = new Expression("-2.1*2");
        double result = expr.calc();
        assertEquals(result, -4.2, 0.0001);

        expr = new Expression("-2*-2");
        result = expr.calc();
        assertEquals(result, 4, 0.0001);

        expr = new Expression("2*-2");
        result = expr.calc();
        assertEquals(result, -4, 0.0001);
    }

    @Test
    public void calcNegativeNumbersDivision() {
        Expression expr = new Expression("-2.1/2");
        double result = expr.calc();
        assertEquals(result, -1.05, 0.0001);

        expr = new Expression("-2/-2");
        result = expr.calc();
        assertEquals(result, 1, 0.0001);

        expr = new Expression("400/-2");
        result = expr.calc();
        assertEquals(result, -200, 0.0001);
    }


}