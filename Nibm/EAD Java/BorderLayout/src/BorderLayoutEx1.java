import javax.swing.*;
import java.awt.*;


public class BorderLayoutEx1 extends JFrame{
    public BorderLayoutEx1(){
        super("BorderLayout Example");
        setup();
    }
    private void setup(){
        getContentPane().setLayout(new BorderLayout());
        BorderLayout borderLayout = new BorderLayout();
        //jpanel is a generic lightweight container

        JPanel jPanel = new JPanel(borderLayout);
        jPanel.add(new Button("North"), BorderLayout.NORTH);
        jPanel.add(new Button("South"), BorderLayout.SOUTH);
        jPanel.add(new Button("East"), BorderLayout.CENTER);
        jPanel.add(new Button("West"), BorderLayout.EAST);

        getContentPane().add(jPanel, BorderLayout.NORTH);
        getContentPane().add(new Button("Red"), BorderLayout.NORTH);
        getContentPane().add(new Button("Green"), BorderLayout.SOUTH);
        getContentPane().add(new Button("Blue"), BorderLayout.EAST);
        getContentPane().add(new Button("Yellow"), BorderLayout.WEST);
        getContentPane().add(new Button("White"), BorderLayout.CENTER);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args){
        new BorderLayoutEx1();
    }
}
