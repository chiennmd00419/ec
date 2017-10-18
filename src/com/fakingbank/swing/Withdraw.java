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
public class Withdraw {

    private JFrame frame;
    private JPanel panel;
    private JLabel lblNumber, lblBalance, lblWithdraw, lblWithdrawM;
    private JTextField txtNumber, txtBalance, txtWithdraw;
    private JTextArea txtAri;

    private JButton submit, exit;

    AccountModel model = new AccountModel();

    public Withdraw(String account) {
        Account acc = model.getAccount(account);
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setBounds(650, 70, 620, 635);

        panel = new JPanel();
        panel.setBounds(0, 0, 620, 635);
        panel = new ImagePanel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\cccc.png").getImage());

        lblNumber = new JLabel("Bank account");
        lblBalance = new JLabel("Account balance");
        lblWithdraw = new JLabel("Withdraw");
        lblWithdrawM = new JLabel();

        txtNumber = new JTextField();
        txtBalance = new JTextField();
        txtWithdraw = new JTextField();

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
        lblWithdraw.setBounds(100, 250, 150, 30);
        lblWithdrawM.setBounds(250, 280, 250, 30);

        txtNumber.setBounds(250, 50, 250, 30);
        txtBalance.setBounds(250, 100, 250, 30);
        txtWithdraw.setBounds(250, 250, 250, 30);

        txtAri.setBounds(100, 150, 400, 80);

        submit.setBounds(180, 330, 80, 30);
        exit.setBounds(320, 330, 80, 30);

        lblNumber.setFont(new Font("Arial", 2, 16));
        lblBalance.setFont(new Font("Arial", 2, 16));
        lblWithdraw.setFont(new Font("Arial", 2, 16));
        lblNumber.setForeground(Color.decode("#7CB342"));
        lblBalance.setForeground(Color.decode("#7CB342"));
        lblWithdraw.setForeground(Color.decode("#7CB342"));
        txtNumber.setBackground(Color.white);
        txtBalance.setBackground(Color.white);
        submit.setForeground(Color.white);
        exit.setForeground(Color.white);
        submit.setBackground(Color.decode("#7CB342"));
        exit.setBackground(Color.decode("#7CB342"));

        submit.addActionListener(new Withdraws());
        exit.addActionListener(new Exit());

        txtNumber.setEditable(false);
        txtBalance.setEditable(false);

        panel.add(lblNumber);
        panel.add(lblBalance);
        panel.add(lblWithdraw);
        panel.add(lblWithdrawM);
        panel.add(txtNumber);
        panel.add(txtBalance);
        panel.add(txtWithdraw);
        panel.add(txtAri);

        panel.add(submit);
        panel.add(exit);
        frame.add(panel);

        frame.add(panel);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    class Withdraws implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Account a = model.Number(txtNumber.getText());
                long b = a.getBalance() - Long.valueOf(txtWithdraw.getText());
//                System.out.println(a.getBalance());
//                System.out.println(Long.valueOf(txtWithdraw.getText()));
//                System.out.println(b);
                if (b >= 50000) {

                   //String number = txtNumber.getText();
                    //long qqq = Long.valueOf(txtWithdraw.getText());
                    model.withdraw((txtNumber.getText()), (Long.valueOf(txtWithdraw.getText())));
                    Account a1 = model.Number(txtNumber.getText());
                    txtBalance.setText(String.valueOf(a1.getBalance()) + "VNĐ");
                    JOptionPane.showMessageDialog(null, "withdraw money successfully");
                } else {
                    lblWithdrawM.setForeground(Color.red);
                    lblWithdrawM.setText("Account balance is not enough");
                }
            } catch (NumberFormatException ex) {
                lblWithdrawM.setForeground(Color.red);
                lblWithdrawM.setText("Please enter the correct amount");
            }
        }
    }

    class Exit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
        }

    }

    void Reset() {
        lblWithdrawM.setText("");
        txtWithdraw.setText("");

    }
}
