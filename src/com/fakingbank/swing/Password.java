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
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import util.Utility;

/**
 *
 * @author Lan
 */
public class Password {

    private JFrame frame;
    private JPanel panel;
    private JLabel lblPassword1, lblPassword2, lblPassword3;
    private JLabel lblPassword1M, lblPassword2M, lblPassword3M;
    private JPasswordField txtPass1, txtPass2, txtPass3;

    private JButton submit, exit;
    String a, b, d;
    long c;
    AccountModel model = new AccountModel();

    public Password(String account) {

        Account acc = model.getAccount(account);

        a = acc.getAccount();
        b = acc.getNumber();
        c = acc.getBalance();
        d = acc.getUserIdentifyCard();

        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setBounds(650, 70, 620, 635);

        panel = new JPanel();
        panel.setBounds(0, 0, 620, 635);
        panel = new ImagePanel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\cccc.png").getImage());

        lblPassword1 = new JLabel("Password current");
        lblPassword2 = new JLabel("Password new");
        lblPassword3 = new JLabel("Retype password");

        lblPassword1M = new JLabel();
        lblPassword2M = new JLabel();
        lblPassword3M = new JLabel();

        txtPass1 = new JPasswordField();
        txtPass2 = new JPasswordField();
        txtPass3 = new JPasswordField();

        submit = new JButton("Oke");
        exit = new JButton("Exit");

        lblPassword1.setBounds(100, 50, 150, 30);
        lblPassword2.setBounds(100, 100, 150, 30);
        lblPassword3.setBounds(100, 150, 150, 30);

        lblPassword1M.setBounds(250, 80, 150, 30);
        lblPassword2M.setBounds(250, 130, 150, 30);
        lblPassword3M.setBounds(250, 180, 150, 30);

        txtPass1.setBounds(250, 50, 250, 30);
        txtPass2.setBounds(250, 100, 250, 30);
        txtPass3.setBounds(250, 150, 250, 30);

        submit.setBounds(180, 330, 80, 30);
        exit.setBounds(320, 330, 80, 30);

        lblPassword1.setFont(new Font("Arial", 2, 16));
        lblPassword2.setFont(new Font("Arial", 2, 16));
        lblPassword3.setFont(new Font("Arial", 2, 16));
        lblPassword1.setForeground(Color.decode("#7CB342"));
        lblPassword2.setForeground(Color.decode("#7CB342"));
        txtPass3.setForeground(Color.decode("#7CB342"));

        submit.setForeground(Color.white);
        exit.setForeground(Color.white);
        submit.setBackground(Color.decode("#7CB342"));
        exit.setBackground(Color.decode("#7CB342"));

        submit.addActionListener(new changePassword());

        panel.add(lblPassword1);
        panel.add(lblPassword2);
        panel.add(lblPassword3);

        panel.add(lblPassword1M);
        panel.add(lblPassword2M);
        panel.add(lblPassword3M);

        panel.add(txtPass1);
        panel.add(txtPass2);
        panel.add(txtPass3);

        panel.add(submit);
        panel.add(exit);
        frame.add(panel);

        frame.add(panel);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    class changePassword implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            
            System.out.println(a);
            

//            String password1 = new String(txtPass1.getPassword());
//            String password2 = new String(txtPass2.getPassword());
//            String password3 = new String(txtPass3.getPassword());
//            int et = password2.length();
//
//            HashMap<String, String> errors = new FormHandle().validatePassword(password1, password2, password3);
//            int result = 999;
//            if (errors.size() == 0) {
//                resetMessage();
//                Account acc = model.checkAuthentication(a, Utility.digestPassword(Utility.digestPassword(password1)));
//                System.out.println(a);
//           
//                if (result == 0) {
//                    if (acc != null) {
//                        Account ee = new Account();
//                        ee.setAccount(a);
//                        ee.setNumber(b);
//                        ee.setPassword(Utility.digestPassword(password1));
//                        ee.setBalance(c);
//                        ee.setUserIdentifyCard(d);
//                        model.ChangePass(ee);
//                        System.out.println("tahnh cong");
//
//                    } else {
//
//                        lblPassword1M.setForeground(Color.red);
//                        lblPassword1M.setText("sai mk");
//                    }
//                }
//
//            } else {
//                showError(errors);
//            }

        }

    }

    class Exit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
        }

    }

    private void showError(HashMap<String, String> errors) {

        if (errors.containsKey("txtPass1")) {
            lblPassword1M.setForeground(Color.decode("#E64A19"));
            lblPassword1M.setText(errors.get("txtPass1"));
        } else {
            lblPassword1M.setForeground(Color.green);
            lblPassword1M.setText("Valid");

        }
        if (errors.containsKey("txtPass2")) {
            lblPassword2M.setForeground(Color.decode("#E64A19"));
            lblPassword2M.setText(errors.get("txtPass2"));
        } else {
            lblPassword2M.setForeground(Color.green);
            lblPassword2M.setText("Valid");

        }
        if (errors.containsKey("txtPass3")) {
            lblPassword3M.setForeground(Color.decode("#E64A19"));
            lblPassword3M.setText(errors.get("txtPass3"));
        } else {
            lblPassword3M.setForeground(Color.green);
            lblPassword3M.setText("Valid");

        }

    }

    void resetMessage() {
        lblPassword1M.setText("");
        lblPassword2M.setText("");
        lblPassword3M.setText("");
    }
}
