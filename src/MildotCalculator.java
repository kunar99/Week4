
/**
 * Created by johnclayton on 07/10/2017.
 * Program will calculate the distance to a target using specified values
 * entered by a user via a GUI interface
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MildotCalculator extends JFrame implements ActionListener {

    //Height and weight for the JFrame
    private static final int WIDTH = 765;
    private static final int HEIGHT = 250;

    //Button to perform the distance calculation
    private static JButton button;

    //Creation of the text fields for input/output
    private static JTextField sizeNumberTxt;
    private static JTextField milNumberTxt;
    public static JTextField outputShot;

    //Creation of the label names
    private static JLabel sizeLabel;
    private static JLabel milLabel;
    private static JLabel resultsLabel;
    private static JLabel exampleLabel;

    //constructor
    public MildotCalculator() {
        super("Mildot Range Calculator");

        //Specifies the layout of the frame
        setFrame(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);

        //Creation of a JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        add(panel, BorderLayout.SOUTH);


        //Creating two textPanels to be used
        JPanel textPanel = new JPanel();
        JPanel textPanel2 = new JPanel();
        textPanel.setLayout(new GridLayout(4, 2));
        add(textPanel, BorderLayout.WEST);
        add(textPanel2, BorderLayout.NORTH);


        //Creating text and label fields for Value, Mils, Results, and example
        //Example label is created to give the user a visual example of data to input and validate their results.
        exampleLabel = new JLabel("Example: (Target is 68 inches * 27.8) divided by (Target in Mil Reticle is 4 mils) equals a distance to target of 472.6 yards");
        textPanel2.add(exampleLabel);

        //Creating a size text/label field for user to input their values
        sizeLabel = new JLabel("Target size in inches: ");
        textPanel.add(sizeLabel);
        sizeNumberTxt = new JTextField(5);
        textPanel.add(sizeNumberTxt);
        sizeNumberTxt.setEditable(true);
        //User can hover their mouse over this field to get an explanation of what data needs to be entered
        sizeNumberTxt.setToolTipText("This field is to enter the size of your target in inches. Target size needs to be in inches to be calculated corrected.");

       //Creating a mil Text/Label field for user to input their values
        milLabel = new JLabel("Mils of your target:  "); 
        textPanel.add(milLabel);
        milNumberTxt = new JTextField(5);
        textPanel.add(milNumberTxt);
        milNumberTxt.setEditable(true);
        //User can hover their mouse over this field to get an explanation of what data needs to be entered
        milNumberTxt.setToolTipText("This field corresponds to the amount of mildots your target is from the bottom first dot, within your scopes reticle.");

        //Creating a results Text/Label to display the calculated distance information
        resultsLabel = new JLabel("Distance in Yards-to-Target: ");           
        textPanel.add(resultsLabel);
        outputShot = new JTextField(5);
        textPanel.add(outputShot);
        outputShot.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 15));
        outputShot.setForeground(Color.RED);
        outputShot.setEditable(false);

        //Creating a JButton so user can perform the calculation
        button = new JButton("Calculate Your Shot");
        panel.add(button);
        //User can hover their mouse over this field to get an explanation of what action needs to be performed
        button.setToolTipText("Button must be clicked to calculate the distance");

    }

    //Creation of an ActionListener
    public void actionPerformed(ActionEvent arg0) {
    }

    
    private void setFrame(int width, int height) {
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Displays the GUI
    private void display() {
        setVisible(true);
    }

    //Try/Catch clause to ensure correct values are entered
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


    //Start of Main Method
    public static void main(String[] args) {
        MildotCalculator calc = new MildotCalculator();

        calc.display();


        //Action Listener for the Calc Button
        button.addActionListener (e ->  {

            if (number(sizeNumberTxt.getText()) && number(milNumberTxt.getText()))
                    { calcYards (Double.parseDouble(sizeNumberTxt.getText()), Double.parseDouble(milNumberTxt.getText())); }
        } );

    }//End of Main
}//End of Class
