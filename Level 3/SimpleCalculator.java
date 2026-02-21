// SimpleCalculator.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator implements ActionListener{

    // GUI components
    JFrame frame;
    JTextField textField;
    String operator = "";
    double firstNum = 0;

    // Constructor to set up the GUI
    public SimpleCalculator(){
        // Initialize the frame
        frame = new JFrame("Calculator");
        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 20));

        // Create panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // Define buttons
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Add buttons to panel
        for(String b : buttons){
            JButton button = new JButton(b);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            panel.add(button);
        }

        // Set up frame layout
        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Finalize frame
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Override action method for button clicks
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();

        try{
            // Handle button clicks
            if("0123456789.".contains(command)){
                textField.setText(textField.getText() + command);
            } else if("+-*/".contains(command)){
                firstNum = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("");
            } else if("=".equals(command)){
                double secondNum = Double.parseDouble(textField.getText());
                double result = 0;

                switch(operator){
                    case "+" -> result = firstNum + secondNum;
                    case "-" -> result = firstNum - secondNum;
                    case "*" -> result = firstNum * secondNum;
                    case "/" -> result = firstNum / secondNum;
                }
                textField.setText(String.valueOf(result));
            }
        } catch(Exception ex){
            textField.setText("Error: " + ex.getMessage());
        }
    }

    // Calling calculate method
    public static void main(String[] args){
        new SimpleCalculator();
    }
}