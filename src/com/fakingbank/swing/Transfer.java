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
import javax.swing.JTextField;

/**
 *
 * @author Lan
 */
public class Transfer {

    private JFrame frame;
    private JPanel panel;
    private JLabel lblNumber, lblBalance, lblNumber1, lblNumber1M, lblTransfer, lblTransferM;
    private JTextField txtNumber, txtBalance, txtNumber1, txtTransfer;

    private JButton submit, exit;
    AccountModel model = new AccountModel();

    public Transfer(String account) {
        Account acc = model.getAccount(account);

        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setBounds(650, 70, 620, 635);

        panel = new JPanel();
        panel.setBounds(0, 0, 620, 635);
        panel = new ImagePanel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\cccc.png").getImage());

        lblNumber = new JLabel("Bank account");
        lblBalance = new JLabel("Account balance");
        lblNumber1 = new JLabel("Receiving account");
        lblNumber1M = new JLabel();
        lblTransfer = new JLabel("Transfer");
        lblTransferM = new JLabel();

        txtNumber = new JTextField();
        txtBalance = new JTextField();
        txtNumber1 = new JTextField("9a64d9e5-f0c1-48f5-b849-61e7f071e7e2");
        txtTransfer = new JTextField();

        txtNumber.setText(acc.getNumber());
        txtBalance.setText(String.valueOf(acc.getBalance()) + "VNĐ");

        submit = new JButton("Oke");
        exit = new JButton("Exit");

        lblNumber.setBounds(100, 50, 150, 30);
        lblBalance.setBounds(100, 100, 150, 30);
        lblNumber1.setBounds(100, 150, 150, 30);
        lblNumber1M.setBounds(250, 180, 150, 30);
        lblTransfer.setBounds(100, 250, 150, 30);
        lblTransferM.setBounds(250, 280, 150, 30);

        txtNumber.setBounds(250, 50, 250, 30);
        txtBalance.setBounds(250, 100, 250, 30);
        txtNumber1.setBounds(250, 150, 250, 30);
        txtTransfer.setBounds(250, 250, 250, 30);

        submit.setBounds(180, 330, 80, 30);
        exit.setBounds(320, 330, 80, 30);

        lblNumber.setFont(new Font("Arial", 2, 16));
        lblNumber1.setFont(new Font("Arial", 2, 16));
        lblBalance.setFont(new Font("Arial", 2, 16));
        lblTransfer.setFont(new Font("Arial", 2, 16));
        lblNumber.setForeground(Color.decode("#7CB342"));
        lblNumber1.setForeground(Color.decode("#7CB342"));
        lblBalance.setForeground(Color.decode("#7CB342"));
        lblTransfer.setForeground(Color.decode("#7CB342"));
        txtNumber.setBackground(Color.white);
        txtBalance.setBackground(Color.white);
        submit.setForeground(Color.white);
        exit.setForeground(Color.white);
        submit.setBackground(Color.decode("#7CB342"));
        exit.setBackground(Color.decode("#7CB342"));

        txtNumber.setEditable(false);
        txtBalance.setEditable(false);

        submit.addActionListener(new Transfers());

        panel.add(lblNumber);
        panel.add(lblNumber1);
        panel.add(lblNumber1M);
        panel.add(lblBalance);
        panel.add(lblTransfer);
        panel.add(lblTransferM);
        panel.add(txtNumber);
        panel.add(txtNumber1);
        panel.add(txtBalance);
        panel.add(txtTransfer);

        panel.add(submit);
        panel.add(exit);
        frame.add(panel);

        frame.add(panel);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    class Transfers implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // String number = txtNumber.getText();
            //String number1 = txtNumber1.getText();
            try {
                Account a = model.Number(txtNumber1.getText());
                Account b = model.Number(txtNumber.getText());
                long c = b.getBalance() - Long.valueOf(txtTransfer.getText());

                if (a == null) {
                    lblNumber1M.setForeground(Color.red);
                    lblNumber1M.setText("Account does not exist");
                }

                if ((a != null) && (c >= 50000)) {
                    //long qqq = Long.valueOf(txtTransfer.getText());
                    model.transfer(Long.valueOf(txtTransfer.getText()), txtNumber.getText(), txtNumber1.getText());
                    Account a1 = model.Number(txtNumber.getText());
                    txtBalance.setText(String.valueOf(a1.getBalance()) + "VNĐ");
                    JOptionPane.showMessageDialog(null, "successfully");
                }

            } catch (NumberFormatException ex) {
                lblTransferM.setForeground(Color.red);
                lblTransferM.setText("Please enter the correct amount");
            }
        }
    }
}
