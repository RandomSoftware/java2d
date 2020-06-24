package ru.randomsoftware.java2d.rules;

public class Rule184 implements Rule {
    @Override
    public boolean calculate(boolean a, boolean b, boolean c) {
        return ((a ^ b) && a) || (b && c);
    }
}
