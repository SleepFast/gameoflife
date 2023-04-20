package gameoflife.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StopButton extends JButton {
    String title;
    FrameCanvas monCanevas;
    // boolean maVariable = true;
    static boolean maVariable = true;

    public StopButton(String title, FrameCanvas monCanevas) {
        this.title = title;
        this.monCanevas = monCanevas;

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                maVariable = !maVariable;
            }  
        }); 

        // addMouseListener(new MouseAdapter() {
        //     public void mousePressed(MouseEvent e) {
        //         maVariable = !maVariable;
        //     }
        // });
    }

    public static boolean getMaVariable() {
        return maVariable;
    }
}