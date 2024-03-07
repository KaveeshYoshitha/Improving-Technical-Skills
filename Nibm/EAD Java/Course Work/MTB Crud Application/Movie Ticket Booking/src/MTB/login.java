package MTB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class login extends JFrame implements ActionListener {

    public JTextField usernameField;
    public JPasswordField passwordField;

    public login() {
        // JFrame
        setTitle("Login");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        // Create components
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        Font montserratFont = new Font("Montserrat", Font.BOLD, 50);
        titleLabel.setFont(montserratFont);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        usernameLabel.setForeground(Color.WHITE);
        usernameField = new JTextField();
        usernameField.setFont(new Font("Montserrat", Font.PLAIN, 30));
        usernameField.setPreferredSize(new Dimension(200, 30));
        usernameField.setForeground(Color.BLACK);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Montserrat", Font.PLAIN, 35));
        passwordLabel.setForeground(Color.WHITE);
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Montserrat", Font.PLAIN, 30));
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setForeground(Color.BLACK);

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(220, 60));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(33, 38, 45));
        loginButton.setFont(new Font("Montserrat", Font.BOLD, 30));
        loginButton.setFocusable(false);

        loginButton.addActionListener(this);

        // Panel1
        JPanel panel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(0,0,0));
            }
        };
        panel1.setPreferredSize(new Dimension(1500, 100));
        panel1.add(titleLabel);

        // Panel2 with GridBagLayout
        JPanel panel2 = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(13, 17, 23));
            }
        };
        panel2.setPreferredSize(new Dimension(1500, 100));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel2.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel2.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel2.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel2.add(passwordField, gbc);

        // Panel3
        JPanel panel3 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(13, 17, 23));
            }
        };
        panel3.setPreferredSize(new Dimension(1500, 150));
        panel3.add(loginButton);



        // Add components to the frame
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String enteredUsername = usernameField.getText().trim();
        char[] enteredPassword = passwordField.getPassword();

        try {
            String query = "SELECT * FROM Adminn WHERE AID = '" + enteredUsername + "'";

            ResultSet resultSet = new dbConnection().executeQuery(query);

            if (resultSet != null && resultSet.next()) {
                String storedPassword = resultSet.getString("APassword").trim();

                System.out.println("Entered Password: " + new String(enteredPassword));
                System.out.println("Stored Password: " + storedPassword);

                if (new String(enteredPassword).equals(storedPassword)) {
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "Login");

                    dashboard dashboard = new dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Login");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }








    public static void main(String[] args) {
        login l1 = new login();
    }
}
