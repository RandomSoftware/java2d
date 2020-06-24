package ru.randomsoftware.java2d.rules;

public class Rule184 implements Rule<Boolean> {
    @Override
    public Boolean calculate(Boolean a, Boolean b, Boolean c) {
        return ((a ^ b) && a) || (b && c);
    }
}
