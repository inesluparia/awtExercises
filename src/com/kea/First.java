package com.kea;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class First extends Frame implements ActionListener {

    private Label header, l1, l2, l3, result;
    private TextField tf1, tf2, tf3;
    private Button calculate;
    private String address;
    private String husstand;
    private String cpr;

    public static double calculate(int husstand) {
        return husstand * 1000;
    }

    public First() {

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
        result.setBounds(160, 475, 400, 50);
        add(result);

    }

    public void actionPerformed(ActionEvent e) {
        address = tf1.getText();
        husstand = tf2.getText();
        cpr = tf3.getText();
        result.setText("DIN UFORPLIGTEDE BEREGNET PRIS ER: " + calculate(Integer.parseInt(husstand)) + " kr");

        //String regex = "^[0-3]{1}[0-9]{1}[0-1]{1}[0-2]{1}[0-9]{2}[0-9]{4}$";
        //if (!cpr.matches(regex))
        //    System.out.println("invalid CPR input");


    }
}

