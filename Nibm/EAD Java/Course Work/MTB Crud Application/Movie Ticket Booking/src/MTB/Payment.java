package MTB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Payment extends JFrame implements ActionListener {

    private JLabel sAmountLabel;
    private JLabel sPriceLabel;

    private JLabel billLabel;

    private String cusName;

    private String movieName;

    public Payment(String cusName) {
        this.cusName = cusName;

        // JFrame
        setTitle("MovieHub");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        // Create components
        JLabel titleLabel = new JLabel("Payment");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        Font montserratFont = new Font("Montserrat", Font.BOLD, 50);
        titleLabel.setFont(montserratFont);

        JButton payBtn = new JButton("Pay");
        payBtn.setPreferredSize(new Dimension(220, 60));
        payBtn.setForeground(Color.WHITE);
        payBtn.setBackground(new Color(33, 38, 45));
        payBtn.setFont(new Font("Montserrat", Font.BOLD, 30));
        payBtn.setFocusable(false);
        payBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performPay();
            }
        });

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
        panel1.add(titleLabel, gbc);

        // Panel2
        JPanel panel2 = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(0, 0, 0));
            }
        };

        JPanel panel3 = new JPanel(new GridLayout(3, 3, 20, 20)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(0, 0, 0));
            }
        };

        JLabel blankLabel = new JLabel();
        blankLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        blankLabel.setForeground(Color.WHITE);

        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        amountLabel.setForeground(Color.WHITE);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        priceLabel.setForeground(Color.WHITE);

//        seat----------------------------------------------
        JLabel seatLabel = new JLabel("Seat");
        seatLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        seatLabel.setForeground(Color.WHITE);

        sAmountLabel = new JLabel();
        sAmountLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        sAmountLabel.setForeground(Color.WHITE);

        sPriceLabel = new JLabel();
        sPriceLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        sPriceLabel.setForeground(Color.WHITE);

//        seat------------------------------------------------

//        totbill-----------------------------------------------

        JLabel totalLabel = new JLabel("Total");
        totalLabel.setFont(new Font("Montserrat", Font.PLAIN, 45));
        totalLabel.setForeground(Color.WHITE);

        JLabel blankLabel1 = new JLabel();
        blankLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        blankLabel.setForeground(Color.WHITE);

        billLabel = new JLabel();
        billLabel.setFont(new Font("Montserrat", Font.PLAIN, 45));
        billLabel.setForeground(Color.WHITE);
//        totbill----------------------------------------------------

        panel3.add(blankLabel);
        panel3.add(amountLabel);
        panel3.add(priceLabel);
        panel3.add(seatLabel);
        panel3.add(sAmountLabel);
        panel3.add(sPriceLabel);
        panel3.add(totalLabel);
        panel3.add(blankLabel1);
        panel3.add(billLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(backBtn);

        JPanel buttonPanelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanelRight.add(payBtn);

        panel2.add(buttonPanel, BorderLayout.WEST);
        panel2.add(buttonPanelRight, BorderLayout.EAST);

        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.SOUTH);
        add(panel3, BorderLayout.CENTER);

        // Fetch seat data from the database and update labels
        updateSeatLabels();

        // Set frame visible
        setVisible(true);



    }

    private void updateSeatLabels() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "root")) {
            String query = "SELECT sQuantity FROM seat LIMIT 1";  // Assuming you have only one row in the seat table
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    int sQuantity = resultSet.getInt("sQuantity");

                    // Set sAmountLabel text
                    sAmountLabel.setText(String.valueOf(sQuantity));

                    // Calculate and set sPriceLabel text
                    int totalPrice = sQuantity * 200; //Assuming price is 200
                    sPriceLabel.setText(String.valueOf(totalPrice));
                    billLabel.setText(String.valueOf(totalPrice));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to fetch seat data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks if needed
    }

    private void performBack() {
        dispose();
        new SeatBooking();
    }




    private void performPay() {
            // Assuming you have the username and movie name from previous panels
            String userName = cusName;  // Replace with actual username
        // ch the total bill from the billLabel

            int totalBill = Integer.parseInt(billLabel.getText());

            // Save payment details to the database
            try (Connection connection001 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "root")) {
                String query = "INSERT INTO cinema.pay(userName,amount) VALUES (?, ?)";
                try (PreparedStatement statement = connection001.prepareStatement(query)) {
                    statement.setString(1, cusName);
                    statement.setInt(2, totalBill);
                    statement.executeUpdate();
                }

                JOptionPane.showMessageDialog(this, "Payment Successful!");

                // Close the payment window and navigate to the dashboard
                dispose();
                new dashboard();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to save payment details.", "Error", JOptionPane.ERROR_MESSAGE);
            }


    }

    public class SharedData {
        public static String username;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Prompt the user for the username (you might want to get it from your SeatBooking frame)
//            String cusName = JOptionPane.showInputDialog("Enter username:");

            // Create an instance of Payment with the provided username
//            new Payment(cusName);
        });
    }
}
