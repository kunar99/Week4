
/**
 * File Name: MildotCalculator.java
 * Author: Souhair El Omari
 * Date: July 11, 2017
 * Purpose: Calculate the body mass index using TextFields
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MildotCalculator extends JFrame implements ActionListener {

    //holds height and weight for JFrame
    private static final int WIDTH = 775;
    private static final int HEIGHT = 250;

    // Calculate button
    private static JButton button;

    //text fields for input and output
    private static JTextField sizeNumberTxt;
    private static JTextField milNumberTxt;
    public static JTextField outputShot;

    //labels for input and output
    private static JLabel sizeLabel;
    private static JLabel milLabel;
    private static JLabel resultsLabel;
    private static JLabel exampleLabel;

    //constructor
    public MildotCalculator() {
        super("Mildot Range Calculator");

        //lays out the basic specifications of the frame
        setFrame(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);

        //creates a Jpanel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel, BorderLayout.SOUTH);


        //textPanel specifications
        JPanel textPanel = new JPanel();
        JPanel textPanel2 = new JPanel();
        add(textPanel, BorderLayout.WEST);
        add(textPanel2, BorderLayout.NORTH);


        // Create TextFeilds and their Labels
        exampleLabel = new JLabel("Example: (Target is 68 inches * 27.8) divided by (Target in Mil Reticle is 4 mils) equals a distance to target of 472.6 yards");
        textPanel2.add(exampleLabel);

        sizeLabel = new JLabel("Target size in inches: "); // Weight
        textPanel.add(sizeLabel);
        sizeNumberTxt = new JTextField(5);
        textPanel.add(sizeNumberTxt);
        sizeNumberTxt.setEditable(true);
        sizeNumberTxt.setToolTipText("This field is to enter the size of your target in inches. Target size needs to be in inches to be calculated corrected.");

        milLabel = new JLabel("Mils of your target:  "); // Height
        textPanel.add(milLabel);
        milNumberTxt = new JTextField(5);
        textPanel.add(milNumberTxt);
        milNumberTxt.setEditable(true);
        milNumberTxt.setToolTipText("This field corresponds to the amount of mildots your target is from the bottom first dot, within your scopes reticle.");

        resultsLabel = new JLabel("Distance in Yards-to-Target: ");            // BMI result
        textPanel.add(resultsLabel);
        outputShot = new JTextField(10);
        textPanel.add(outputShot);
        outputShot.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 15));
        outputShot.setForeground(Color.RED);
        outputShot.setEditable(false);



        //add button specifications
        button = new JButton("Calculate Your Shot");
        panel.add(button);
        button.setToolTipText("Button must be clicked to calculate the distance");

    }

    @Override //Implement the ActionListener interface
    public void actionPerformed(ActionEvent arg0) {
    }

    //Create the frame
    private void setFrame(int width, int height) {
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Displays the GUI
    private void display() {
        setVisible(true);
    }

    //checks if the input is a numeric value
    public static boolean number(String input) {

        boolean number = false;
        try {
            Double.parseDouble(input);
            number = true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Incorrect value entered, please, enter a number");
        }
        return number;
    }


    //Method to calculate the distance in yards
    private static void calcYards(double value, double mils) {
        double yards = (27.8 * value / mils);
        DecimalFormat df = new DecimalFormat("###.##");

        outputShot.setText(df.format(yards));
    }


    //main method
    public static void main(String[] args) {
        MildotCalculator calc = new MildotCalculator();

        calc.display();

        double value;
        double mils;

        // Event handler for the button
        button.addActionListener (e ->  {

            if (number(sizeNumberTxt.getText()) && number(milNumberTxt.getText()))
                    { calcYards (Double.parseDouble(sizeNumberTxt.getText()), Double.parseDouble(milNumberTxt.getText())); }
        } );

    }
}