package ru.parsentev.task_003;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_002.Point;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Triangle {
    private static final Logger log = getLogger(Triangle.class);

    protected final Point first;
    protected final Point second;
    protected final Point third;

    public Triangle(final Point first, final Point second, final Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    private boolean isInline(Point p1, Point p2, Point p3) {
        if ((p1.distanceTo(p2) + p2.distanceTo(p3)) == p1.distanceTo(p3)) return true;
        if ((p2.distanceTo(p3) + p3.distanceTo(p1)) == p2.distanceTo(p1)) return true;
        if ((p3.distanceTo(p1) + p1.distanceTo(p2)) == p3.distanceTo(p2)) return true;
        return false;
    }

    public boolean exists() {
        if ((first == null) || (second == null) || (third == null)) return false;
        if (isInline(first, second, third)) {
            return false;
        }
        return true;
    }

    public double area() {
        if (!exists()) throw new IllegalStateException();

        double a = first.distanceTo(second);
        double b = second.distanceTo(third);
        double c = third.distanceTo(first);
        if ((a == 0) || (b == 0) || (c == 0)) return 0;
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }
}
