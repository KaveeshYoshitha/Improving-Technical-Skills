import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameEx1 extends JFrame {
    public JFrameEx1() {
        super("My First JFrame");
        setup();
    }

    public void setup() {
        getContentPane().add(new JLabel("Hello, World!"));
        setSize(300, 300); // Corrected from setsize to setSize
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Added to close the window properly
        setVisible(true);
    }
}
