package ru.randomsoftware.java2d.simulations;

import ru.randomsoftware.java2d.generators.LineGenerator;
import ru.randomsoftware.java2d.rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class LineCellularAutomate {

    private final List<Boolean> initialRow;
    private final Rule<Boolean> rule;

    public LineCellularAutomate(LineGenerator<Boolean> generator, Rule<Boolean> rule, int size) {
        this.initialRow = generator.generate(size);
        this.rule = rule;
    }

    public List<List<Boolean>> buildGenerations(int n) {
        List<List<Boolean>> matrix = new ArrayList<>();
        List<Boolean> row = initialRow;
        for (int y = 0; y < n; y++) {
            matrix.add(row);
            row = calculateNextRow(row);
        }
        return matrix;
    }

    private List<Boolean> calculateNextRow(List<Boolean> row) {
        List<Boolean> nextRow = new ArrayList<>();
        nextRow.add(rule.calculate(row.get(row.size() - 1), row.get(0), row.get(1)));
        for (int i = 1; i < row.size() - 1; i++) {
            nextRow.add(rule.calculate(row.get(i - 1), row.get(i), row.get(i + 1)));
        }
        nextRow.add(rule.calculate(row.get(row.size() - 2), row.get(row.size() - 1), row.get(0)));
        return nextRow;
    }

}
