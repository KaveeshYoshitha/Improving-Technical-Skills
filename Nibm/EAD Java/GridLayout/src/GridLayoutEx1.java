import javax.swing.*;
import java.awt.*;

public class GridLayoutEx1 extends JFrame{
    String[] labels = {"Yellow", "Blue", "Red", "Green", "Orange"};

    public GridLayoutEx1(){
        super("GridLayout Example");
        setup();
    }
    private void setup(){
        getContentPane().setLayout(new GridLayout(3, 2));
        for (String label : labels) {
            getContentPane().add(new Button(label));
        }
        pack();
        setVisible(true);
    }
}
