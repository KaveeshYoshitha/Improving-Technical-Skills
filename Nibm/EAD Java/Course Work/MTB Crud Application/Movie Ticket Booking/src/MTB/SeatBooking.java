package MTB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SeatBooking extends JFrame implements ActionListener {
    private JTextField seatAmountField;
    private JButton nextBtn;
    private JButton backBtn;

    public SeatBooking() {
        // JFrame
        setTitle("Seat Booking");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        // Create components
        JLabel titleLabel = new JLabel("Grab Your Seat");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        Font montserratFont = new Font("Montserrat", Font.BOLD, 50);
        titleLabel.setFont(montserratFont);

        nextBtn = new JButton("Add");
        nextBtn.setPreferredSize(new Dimension(220, 60));
        nextBtn.setForeground(Color.WHITE);
        nextBtn.setBackground(new Color(33, 38, 45));
        nextBtn.setFont(new Font("Montserrat", Font.BOLD, 30));
        nextBtn.setFocusable(false);
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performNext();
            }
        });


        backBtn = new JButton("Back");
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

        JLabel setAmountLabel = new JLabel("Enter the amount of seats you want to book: ");
        setAmountLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        setAmountLabel.setForeground(Color.WHITE);
        seatAmountField = new JTextField();
        seatAmountField.setFont(new Font("Montserrat", Font.PLAIN, 30));
        seatAmountField.setPreferredSize(new Dimension(200, 30));
        seatAmountField.setForeground(Color.BLACK);

        JPanel panel1 = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(0, 0, 0));
            }
        };
        JPanel panel2 = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(0, 0, 0));
            }
        };
        JPanel panel3 = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(0, 0, 0));
            }
        };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel2.add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(setAmountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel1.add(seatAmountField, gbc);

        panel3.add(backBtn, BorderLayout.WEST);
        panel3.add(nextBtn, BorderLayout.EAST);

        // Add components to JFrame
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.NORTH);
        add(panel3, BorderLayout.SOUTH);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void performNext() {
        dispose();
        new food();
    }

    public void performBack() {
        dispose();
        new dashboard();
    }


    public static void main(String[] args) {
        SeatBooking seatBooking = new SeatBooking();
    }

}
