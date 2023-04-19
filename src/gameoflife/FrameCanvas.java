package gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class FrameCanvas extends JPanel {
    private final Dimension slot;
    private Grid grid;

    public FrameCanvas(final Dimension size, final Dimension slot, Grid grid) {
        this.slot = slot;
        this.grid = grid;

        setPreferredSize(size);
    }

    public void paintComponent(final Graphics graphics) {
        final Graphics2D pinceau = (Graphics2D) graphics;

        pinceau.scale(slot.width, slot.height);

        pinceau.clearRect( 0, 0, grid.width,grid.height);
        
        for (int i = 0, j; i < grid.width; i++) {
            for (j = 0; j < grid.height; j++) {
                if (grid.grid[i][j]) {
                    pinceau.setColor(Color.BLACK);
                } else {
                    pinceau.setColor(Color.WHITE);
                }
                pinceau.fillRect(i, j, 1, 1);
            }
        }
    }

    public void startGame() {
        final boolean[][] newGridDeGrid = new boolean[grid.width][grid.height];

        for (int i = 0; i < grid.width; i++) {
            for (int j = 0; j < grid.height; j++) {
                newGridDeGrid[i][j] = grid.liveOrDie(grid.getNeighborCount(i, j), grid.grid[i][j]);
            }
        }

        grid.grid = newGridDeGrid;

        repaint();
    }
}