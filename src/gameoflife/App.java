package gameoflife;

import java.awt.Dimension;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        JFrame maFenetre = new JFrame();
        maFenetre.setVisible(true);
        maFenetre.setSize(400, 400);
        maFenetre.setResizable(false);
        
        Dimension dimensionCanvas = new Dimension(800, 800);
        Dimension slot = new Dimension(10, 10);
        
        Grid maGridDeGrid = new Grid(80, 80);
        FrameCanvas monCanevas = new FrameCanvas(dimensionCanvas, slot, maGridDeGrid);
        
        maFenetre.add(monCanevas);
        maFenetre.pack();

        for(;;) {
            monCanevas.startGame();

            try {
                Thread.sleep(60);
            } catch (Exception e) {
                break;
            }
        }
    }
}
