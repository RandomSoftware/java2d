package ru.randomsoftware.java2d.renderer;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.List;

public class RendererBW extends Frame implements Renderer<Boolean> {

    private final static int OFFSET = 22;
    private final int frameWidth;
    private final int frameHeight;

    private List<List<Boolean>> matrix;

    public RendererBW(int width, int height) {
        this.frameWidth = width;
        this.frameHeight = height;
        prepareGUI();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        BufferedImage img = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_INT_RGB);

        int y = 0;
        for (List<Boolean> row : matrix) {
            drawRow(img, row, y++);
        }
        g2d.drawImage(img, 0, OFFSET, null);
    }

    @Override
    public void render(List<List<Boolean>> matrix) {
        this.matrix = matrix;
        setVisible(true);
    }

    private void prepareGUI(){
        setSize(frameWidth, frameHeight + OFFSET);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
    }

    private void drawRow(BufferedImage img, List<Boolean> row, int y) {
        for (int x = 0; x < row.size(); x++) {
            drawPixel(img, x, y, row.get(x));
        }
    }

    private void drawPixel(BufferedImage img, int x, int y, boolean color) {
        img.setRGB(x, y, color ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
    }

}
