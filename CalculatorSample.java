package Week_9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class CalculatorSample {
    private JTextField placeHolder;
    private String operator;
    private double firstNumber;

    public CalculatorSample() {
        JFrame fr = new JFrame();
        JPanel p = new JPanel();
        
        placeHolder = new JTextField(300);
        placeHolder.setEditable(false);
        
        fr.setTitle("My Calculator");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 300);
        fr.setLayout(new BorderLayout());

        p.setLayout(new GridLayout(4, 4));
        addButton(p, "7");
        addButton(p, "8");
        addButton(p, "9");
        addButton(p, "+");
        addButton(p, "4");
        addButton(p, "5");
        addButton(p, "6");
        addButton(p, "-");
        addButton(p, "1");
        addButton(p, "2");
        addButton(p, "3");
        addButton(p, "x");
        addButton(p, "0");
        addButton(p, "c");
        addButton(p, "=");
        addButton(p, "/");
        
        fr.add(placeHolder, BorderLayout.NORTH);
        fr.add(p, BorderLayout.CENTER);
        fr.setVisible(true);
    }

    private void addButton(JPanel panel, String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(text);
            }
        });
        panel.add(button);
    }

    private void handleButtonClick(String text) {
        switch (text) {
            case "+":
            case "-":
            case "x":
            case "/":
                operator = text;
                firstNumber = Double.parseDouble(placeHolder.getText());
                placeHolder.setText("");
                break;
            case "c":
                placeHolder.setText("");
                break;
            case "=":
                double secondNumber = Double.parseDouble(placeHolder.getText());
                double result = 0;
                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "x":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        result = firstNumber / secondNumber;
                        break;
                }
                placeHolder.setText(String.valueOf(result));
                break;
            default:
                placeHolder.setText(placeHolder.getText() + text);
                break;
        }
    }

    public static void main(String[] args) {
        CalculatorSample test = new CalculatorSample();
    }
}