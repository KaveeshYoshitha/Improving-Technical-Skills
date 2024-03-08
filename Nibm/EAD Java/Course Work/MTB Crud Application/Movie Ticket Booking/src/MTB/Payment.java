package MTB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {

    public Payment() {
        // JFrame
        setTitle("Payment");
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
//        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(0, 0, 0));
            }
        };

        JPanel panel3 = new JPanel(new GridLayout(5,4,20, 20)) {
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


        JLabel idLabel = new JLabel("Id");
        idLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        idLabel.setForeground(Color.WHITE);


        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        priceLabel.setForeground(Color.WHITE);

        //Seat-----------------------------------------------------------

        JLabel seatLabel = new JLabel("Seat");
        seatLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        seatLabel.setForeground(Color.WHITE);

        JLabel sIdLabel = new JLabel();
        sIdLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        sIdLabel.setForeground(Color.WHITE);

        JLabel sAmountLabel = new JLabel();
        sAmountLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        sAmountLabel.setForeground(Color.WHITE);

        JLabel sPriceLabel = new JLabel();
        sPriceLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        sPriceLabel.setForeground(Color.WHITE);

        //seat-----------------------------------------------------------
        //Food-----------------------------------------------------------

        JLabel foodLabel = new JLabel("Food");
        foodLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        foodLabel.setForeground(Color.WHITE);

        JLabel fIdLabel = new JLabel();
        fIdLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        fIdLabel.setForeground(Color.WHITE);

        JLabel fAmountLabel = new JLabel();
        fAmountLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        fAmountLabel.setForeground(Color.WHITE);

        JLabel fPriceLabel = new JLabel();
        fPriceLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        fPriceLabel.setForeground(Color.WHITE);

        //Food-----------------------------------------------------------
        //Tax-----------------------------------------------------------
        JLabel taxLabel = new JLabel("Tax");
        taxLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        taxLabel.setForeground(Color.WHITE);

        JLabel tIdaLabel = new JLabel();
        tIdaLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        tIdaLabel.setForeground(Color.WHITE);

        JLabel tAmountLabel = new JLabel();
        tAmountLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        tAmountLabel.setForeground(Color.WHITE);

        JLabel tPriceLabel = new JLabel();
        tPriceLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        tPriceLabel.setForeground(Color.WHITE);

        //Tax-----------------------------------------------------------
        //final bill-----------------------------------------------------------
        JLabel totalLabel = new JLabel("Total");
        totalLabel.setFont(new Font("Montserrat", Font.PLAIN, 45));
        totalLabel.setForeground(Color.WHITE);

        JLabel blankLabel1 = new JLabel();
        blankLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        blankLabel.setForeground(Color.WHITE);

        JLabel blankLabel2 = new JLabel();
        blankLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        blankLabel.setForeground(Color.WHITE);

        JLabel billLabel = new JLabel();
        billLabel.setFont(new Font("Montserrat", Font.PLAIN, 45));
        billLabel.setForeground(Color.WHITE);

        //final bill-----------------------------------------------------------


        panel3.add(blankLabel);
        panel3.add(amountLabel);
        panel3.add(idLabel);
        panel3.add(priceLabel);
        panel3.add(seatLabel);
        panel3.add(sAmountLabel);
        panel3.add(sIdLabel);
        panel3.add(sPriceLabel);
        panel3.add(foodLabel);
        panel3.add(fAmountLabel);
        panel3.add(fIdLabel);
        panel3.add(fPriceLabel);
        panel3.add(taxLabel);
        panel3.add(tAmountLabel);
        panel3.add(tIdaLabel);
        panel3.add(tPriceLabel);
        panel3.add(totalLabel);
        panel3.add(blankLabel1);
        panel3.add(blankLabel2);
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

        // Set frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks if needed
    }

    private void performBack() {
        dispose();
        new food();
    }

    private void performPay() {
        JOptionPane.showMessageDialog(this, "Payment Successful!");
        dispose();
        new dashboard();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Payment::new);
    }
}
