package ru.parsentev.task_009;

import java.util.*;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class UniqueChars {
    private final String line;

    public UniqueChars(final String line) {
        this.line = line;
    }

    public int unique() {
        if (line.isEmpty()) {
            return 0;
        }
        System.out.println(line);
        Set<String> stringSet = new TreeSet<>();
        for (int i = 0; i < line.length(); i++) {
            System.out.println(line.substring(i, i + 1));
            stringSet.add(line.substring(i, i + 1));
        }
        return stringSet.size();
    }

}
