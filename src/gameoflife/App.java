package gameoflife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import gameoflife.ui.FrameCanvas;
import gameoflife.ui.StopButton;
import gameoflife.ui.Window;

public class App {
    public static void main(String[] args) {
        Window window = new Window("Game of life");
        
        Dimension dimensionCanvas = new Dimension(600, 600);
        Dimension slot = new Dimension(10, 10);
        
        Grid maGridDeGrid = new Grid(60, 60);
        FrameCanvas monCanevas = new FrameCanvas(dimensionCanvas, slot, maGridDeGrid);
        
        JPanel menu = new JPanel();
        menu.setPreferredSize(new Dimension(100, 40));
        menu.setBackground(Color.ORANGE);
        menu.setOpaque(true);

        StopButton b=new StopButton("pouet", monCanevas);  
        b.setBounds(0, 0, 0, 0);  
        b.setSize(10, 10);
        b.setBackground(Color.BLACK);
        b.setOpaque(true);

        menu.add(b);

        window.add(monCanevas, BorderLayout.WEST);
        window.add(menu, BorderLayout.EAST);
        window.pack();

        StartGame(monCanevas);
    }

    public static void StartGame(FrameCanvas monCanevas) {
        while (true) {
            if(StopButton.getMaVariable() == false) {
                monCanevas.nextGen();
            };
            
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
               break;
            }
        }
    }
}
