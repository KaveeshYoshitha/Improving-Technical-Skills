import javax.swing.*;
import java.awt.*;

import static java.awt.SystemColor.text;

public class FlowLayoutEx1 extends JFrame {
    String[] labels = { "Yellow", "Blue", "Red", "Green", "Orange" };

    public  FlowLayoutEx1(){
        super("Flow Layout example");
        setup();
    }

    private void setup(){
        getContentPane().setLayout(new FlowLayout());
        for (String label : labels) {
            getContentPane().add(new JButton(label));
        }
        getContentPane().add(new Label( "Extra"));
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
