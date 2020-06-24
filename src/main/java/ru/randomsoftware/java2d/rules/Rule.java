package ru.randomsoftware.java2d.rules;

public interface Rule<T> {

    T calculate(T a, T b, T c);

}
