package ru.randomsoftware.java2d.rules;

public class Rule161 implements Rule<Boolean> {
    @Override
    public Boolean calculate(Boolean a, Boolean b, Boolean c) {
        return (a && c) | !(a || b || c);
    }
}
