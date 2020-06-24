package ru.randomsoftware.java2d.generators;

import java.util.ArrayList;
import java.util.List;

public class MiddlePointLineGenerator implements LineGenerator<Boolean> {
    @Override
    public List<Boolean> generate(int size) {
        List<Boolean> row = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            row.add(i == size / 2);
        }
        return row;
    }
}
