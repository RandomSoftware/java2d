/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.randomsoftware.java2d;

import ru.randomsoftware.java2d.rules.Rule;
import ru.randomsoftware.java2d.rules.Rule184;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App extends Frame {

    private static final Random RND = new Random();
    private static final Rule<Boolean> rule = new Rule184();
    private static final int WIDTH = 100;
    private static final int HEIGHT = 800;

    App() {
        prepareGUI();
    }

    private void prepareGUI(){
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = WIDTH;
        int height = HEIGHT;
        // Create the new image needed
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        List<Boolean> row = new ArrayList<>(width);
        for (int i = 0; i < width; i++) {
            boolean color = RND.nextBoolean();
            row.add(color);
            drawPixel(img, i, 0, color);
        }

        for (int y = 1; y < height; y++) {
            row = calculateNextRow(row);
            for (int x = 0; x < row.size(); x++) {
                drawPixel(img, x, y, row.get(x));
            }
        }
        g2d.drawImage(img, 0, 0, null);
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

    private void drawPixel(BufferedImage img, int x, int y, boolean color) {
        img.setRGB(x, y, color ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
    }

    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
    }
}
