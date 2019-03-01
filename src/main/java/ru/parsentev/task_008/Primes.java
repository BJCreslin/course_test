package ru.parsentev.task_008;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Primes {
    private static final Logger log = getLogger(Primes.class);

    private final int limit;
    private static List<Integer> integerList = new ArrayList<>();

    public Primes(final int limit) {
        this.limit = limit;
    }

    public List<Integer> calc() {
        int[] S = sieve(limit + 1);
        List<Integer> integers = new ArrayList<>();
        for (int i = 1; i < S.length; i++) {
            if (S[i] == 1) integers.add(i + 1);
        }
        return integers;

    }

    //Решето Эратосфена
    private int[] sieve(int n) {
        int[] S = new int[n];
        S[0] = 0; // 1 - не простое число
        // заполняем решето единицами
        for (int k = 2; k <= n; k++)
            S[k - 1] = 1;

        for (int k = 2; k * k <= n; k++) {
            // если k - простое (не вычеркнуто)
            if (S[k - 1] == 1) {
                // то вычеркнем кратные k
                for (int l = k * k; l <= n; l += k) {
                    S[l - 1] = 0;
                }
            }
        }
        return S;
    }
}
