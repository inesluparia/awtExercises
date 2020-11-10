package com.kea;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class First extends Frame implements ActionListener {

    private Label header, l1, l2, l3, result, result1, result2;
    private TextField tf1, tf2, tf3;
    private Button calculate;
    private String address;
    private int husstand;
    private String cpr;
    String regexCPR;
    String regexHS;

    public static double calculate(int husstand) {
        return husstand * 1000;
    }

    public First() {
        regexCPR = "[0-9]{8}";
        regexHS = "[0-9]{1}";

        //closes the window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setSize(600, 600);//frame size 300 width and 300 height
        setLayout(null);//no layout manager
        setVisible(true);//now frame will be visible, by default not visible

        header = new Label("BEREGN DIN INDBOFORSIKRING HOS ALKA!");
        header.setBounds(40, 50, 400, 50);
        add(header);

        l1 = new Label("Indtast venligst din adresse");
        l1.setBounds(40, 100, 400, 50);
        add(l1);
        tf1 = new TextField();
        tf1.setBounds(40, 150, 400, 20);
        add(tf1);

        l2 = new Label("Indtast venligst antal personer i din husstand");
        l2.setBounds(40, 200, 400, 50);
        add(l2);
        tf2 = new TextField();
        tf2.setBounds(40, 250, 100, 20);
        add(tf2);

        l3 = new Label("Indtast venligst dit CPR nummer");
        l3.setBounds(40, 300, 400, 50);
        add(l3);
        tf3 = new TextField();
        tf3.setBounds(40, 350, 200, 20);
        add(tf3);

        calculate = new Button("BEREGN INDBOFORSIKRING");
        calculate.setBounds(200, 400, 200, 40);// setting button position
        add(calculate);
        calculate.addActionListener(this);

        result = new Label("");
        result.setBounds(160, 475, 400, 30);
        add(result);

        result1 = new Label("");
        result1.setBounds(200, 500, 400, 30);
        add(result1);

        result2 = new Label("");
        result2.setBounds(200, 525, 400, 30);
        add(result2);


    }

    public void actionPerformed(ActionEvent e) {
        address = tf1.getText();

        String typedHusstand = tf2.getText();
        if (typedHusstand.matches(regexHS)){
            husstand = Integer.parseInt(typedHusstand);
            result2.setText("");

        } else {
            result2.setText("Invalid antal husstand, venligst prøv igen.");
            calculate.setEnabled(true);
        }

        String typedCpr = tf3.getText();
        if (typedCpr.matches(regexCPR)){
            cpr = tf3.getText();
            result1.setText("");
        } else {
            result1.setText("Invalid CPR, venligst prøv igen.");
            calculate.setEnabled(true);
        }

        if (husstand != 0 && cpr != null)
            result.setText("DIN UFORPLIGTEDE BEREGNET PRIS ER: " + calculate(husstand) + " kr");
    }
}

