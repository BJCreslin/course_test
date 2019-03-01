package ru.parsentev.task_005;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_002.Point;
import ru.parsentev.task_003.Triangle;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class RightTriangle extends Triangle {
    private static final Logger log = getLogger(RightTriangle.class);

    public RightTriangle(Point first, Point second, Point third) {
        super(first, second, third);
    }

    @Override
    public boolean exists() {

        if (!super.exists()) {
            return false;
        }
        double a = first.distanceTo(second);
        double b = second.distanceTo(third);
        double c = third.distanceTo(first);
        System.out.println(a * a + " " + b * b + " " + c * c);
        if ((Math.abs(a * a + b * b - c * c) < 0.000001) ||
                (Math.abs(a * a + c * c - b * b) < 0.000001) ||
                (Math.abs(c * c + b * b - a * a) < 0.000001)) {
            return true;
        }
        return false;
    }
}
