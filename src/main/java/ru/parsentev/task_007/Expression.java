package ru.parsentev.task_007;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Expression {
    private static final Logger log = getLogger(Expression.class);

    private final String expr;

    private double a;
    private double b;
    private String operation;

    public Expression(final String expr) {
        this.expr = expr;
        String exprTemp = expr;
        Pattern pattern = Pattern.compile("(^[-+]?\\d+\\.*\\d*([+\\-*/]|(exp)){1}[-+]?\\d+\\.*\\d*$)");
        Matcher matcher = pattern.matcher(exprTemp);
        if (!matcher.find()) {
            throw new java.lang.IllegalStateException();

        }

        //Смотрим со знаком ли первое число
        String[] arrayForSplit = exprTemp.split("([+\\-/*]|(exp))");

        List<Double> doubleList = Arrays.stream(arrayForSplit).filter(x -> !x.isEmpty()).map(x -> Double.parseDouble(x)).
                collect(Collectors.toList());

        //елси начинается с минуса, то умножаем первый операнд на -1
        if (exprTemp.startsWith("-")) {
            doubleList.set(0, (-1) * doubleList.get(0));
            exprTemp = exprTemp.substring(1);
        }

        //Смотрим со знаком ли второе число
        Pattern patternSecondZnak = Pattern.compile("(([+\\-*/]|(exp)){1}-)");
        Matcher matcherSecondZnak = patternSecondZnak.matcher(exprTemp);
        if (matcherSecondZnak.find()) {
            if (matcherSecondZnak.group().endsWith("-")) {
                doubleList.set(1, (-1) * doubleList.get(1));
            }
            exprTemp = exprTemp.replaceFirst("-", "");

        }

        Pattern patternOperator = Pattern.compile("([+\\-*/]|(exp))");
        Matcher matcheroperator = patternOperator.matcher(exprTemp);
        matcheroperator.find();
        operation = matcheroperator.group();
        a = doubleList.get(0);
        b = doubleList.get(1);

    }

    public static void main(String[] args) {
        Expression expression = new Expression("2.1+2.1");
        System.out.println(expression.a + " " + expression.operation + " " + expression.b + " ");
        System.out.println(expression.calc());
    }

    public double calc() {
        double result;
        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "exp":
                result = Math.pow(a, b);
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return result;

    }
}
