/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fakingbank.swing;

import com.fakingbank.image.ImageLabel;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import util.Utility;

/**
 *
 * @author Lan
 */
public class LogInForm extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private JLabel lblAccount;
    private JLabel lblPassWord;
    private JTextField txtAccount;
    private JPasswordField txtPassWord;
    private JButton btnLogin;
    private JButton btnCreate;
    private JLabel lblTotalMessage;
    private JLabel lblAccountlMessage;
    private JLabel lblPassWordMessage;
    private JLabel icon;

    private AccountModel model = new AccountModel();
    AccountModel ac = new AccountModel();

    public LogInForm() {
      
        frame = new JFrame();
        frame.setSize(975, 640);
        frame.setLocationRelativeTo(null);
        icon = new JLabel();
        panel = new JPanel();
        panel = new ImagePanel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\img.sigin.png").getImage());
        icon = new ImageLabel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\logo.png").getImage());

        icon.setBounds(640, 100, 300, 180);
        lblAccount = new JLabel("Account");
        lblPassWord = new JLabel("Password");
        lblAccount.setFont(new Font("Arial", 2, 16));
        lblPassWord.setFont(new Font("Arial", 2, 16));
        txtAccount = new JTextField("nguyenngoc ");
        txtPassWord = new JPasswordField("12345678");
        btnLogin = new JButton("Login");
        btnCreate = new JButton("Create");
        lblTotalMessage = new JLabel();
        lblAccountlMessage = new JLabel();
        lblPassWordMessage = new JLabel();

        // Định vị toạ độ cho các component.  
        panel.setBounds(0, 0, 975, 640);
        lblAccount.setBounds(640, 300, 100, 40);
        lblPassWord.setBounds(640, 350, 100, 40);
        txtAccount.setBounds(720, 300, 200, 30);
        txtPassWord.setBounds(720, 350, 200, 30);
        btnLogin.setBounds(700, 430, 80, 30);
        btnCreate.setBounds(800, 430, 80, 30);

        btnLogin.setForeground(Color.WHITE);
        btnCreate.setForeground(Color.WHITE);
        lblAccount.setForeground(Color.decode("#7CB342"));
        lblPassWord.setForeground(Color.decode("#7CB342"));
        btnLogin.setBackground(Color.decode("#7CB342"));
        btnCreate.setBackground(Color.decode("#7CB342"));

        lblTotalMessage.setBounds(700, 265, 300, 40);
        lblAccountlMessage.setBounds(720, 320, 150, 30);
        lblPassWordMessage.setBounds(720, 370, 150, 30);

        btnLogin.addActionListener(new LoginHandle());
        btnCreate.addActionListener(new Create());

        frame.add(this.panel);
        panel.add(this.lblAccount);
        panel.add(this.lblPassWord);
        panel.add(this.txtAccount);
        panel.add(this.txtPassWord);
        panel.add(this.btnLogin);
        panel.add(this.btnCreate);
        panel.add(this.lblTotalMessage);
        panel.add(this.lblAccountlMessage);
        panel.add(this.lblPassWordMessage);
        panel.add(icon);
        panel.setLayout(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    class LoginHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String account = txtAccount.getText();
            String password = new String(txtPassWord.getPassword());
            System.out.println(btnLogin.getText());

            HashMap<String, String> errors = new FormHandle().validateLogin(account, password);
            if (errors.size() == 0) {
                resetMessage();
                int lAccount = account.length();
                int lPassword = password.length();
                if ((lAccount >= 6) == false) {
                    lblAccountlMessage.setForeground(Color.red);
                    lblAccountlMessage.setText("Account too short");
                }
                if ((lPassword >= 6) == false) {
                    lblPassWordMessage.setForeground(Color.red);
                    lblPassWordMessage.setText("Password too short");
                }

                if (((lAccount >= 6) == true) && ((lPassword >= 6) == true)) {
                    Account acc = model.checkAuthentication(account, Utility.digestPassword(password));
                    if (acc == null) {
                        JOptionPane.showMessageDialog(null, "Account information is invalid.");
                    } else {
                       frame.setVisible(false);
                        MenuBank ff = new MenuBank(txtAccount.getText());
                    }
                }
            } else {
                showError(errors);
            }

        }

    }

    class Create implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            CreateAccount createAccount = new CreateAccount();

        }

    }

    private void resetMessage() {
        lblTotalMessage.setText("");
        lblAccountlMessage.setText("");
        lblPassWordMessage.setText("");

    }

    private void showError(HashMap<String, String> errors) {
        lblTotalMessage.setForeground(Color.decode("#E64A19"));
        lblTotalMessage.setText("*Enter the full information");
        if (errors.containsKey("txtAccount")) {
            lblAccountlMessage.setForeground(Color.decode("#E64A19"));
            lblAccountlMessage.setText(errors.get("txtAccount"));
        } else {
            lblAccountlMessage.setForeground(Color.green);
            lblAccountlMessage.setText("Valid");

        }
        if (errors.containsKey("txtPassword")) {
            lblPassWordMessage.setForeground(Color.decode("#E64A19"));
            lblPassWordMessage.setText(errors.get("txtPassword"));
        } else {
            lblPassWordMessage.setForeground(Color.green);
            lblPassWordMessage.setText("Valid");
        }
    }
    }
