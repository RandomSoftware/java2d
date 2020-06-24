package ru.randomsoftware.java2d.rules;

public class EqualityRule implements Rule<Boolean> {
    @Override
    public Boolean calculate(Boolean a, Boolean b, Boolean c) {
        return b;
    }
}
