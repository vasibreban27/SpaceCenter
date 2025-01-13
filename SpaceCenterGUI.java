
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class SpaceCenterGUI {
    private final SpaceCenter spaceCenter;

    public SpaceCenterGUI() {
        this.spaceCenter = new SpaceCenter();
        createGUI();
    }

    private void createGUI() {
        // Main Frame
        JFrame frame = new JFrame("Space Center Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Panel for inputs
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        JLabel nameLabel = new JLabel("Aircraft Name:");
        JTextField nameField = new JTextField();
        JLabel maxDistanceLabel = new JLabel("Max Distance:");
        JTextField maxDistanceField = new JTextField();
        JLabel colorLabel = new JLabel("Color:");
        JTextField colorField = new JTextField();
        JLabel yearLabel = new JLabel("Year:");
        JTextField yearField = new JTextField();

        JButton addButton = new JButton("Add Aircraft");
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(maxDistanceLabel);
        inputPanel.add(maxDistanceField);
        inputPanel.add(colorLabel);
        inputPanel.add(colorField);
        inputPanel.add(yearLabel);
        inputPanel.add(yearField);
        inputPanel.add(new JLabel()); // Empty cell
        inputPanel.add(addButton);

        // Panel for displaying aircraft names
        JPanel displayPanel = new JPanel(new BorderLayout());
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        JButton refreshButton = new JButton("Refresh Aircraft List");

        displayPanel.add(new JLabel("Aircraft Names:"), BorderLayout.NORTH);
        displayPanel.add(scrollPane, BorderLayout.CENTER);
        displayPanel.add(refreshButton, BorderLayout.SOUTH);

        // Add functionality to buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    int maxDistance = Integer.parseInt(maxDistanceField.getText());
                    String color = colorField.getText();
                    int year = Integer.parseInt(yearField.getText());

                    // Create and add an Aircraft
                    Aircraft newAircraft = new Aircraft(name, maxDistance, color, year);
                    spaceCenter.addAircraft(newAircraft);

                    JOptionPane.showMessageDialog(frame, "Aircraft added successfully!");

                    // Clear input fields
                    nameField.setText("");
                    maxDistanceField.setText("");
                    colorField.setText("");
                    yearField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid data!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Refresh the display area with the list of aircraft names
                StringBuilder aircraftList = new StringBuilder();
                List<Aircraft> aircrafts = spaceCenter.getAircrafts(); // Ensure this returns a List or Collection

                for (Aircraft aircraft : aircrafts) { // Correct iteration over the list
                    aircraftList.append(aircraft.getName()).append("\n");
                }

                displayArea.setText(aircraftList.toString());
            }
        });

        // Layout for the main frame
        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(displayPanel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SpaceCenterGUI();
    }
}
