package ru.randomsoftware.java2d.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineGenerator implements LineGenerator<Boolean> {

    private static final Random RND = new Random();

    @Override
    public List<Boolean> generate(int size) {
        List<Boolean> row = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            boolean value = RND.nextBoolean();
            row.add(value);
        }
        return row;
    }
}
