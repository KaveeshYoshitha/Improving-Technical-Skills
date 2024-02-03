// MyFirstWindow.java
import java.awt.Color;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;

public class MyFirstWindow extends Frame {

    public MyFirstWindow(String title) throws HeadlessException {
        super(title);
        setup();
    }

    private void setup() {
        setBackground(Color.DARK_GRAY);
        setSize(400, 400);
        add(new Label("This is my first window"));
        setVisible(true);
    }
}
