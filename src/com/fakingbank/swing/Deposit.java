/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fakingbank.swing;

import com.fakingbank.entity.Account;
import com.fakingbank.model.AccountModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Lan
 */
public class Deposit {

    private JFrame frame;
    private JPanel panel;
    private JLabel lblNumber, lblBalance, lblDeposits, lblDepositM;
    private JTextField txtNumber, txtBalance, txtDeposits;
    private JTextArea txtAri;

    private JButton submit, exit;
    String a;
    AccountModel model = new AccountModel();

    public Deposit(String account) {
        a = account;
        Account acc = model.getAccount(account);

        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setBounds(650, 70, 620, 635);

        panel = new JPanel();
        panel.setBounds(0, 0, 620, 635);
        panel = new ImagePanel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\cccc.png").getImage());

        lblNumber = new JLabel("Bank account");
        lblBalance = new JLabel("Account balance");
        lblDeposits = new JLabel("Deposits");
        lblDepositM = new JLabel();

        txtNumber = new JTextField();
        txtBalance = new JTextField();
        txtDeposits = new JTextField();

        txtNumber.setText(acc.getNumber());
        txtBalance.setText(String.valueOf(acc.getBalance()) + "VNĐ");

        submit = new JButton("Oke");
        exit = new JButton("Exit");

        txtAri = new JTextArea("Contrary to popular belief, Lorem Ipsum is not simply random text. \n"
                + " It has roots in a piece of classical Latin literature from 45 BC, making it over\n"
                + " 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in\n"
                + " Virginia, looked up one of the more obscure Latin words");

        lblNumber.setBounds(100, 50, 150, 30);
        lblBalance.setBounds(100, 100, 150, 30);
        lblDeposits.setBounds(100, 250, 150, 30);
        lblDepositM.setBounds(250, 290, 250, 30);

        txtNumber.setBounds(250, 50, 250, 30);
        txtBalance.setBounds(250, 100, 250, 30);
        txtDeposits.setBounds(250, 250, 250, 30);

        txtAri.setBounds(100, 150, 400, 80);

        submit.setBounds(180, 330, 80, 30);
        exit.setBounds(320, 330, 80, 30);

        lblNumber.setFont(new Font("Arial", 2, 16));
        lblBalance.setFont(new Font("Arial", 2, 16));
        lblDeposits.setFont(new Font("Arial", 2, 16));
        lblNumber.setForeground(Color.decode("#7CB342"));
        lblBalance.setForeground(Color.decode("#7CB342"));
        lblDeposits.setForeground(Color.decode("#7CB342"));
        txtNumber.setBackground(Color.white);
        txtBalance.setBackground(Color.white);
        submit.setForeground(Color.white);
        exit.setForeground(Color.white);
        submit.setBackground(Color.decode("#7CB342"));
        exit.setBackground(Color.decode("#7CB342"));

        txtNumber.setEditable(false);
        txtBalance.setEditable(false);

        submit.addActionListener(new Deposits());
        exit.addActionListener(new Exit());

        panel.add(lblNumber);
        panel.add(lblBalance);
        panel.add(lblDeposits);
        panel.add(lblDepositM);
        panel.add(txtNumber);
        panel.add(txtBalance);
        panel.add(txtDeposits);
        panel.add(txtAri);

        panel.add(submit);
        panel.add(exit);
        frame.add(panel);

        frame.add(panel);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    class Deposits implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           lblDepositM.setText("");
            if ((txtDeposits.getText()).equals("") == false) {

                try {
//                    String number = txtNumber.getText();
//                    long balance = Long.valueOf(txtDeposits.getText());
                    model.deposit((txtNumber.getText()), (Long.valueOf(txtDeposits.getText())));
                    Account a1 = model.Number(txtNumber.getText());
                    txtBalance.setText(String.valueOf(a1.getBalance()) + "VNĐ");
                    txtDeposits.setText("");
                    JOptionPane.showMessageDialog(null, "Transfer money successfully");
                } catch (NumberFormatException ex) {
                    lblDepositM.setForeground(Color.red);
                    lblDepositM.setText("Please enter the correct amount");
                }

            } else {
                lblDepositM.setForeground(Color.red);
                lblDepositM.setText("Please enter the correct amount");
            }
        }
    }

    class Exit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
        }

    }


}
