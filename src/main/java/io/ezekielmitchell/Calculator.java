package io.ezekielmitchell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField field;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Courier", Font.PLAIN, 12);

    double num1=0, num2=0, result=0;
    char operator;

    public Calculator() {

        frame = new JFrame("Ezekiel's Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        field = new JTextField();
        field.setBounds(50, 25, 300, 50);
        field.setFont(myFont);
        field.setEditable(false); // removes editing of text box

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (JButton functionButton : functionButtons) {
            functionButton.addActionListener(this);
            functionButton.setFont(myFont);
            functionButton.setFocusable(false);
        }

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,5,5));
//        panel.setBackground(Color.GRAY);
        for (JButton numberButton : numberButtons) {
            panel.add(numberButton);
        }

        for (int i = 0; i < 6; i++) {
            panel.add(functionButtons[i]);
        }

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(field);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // show selected numbers in text box
        for (int i = 0; i < 10; i++) {

            if (e.getSource() == numberButtons[i]) {
                field.setText(field.getText().concat(String.valueOf(i)));
            }
        }

        // show decButton
        if (e.getSource() == decButton) {
            field.setText(field.getText().concat("."));
        }

        // clear text box
        if (e.getSource() == clrButton) {
            field.setText("");
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

    }

}
