package MTB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Blob;
import java.sql.SQLException;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.io.ByteArrayOutputStream; // Add this import statement
import java.awt.image.BufferedImage;




public class view extends JFrame implements ActionListener {

    private DefaultTableModel model;
    private JTable table;

    public view() {
        setTitle("MovieHub");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel("View");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        Font montserratFont = new Font("Montserrat", Font.BOLD, 50);
        titleLabel.setFont(montserratFont);

        JButton updateButton = new JButton("Update");
        updateButton.setPreferredSize(new Dimension(220, 60));
        updateButton.setForeground(Color.WHITE);
        updateButton.setBackground(new Color(33, 38, 45));
        updateButton.setFont(new Font("Montserrat", Font.BOLD, 30));
        updateButton.setFocusable(false);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performUpdate();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(220, 60));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(33, 38, 45));
        deleteButton.setFont(new Font("Montserrat", Font.BOLD, 30));
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDelete();
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

        String[] columns = {"Movie ID", "Movie Name", "Movie Poster", "Admin ID"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        // Customize your table as needed
        JScrollPane scrollPane = new JScrollPane(table);

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

        panel2.add(updateButton, BorderLayout.EAST);
        panel2.add(backBtn, BorderLayout.WEST);
        panel2.add(deleteButton, BorderLayout.CENTER);

        // Add components to the JFrame
        add(panel1, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        // Load data from the database
        loadDataFromDatabase();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implement if needed
    }

    private void performBack() {
        dispose();
        new dashboard();
    }





    private void loadDataFromDatabase() {
        try {
            // Load your database driver (replace "com.mysql.cj.jdbc.Driver" with your actual driver)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "root");

            // Execute a query to retrieve data
            String query = "SELECT mID, mName, moviePoster, AID FROM cinema.movie";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Clear existing table data
            model.setRowCount(0);

            // Populate the table with the retrieved data
            while (resultSet.next()) {
                String mID = resultSet.getString("mID");
                String mName = resultSet.getString("mName");

                // Handle BLOB data
                Blob moviePosterBlob = resultSet.getBlob("moviePoster");
                byte[] moviePosterBytes = moviePosterBlob.getBytes(1, (int) moviePosterBlob.length());

                // For simplicity, assuming moviePoster is a byte array
                // You might need to convert it to an appropriate image type for display
                String moviePoster = new String(moviePosterBytes);

                String AID = resultSet.getString("AID");

                // Add a new row to the table
                model.addRow(new Object[]{mID, mName, moviePoster, AID});
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void performDelete() {
        try {
            // Load your database driver (replace "com.mysql.cj.jdbc.Driver" with your actual driver)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "root");

            // Prepare the delete query
            String deleteQuery = "DELETE FROM cinema.movie WHERE mID = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);

            // Get the selected row index from the JTable
            int selectedRow = table.getSelectedRow();

            // Check if a row is selected
            if (selectedRow != -1) {
                // Get the movie ID from the selected row
                String mID = model.getValueAt(selectedRow, 0).toString();

                // Set the parameter for the delete query
                deleteStatement.setString(1, mID);

                // Execute the delete query
                int rowsAffected = deleteStatement.executeUpdate();

                // Check if the delete was successful and show a message box
                if (rowsAffected > 0) {
                    // Remove the row from the JTable
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Deleted successfully", "Delete Status", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Delete failed", "Delete Status", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to delete", "Delete Status", JOptionPane.WARNING_MESSAGE);
            }

            // Close resources
            deleteStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    private void performUpdate() {
        try {
            // Load your database driver (replace "com.mysql.cj.jdbc.Driver" with your actual driver)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "root");

            // Prepare the update query
            String updateQuery = "UPDATE cinema.movie SET mName = ?, moviePoster = ? WHERE mID = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);

            // Iterate through the table rows to get the changes and update the database
            for (int row = 0; row < model.getRowCount(); row++) {
                String mID = model.getValueAt(row, 0).toString();
                String newName = model.getValueAt(row, 1).toString();

                // Check if the name is different from the original value
                if (!newName.equals(getOriginalNameFromDatabase(mID, connection))) {

                    // Convert Image to BLOB
                    ImageIcon moviePosterIcon = (ImageIcon) model.getValueAt(row, 2);
                    Blob moviePosterBlob = connection.createBlob();
                    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                        ImageIO.write((BufferedImage) moviePosterIcon.getImage(), "jpg", byteArrayOutputStream);
                        moviePosterBlob.setBytes(1, byteArrayOutputStream.toByteArray());
                    }

                    // Set parameters for the update query
                    updateStatement.setString(1, newName);
                    updateStatement.setBlob(2, moviePosterBlob);
                    updateStatement.setString(3, mID);

                    // Execute the update query
                    int rowsAffected = updateStatement.executeUpdate();

                    // Check if the update was successful and show a message box
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Updated successfully", "Update Status", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Update failed", "Update Status", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            // Close resources
            updateStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private String getOriginalNameFromDatabase(String mID, Connection connection) throws SQLException {
        String originalName = null;
        // Execute a query to retrieve the original name from the database
        String query = "SELECT mName FROM cinema.movie WHERE mID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, mID);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Retrieve the original name
        if (resultSet.next()) {
            originalName = resultSet.getString("mName");
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();

        return originalName;
    }




    public static void main(String[] args) {
        new view().setVisible(true);
    }
}
