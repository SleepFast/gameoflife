package gameoflife.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gameoflife.App;

public class StopButton extends JButton {
    String title;
    FrameCanvas monCanevas;
    static boolean maVariable = false;

    public StopButton(String title, FrameCanvas monCanevas) {
        this.title = title;
        this.monCanevas = monCanevas;
        addActionListener(new StopButtonAction(this));  
    }

    public void stopAndPlay() {
        maVariable = !maVariable;
        App.StartGame(monCanevas);
    }

    public static boolean getMaVariable() {
        return maVariable;
    }

    public static class StopButtonAction implements ActionListener {
        StopButton button;

        public StopButtonAction(StopButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            button.stopAndPlay();
        }
    }
    
}