package MTB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAdd();
            }
        });

        JButton viewBtn = new JButton("View");
        viewBtn.setPreferredSize(new Dimension(220, 60));
        viewBtn.setForeground(Color.WHITE);
        viewBtn.setBackground(new Color(33, 38, 45));
        viewBtn.setFont(new Font("Montserrat", Font.BOLD, 30));
        viewBtn.setFocusable(false);
        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performView();
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
        gbc.insets = new Insets(0, 10, 80, 30); // Padding at the bottom
        panel1.add(titleLabel, gbc);

        gbc.gridy = 1;
        panel1.add(dashboardBtn, gbc);

        gbc.gridy = 2;
        panel1.add(addBtn, gbc);

        gbc.gridy = 3;
        panel1.add(viewBtn, gbc);

        // Panel2
        JPanel panel2 = new JPanel(new GridLayout(2, 3, 5, 5)){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(0, 0, 0));
            }
        };;

        // Adding dynamic movie posters to the center panel
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "root")) {
            String query = "SELECT moviePoster, mName FROM cinema.movie LIMIT 6";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                int movieIndex = 1;
                while (resultSet.next()) {
                    String moviePosterPath = resultSet.getString("moviePoster");
                    String movieName = resultSet.getString("mName");
                    System.out.println("Movie Name: " + movieName);  // Check if movieName is retrieved correctly

                    ImageIcon moviePoster = getScaledImageIcon(moviePosterPath, 200, 300);
                    JButton movieButton = new JButton(movieName);
                    movieButton.setIcon(moviePoster);
                    movieButton.setVerticalTextPosition(SwingConstants.BOTTOM);
                    movieButton.setHorizontalTextPosition(SwingConstants.CENTER);
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
                    cardPanel.add(movieButton, BorderLayout.CENTER);

                    panel2.add(cardPanel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Print statement to check if the panel is populated
        System.out.println("Number of components in panel2: " + panel2.getComponentCount());

        // Add components to the JFrame
        add(panel1, BorderLayout.WEST);
        add(new JScrollPane(panel2), BorderLayout.CENTER);
        setVisible(true);
    }


    private ImageIcon getScaledImageIcon(String imagePath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public void actionPerformed(ActionEvent e) {
    }

    private void performDashboard() {
        dispose();
        new dashboard();
    }

    private void performAdd() {
        dispose();
        new Add();
    }

    private void performView() {
        dispose();
        new view();
    }

    private void selectMovie() {
        dispose();
        new SeatBooking();
    }

    public static void main(String[] args) {
        dashboard dashboard = new dashboard();
    }
}
