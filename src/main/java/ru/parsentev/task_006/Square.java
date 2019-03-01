package ru.parsentev.task_006;

import javafx.collections.transformation.SortedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_002.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Square {
    private static final Logger log = getLogger(Square.class);

    private final Point first;
    private final Point second;
    private final Point third;
    private final Point fourth;

    public Square(final Point first, final Point second, final Point third, final Point fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public boolean exists() {
        List<Double> doubleSet = new ArrayList<>();
        doubleSet.add(first.distanceTo(second));
        doubleSet.add(first.distanceTo(third));
        doubleSet.add(first.distanceTo(fourth));
        doubleSet.add(second.distanceTo(third));
        doubleSet.add(second.distanceTo(fourth));
        doubleSet.add(third.distanceTo(fourth));
        doubleSet.sort(Double::compareTo);
        doubleSet.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        if (doubleSet.contains(0d)) return false;
        Double[] doubles = doubleSet.toArray(new Double[doubleSet.size()]);

        if ((Math.abs((doubles[0] - doubles[1])) > 0.0001) ||
                (Math.abs((doubles[2] - doubles[3])) > 0.0001) ||
                (Math.abs((doubles[4] - doubles[5])) > 0.0001)) {
            return false;
        }
        return true;
    }
}
