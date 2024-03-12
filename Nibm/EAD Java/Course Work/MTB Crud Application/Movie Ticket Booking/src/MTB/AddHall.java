package MTB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddHall extends JFrame implements ActionListener {

    public AddHall() {
        setTitle("Add Hall");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel("Add Hall");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        Font montserratFont = new Font("Montserrat", Font.BOLD, 50);
        titleLabel.setFont(montserratFont);

        JLabel hallIDLabel = new JLabel("Hall ID : ");
        hallIDLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        hallIDLabel.setForeground(Color.WHITE);
        JTextField hallIDField = new JTextField();
        hallIDField.setFont(new Font("Montserrat", Font.PLAIN, 30));
        hallIDField.setPreferredSize(new Dimension(200, 30));
        hallIDField.setForeground(Color.BLACK);


        JLabel adminIDLabel = new JLabel("Admin ID : ");
        adminIDLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        adminIDLabel.setForeground(Color.WHITE);
        JTextField adminIDField = new JTextField();
        adminIDField.setFont(new Font("Montserrat", Font.PLAIN, 30));
        adminIDField.setPreferredSize(new Dimension(200, 30));
        adminIDField.setForeground(Color.BLACK);

        JButton addHallButton = new JButton("Add Hall");
        addHallButton.setPreferredSize(new Dimension(220, 60));
        addHallButton.setForeground(Color.WHITE);
        addHallButton.setBackground(new Color(33, 38, 45));
        addHallButton.setFont(new Font("Montserrat", Font.BOLD, 30));
        addHallButton.setFocusable(false);

        JButton backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(220, 60));
        backBtn.setForeground(Color.WHITE);
        backBtn.setBackground(new Color(33, 38, 45));
        backBtn.setFont(new Font("Montserrat", Font.BOLD, 30));
        backBtn.setFocusable(false);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performBack();
            }
        });

        JPanel panel1 = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(0, 0, 0));
            }
        };
        JPanel panel2 = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(0, 0, 0));
            }
        };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 80, 30); // Padding at the bottom
        panel1.add(titleLabel, gbc);

        gbc.gridy = 1;
        panel1.add(hallIDLabel, gbc);
        gbc.gridy = 2;
        panel1.add(adminIDLabel, gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;
        panel1.add(hallIDField, gbc);
        gbc.gridy = 2;
        panel1.add(adminIDField, gbc);


        panel2.add(addHallButton, BorderLayout.EAST);
        panel2.add(backBtn, BorderLayout.WEST);

        // Add components to the JFrame
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implement if needed
    }

    private void performBack() {
        dispose();
        new Add();
    }

    public static void main(String[] args) {
        new AddHall().setVisible(true);
    }
}
