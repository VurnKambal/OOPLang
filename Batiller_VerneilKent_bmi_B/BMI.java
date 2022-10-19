import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMI extends JFrame
{
    JLabel heightLabel = new JLabel();
    JLabel weightLabel = new JLabel();
    JLabel bmiLabel = new JLabel();
    JLabel heightFeetLabel = new JLabel();
    JLabel heightInchesLabel = new JLabel();
    JLabel weightPoundsLabel = new JLabel();
    
    JButton computeButton = new JButton();
    JButton clearButton = new JButton();
    JButton exitButton = new JButton();
    
    JTextField heightFeetTextField = new JTextField();
    JTextField heightInchesTextField = new JTextField();
    JTextField weightTextField = new JTextField();
    JTextField bmiTextField = new JTextField();
    
    double height, weight, bmi;
    int heightFeet, heightInches;

    public BMI()
    {
        setTitle("BMI Calculator");
        
        addWindowListener(new WindowAdapter()
        {
           public void windowClosing(WindowEvent e)
           {
               exitForm(e);
            }
        });
        
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        
        heightLabel.setText("   Height: ");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        getContentPane().add(heightLabel, gridConstraints);

        weightLabel.setText(" Weight: ");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        getContentPane().add(weightLabel, gridConstraints);
        
        bmiLabel.setText("       BMI: ");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        getContentPane().add(bmiLabel, gridConstraints);
        
        
        heightFeetTextField.setText("");
        heightFeetTextField.setColumns(9);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        getContentPane().add(heightFeetTextField, gridConstraints);
        
        weightTextField.setText("");
        weightTextField.setColumns(9);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        getContentPane().add(weightTextField, gridConstraints);
        
        bmiTextField.setText("0");
        bmiTextField.setColumns(9);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        getContentPane().add(bmiTextField, gridConstraints);
        

        
        
        heightFeetLabel.setText("feet");
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        getContentPane().add(heightFeetLabel, gridConstraints);
       
        weightPoundsLabel.setText("pounds");
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 1;
        getContentPane().add(weightPoundsLabel, gridConstraints);
        
        
        heightInchesTextField.setText("0");
        heightInchesTextField.setColumns(3);
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 0;
        getContentPane().add(heightInchesTextField, gridConstraints);
        
        heightInchesLabel.setText("inches");
        gridConstraints.gridx = 4;
        gridConstraints.gridy = 0;
        getContentPane().add(heightInchesLabel, gridConstraints);
        
        
        //Buttons
        computeButton.setText("Compute BMI");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        getContentPane().add(computeButton, gridConstraints);
        computeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                computeButtonActionPerformed(e);
            }
        });
        
        
        clearButton.setText("Clear");
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 3;
        getContentPane().add(clearButton, gridConstraints);
        clearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clearButtonActionPerformed(e);
            }
        });
        
        exitButton.setText("Exit");
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 3;
        getContentPane().add(exitButton, gridConstraints);
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exitButtonActionPerformed(e);     
            }
        });
        
        pack();
        
        
    }
    
    public void computeButtonActionPerformed(ActionEvent e)
    {           
        JFrame f;
        f = new JFrame();
        
        
        heightFeet = Integer.parseInt(heightFeetTextField.getText());
        heightInches = Integer.parseInt(heightInchesTextField.getText());
        weight = Double.parseDouble(weightTextField.getText());
        
        height = heightFeet * 12 + heightInches;
        bmi = (weight / (height * height)) * 703;
        bmiTextField.setText(String.format("%.2f", bmi));
        

        JOptionPane.showMessageDialog(f, "BMI: " + String.format("%.2f", bmi), "Body Mass Index", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void clearButtonActionPerformed(ActionEvent e)
    {
        heightFeetTextField.setText("");
        heightInchesTextField.setText("0");
        weightTextField.setText("");
        bmiTextField.setText("0");
    }
    
    public void exitButtonActionPerformed(ActionEvent e)
    {
        JFrame f;
        f = new JFrame();
        exitProgram(f);
    }
    
    public void exitForm(WindowEvent e)
    {
        JFrame f;
        f = new JFrame();
        exitProgram(f);
    }
    
    public void exitProgram(JFrame f)
    {
        JOptionPane.showMessageDialog(f, "Thank you for using the\nBMI Calculator", "Exiting...", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
    public static void main(String[] args)
    {
        new BMI().show();
    }
}