package ru.randomsoftware.java2d.generators;

import java.util.List;

public interface LineGenerator<T> {

    public List<T> generate(int size);

}
