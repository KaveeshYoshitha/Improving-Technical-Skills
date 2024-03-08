package MTB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class dashboard extends JFrame implements ActionListener {

    public dashboard() {
        // JFrame
        setTitle("Dashboard");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        // Create components
        JLabel titleLabel = new JLabel("Admin");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        Font montserratFont = new Font("Montserrat", Font.BOLD, 50);
        titleLabel.setFont(montserratFont);

        JButton dashboardBtn = new JButton("Dashboard");
        dashboardBtn.setPreferredSize(new Dimension(220, 60));
        dashboardBtn.setForeground(Color.WHITE);
        dashboardBtn.setBackground(new Color(33, 38, 45));
        dashboardBtn.setFont(new Font("Montserrat", Font.BOLD, 30));
        dashboardBtn.setFocusable(false);
        dashboardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDashboard();
            }
        });


        JButton addBtn = new JButton("Add");
        addBtn.setPreferredSize(new Dimension(220, 60));
        addBtn.setForeground(Color.WHITE);
        addBtn.setBackground(new Color(33, 38, 45));
        addBtn.setFont(new Font("Montserrat", Font.BOLD, 30));
        addBtn.setFocusable(false);


        // Panel1
        JPanel panel1 = new JPanel(new GridBagLayout()) {
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
        panel1.add(dashboardBtn, gbc);

        gbc.gridy = 2;
        panel1.add(addBtn, gbc);

        // Panel2 (Center Panel) with GridLayout for movie posters (cards)
        JPanel panel2 = new JPanel(new GridLayout(2, 3, 20, 20)); // Change the grid dimensions as needed

        // Adding movie posters (cards) to the center panel
        for (int i = 1; i <= 6; i++) {
            ImageIcon moviePoster = new ImageIcon("C:\\Users\\MSI\\OneDrive\\Desktop\\MTB Crud Application\\Assest\\images\\1.jpg" + i + ".jpg");
            JButton movieButton = new JButton("Movie " + i);
            movieButton.setForeground(Color.WHITE);
            movieButton.setBackground(new Color(33, 38, 45));
            movieButton.setFont(new Font("Montserrat", Font.BOLD, 30));
            movieButton.setFocusable(false);
            movieButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectMovie();
                }
            });



            JPanel cardPanel = new JPanel(new BorderLayout());
            cardPanel.add(new JLabel(moviePoster), BorderLayout.CENTER);
            cardPanel.add(movieButton, BorderLayout.SOUTH);

            panel2.add(cardPanel);
        }

        // Add components to the JFrame
        add(panel1, BorderLayout.WEST);
        add(new JScrollPane(panel2), BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button clicks if needed
    }

    private void performDashboard() {
        dispose();
        new dashboard();
    }

    private void selectMovie() {
        dispose();
        new SeatBooking();
    }

    public static void main(String[] args) {
        dashboard dashboard = new dashboard();
    }
}
