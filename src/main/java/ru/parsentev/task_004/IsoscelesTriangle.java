package ru.parsentev.task_004;

import org.slf4j.Logger;
import ru.parsentev.task_002.Point;
import ru.parsentev.task_003.Triangle;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class IsoscelesTriangle extends Triangle {
    private static final Logger log = getLogger(IsoscelesTriangle.class);

    public IsoscelesTriangle(Point first, Point second, Point third) {
        super(first, second, third);
    }

    @Override
    public boolean exists() {
        if (!super.exists()) return false;
        double a = first.distanceTo(second);
        double b = second.distanceTo(third);
        double c = third.distanceTo(first);
        if ((a == b) || (b == c) || (c == a)) {
            return true;
        }
        return false;
    }
}
