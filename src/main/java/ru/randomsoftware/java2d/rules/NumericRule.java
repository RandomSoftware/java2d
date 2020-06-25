package ru.randomsoftware.java2d.rules;

public class NumericRule implements Rule<Boolean> {

    private final boolean[] base;

    public NumericRule(int base) {
        if (base < 0 || base > 255) {
            throw new IllegalArgumentException("Base must be between 0 and 255");
        }
        this.base = intToBooleanArray(base);
    }

    @Override
    public Boolean calculate(Boolean a, Boolean b, Boolean c) {
        if (a && b && c) {
            return base[0];
        } else if (a && b) {
            return base[1];
        } else if (a && c) {
            return base[2];
        } else if (a) {
            return base[3];
        } else if (b && c) {
            return base[4];
        } else if (b) {
            return base[5];
        } else if (c) {
            return base[6];
        } else {
            return base[7];
        }
    }

    private static boolean[] intToBooleanArray(int number) {
        final boolean[] ret = new boolean[8];
        for (int i = 0; i < 8; i++) {
            ret[7 - i] = (1 << i & number) != 0;
        }
        return ret;
    }
}
