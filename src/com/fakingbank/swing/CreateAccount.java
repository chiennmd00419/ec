/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fakingbank.swing;

import com.fakingbank.entity.Account;
import com.fakingbank.entity.User;
import com.fakingbank.model.AccountModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import util.Utility;

/**
 *
 * @author Lan
 */
public class CreateAccount {

    private JFrame frame;
    private JPanel panel;
    
    private JLabel lblAccount;
    private JLabel lblPassword;
    private JLabel lblPassword1;
    private JLabel lblIdentifyCard;
    private JLabel lblName;
    private JLabel lblEmail;
    private JLabel lblPhone;
    private JLabel lblBirthday;
    private JLabel lblGender;
    private JLabel lblAddress;

    private JLabel lblAccountM;
    private JLabel lblPasswordM;
    private JLabel lblPassword1M;
    private JLabel lblIdentifyCardM;
    private JLabel lblNameM;
    private JLabel lblEmailM;
    private JLabel lblPhoneM;
    private JLabel lblBirthdayM;
    private JLabel lblAddressM;

    private JTextField txtAccount;
    private JPasswordField txtPassword;
    private JPasswordField txtPassword1;
    private JTextField txtIdentifyCard;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    //private JTextField txtBirthday;
    //private JTextField txtGender;
    private JTextField txtAddress;

    private JRadioButton xx;
    private JRadioButton xy;

    public JComboBox day;
    public JComboBox month;
    public JComboBox year;
    private JComboBox gender;

    private JButton create;
    private JButton login;
    private JTextArea notification;
    AccountModel model = new AccountModel();
    FormHandle handle = new FormHandle();

    public CreateAccount() {
        frame = new JFrame();
        frame.setSize(980, 640);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel = new ImagePanel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\gkgkk.png").getImage());
        lblAccount = new JLabel("Account");
        lblPassword = new JLabel("Password");
        lblPassword1 = new JLabel("Retype password");
        lblIdentifyCard = new JLabel("IdentifyCard");
        lblName = new JLabel("Name");
        lblEmail = new JLabel("Email");
        lblPhone = new JLabel("Phone");
        lblBirthday = new JLabel("Birthday");
        lblGender = new JLabel("Gender");
        lblAddress = new JLabel("Address");

        txtAccount = new JTextField();
        txtPassword = new JPasswordField();
        txtPassword1 = new JPasswordField();
        txtIdentifyCard = new JTextField();
        txtName = new JTextField();
        txtEmail = new JTextField();
        txtPhone = new JTextField();
        //txtBirthday = new JTextField();
        //txtGender = new JTextField();
        txtAddress = new JTextField();

        lblAccountM = new JLabel();
        lblPasswordM = new JLabel();
        lblPassword1M = new JLabel();
        lblNameM = new JLabel();
        lblEmailM = new JLabel();
        lblPhoneM = new JLabel();
        lblBirthdayM = new JLabel();
        lblAddressM = new JLabel();
        lblIdentifyCardM = new JLabel();

        create = new JButton("Create");
        login = new JButton("Login");
        notification = new JTextArea();

        panel.setBounds(0, 0, 980, 640);

        lblAccount.setBounds(100, 100, 100, 30);
        lblPassword.setBounds(100, 150, 100, 30);
        lblPassword1.setBounds(100, 200, 100, 30);

        lblAccountM.setBounds(200, 125, 150, 30);
        lblPasswordM.setBounds(200, 175, 150, 30);
        lblPassword1M.setBounds(200, 225, 150, 30);

        lblName.setBounds(500, 100, 100, 30);
        lblEmail.setBounds(500, 150, 100, 30);
        lblPhone.setBounds(500, 200, 100, 30);
        lblBirthday.setBounds(500, 250, 100, 30);
        lblGender.setBounds(500, 300, 100, 30);
        lblAddress.setBounds(500, 350, 100, 30);
        lblIdentifyCard.setBounds(500, 400, 100, 30);

        lblNameM.setBounds(600, 125, 150, 30);
        lblEmailM.setBounds(600, 175, 150, 30);
        lblPhoneM.setBounds(600, 225, 150, 30);
        lblBirthdayM.setBounds(600, 275, 150, 30);
        lblAddressM.setBounds(600, 375, 150, 30);
        lblIdentifyCardM.setBounds(600, 425, 150, 30);

        txtAccount.setBounds(200, 100, 250, 30);
        txtPassword.setBounds(200, 150, 250, 30);
        txtPassword1.setBounds(200, 200, 250, 30);
        txtName.setBounds(600, 100, 250, 30);
        txtEmail.setBounds(600, 150, 250, 30);
        txtPhone.setBounds(600, 200, 250, 30);
        txtAddress.setBounds(600, 350, 250, 30);
        txtIdentifyCard.setBounds(600, 400, 250, 30);

        create.setBounds(200, 400, 100, 30);
        login.setBounds(320, 400, 100, 30);
        notification.setBounds(100, 280, 350, 100);
        notification.setEditable(false);
        notification.setText("Enter full information \n"
                + "On the other hand, we denounce with righteous indignation\n"
                + "demoralized by the charms of pleasure of the moment, so \n"
                + "they cannot foresee the pain and trouble that are bound");

        //notification.setBackground(Color.decode("#dddddd"));
        lblAccount.setFont(new Font("Arial", 2, 16));
        lblPassword.setFont(new Font("Arial", 2, 16));
        lblPassword1.setFont(new Font("Arial", 2, 16));
        lblName.setFont(new Font("Arial", 2, 16));
        lblEmail.setFont(new Font("Arial", 2, 16));
        lblPhone.setFont(new Font("Arial", 2, 16));
        lblBirthday.setFont(new Font("Arial", 2, 16));
        lblGender.setFont(new Font("Arial", 2, 16));
        lblAddress.setFont(new Font("Arial", 2, 16));
        lblIdentifyCard.setFont(new Font("Arial", 2, 16));

        lblAccount.setForeground(Color.decode("#2E7D32"));
        lblPassword.setForeground(Color.decode("#2E7D32"));
        lblPassword1.setForeground(Color.decode("#2E7D32"));
        lblName.setForeground(Color.decode("#2E7D32"));
        lblEmail.setForeground(Color.decode("#2E7D32"));
        lblPhone.setForeground(Color.decode("#2E7D32"));
        lblBirthday.setForeground(Color.decode("#2E7D32"));
        lblGender.setForeground(Color.decode("#2E7D32"));
        lblAddress.setForeground(Color.decode("#2E7D32"));
        lblIdentifyCard.setForeground(Color.decode("#2E7D32"));

        String[] g = {"Male", "Female", "Other gender"};
        gender = new JComboBox(g);
        gender.setBounds(600, 300, 250, 30);
        gender.setFont(new Font("Arial", 2, 14));
        gender.setBackground(Color.WHITE);
        gender.setForeground(Color.decode("#2E7D32"));
        panel.add(gender);

        String[] d = new String[32];
        for (int i = 0; i < 32; i++) {
            d[0] = "Day";
            String strD = String.valueOf((i));
            d[i] = strD;
        }
        day = new JComboBox(d);
        day.setBounds(600, 250, 65, 30);
        day.setFont(new Font("Arial", 2, 14));
        day.setBackground(Color.WHITE);
        day.setForeground(Color.decode("#2E7D32"));
        panel.add(day);

        String[] m = new String[13];
        for (int i = 0; i < 13; i++) {
            m[0] = "Month";
            String strM = String.valueOf((i));
            m[i] = strM;
        }
        month = new JComboBox(m);
        month.setBounds(685, 250, 65, 30);
        month.setFont(new Font("Arial", 2, 14));
        month.setBackground(Color.WHITE);
        month.setForeground(Color.decode("#2E7D32"));
        panel.add(month);

        String[] y = new String[15];
        for (int i = 0; i < 15; i++) {
            y[0] = "Year";
            String strY = String.valueOf((i + 1985));
            y[i] = strY;
        }
        year = new JComboBox(y);
        year.setBounds(770, 250, 80, 30);
        year.setFont(new Font("Arial", 2, 14));
        year.setBackground(Color.WHITE);
        year.setForeground(Color.decode("#2E7D32"));
        panel.add(year);

        create.addActionListener(new Create());
        login.addActionListener(new Login());

        panel.add(lblAccount);
        panel.add(lblPassword);
        panel.add(lblPassword1);
        panel.add(lblIdentifyCard);
        panel.add(lblName);
        panel.add(lblEmail);
        panel.add(lblPhone);
        panel.add(lblBirthday);
        panel.add(lblGender);
        panel.add(lblAddress);

        panel.add(lblAccountM);
        panel.add(lblPasswordM);
        panel.add(lblPassword1M);
        panel.add(lblIdentifyCardM);
        panel.add(lblNameM);
        panel.add(lblEmailM);
        panel.add(lblPhoneM);
        panel.add(lblBirthdayM);
        panel.add(lblAddressM);

        panel.add(txtAccount);
        panel.add(txtPassword);
        panel.add(txtPassword1);
        panel.add(txtName);
        panel.add(txtEmail);
        panel.add(txtPhone);
        panel.add(txtAddress);
        panel.add(txtIdentifyCard);
        panel.add(create);
        panel.add(login);
        panel.add(notification);

        frame.add(panel);

        panel.setLayout(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    class Create implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            resetMessage();
            String account = txtAccount.getText();
            String password = new String(txtPassword.getPassword());
            String password1 = new String(txtPassword1.getPassword());

            String name = txtName.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();

            String address = txtAddress.getText();
            String identifyCard = txtIdentifyCard.getText();
            String gender1 = gender.getSelectedItem().toString();
            if (((day.getSelectedItem().toString()).equals("Day") == true) || ((month.getSelectedItem().toString()).equals("Month") == true) || ((year.getSelectedItem().toString()).equals("Year") == true)) {
                lblBirthdayM.setForeground(Color.red);
                lblBirthdayM.setText("Choice birthdat");
            }
            String strDate1 = day.getSelectedItem().toString() + "/" + month.getSelectedItem().toString() + "/" + year.getSelectedItem().toString();

            Account acc = model.getAccount(account);

            if (acc == null) {
                Account ac = new Account();
                ac.setAccount(account);
                ac.setPassword(Utility.digestPassword(new String(txtPassword.getPassword())));
                ac.setUserIdentifyCard(identifyCard);

                User us = new User();
                us.setIdentifyCard(identifyCard);
                us.setFullName(name);
                us.setEmail(email);
                us.setPhone(phone);
                us.setBirthDay(strDate1);
                us.setGender(gender1);
                us.setAddress(address);

                HashMap<String, String> errors = new FormHandle().validateCreate(account, password, password1, name, email, phone, address, identifyCard);
                int result = 999;
                if (errors.size() == 0) {
                    resetMessage();
                    result = JOptionPane.showConfirmDialog(null, "Create account");
                    if (result == 0) {
                        int lAccount = account.length();
                        int lPassword = password.length();
                        if ((lAccount >= 6) == false) {
                            lblAccountM.setForeground(Color.red);
                            lblAccountM.setText("Account too short");
                        }
                        if ((lPassword >= 6) == false) {
                            lblPasswordM.setForeground(Color.red);
                            lblPasswordM.setText("Password too short");
                        }
                        if (password.equals(password1) == false) {
                            lblPassword1M.setForeground(Color.red);
                            lblPassword1M.setText("password incorrect");
                        }
                        if (handle.vaildateEmail(email) == false) {
                            lblEmailM.setForeground(Color.red);
                            lblEmailM.setText("Invalid email");
                        }
                        if (handle.vaildatePhone(phone) == false) {
                            lblPhoneM.setForeground(Color.red);
                            lblPhoneM.setText("Phonenumber not valid");
                        }

                        if (((lAccount >= 6) == true) && ((lPassword >= 6) == true) && (password.equals(password1) == true) && (handle.vaildateEmail(email) == true) && (handle.vaildatePhone(phone) == true) && ((day.getSelectedItem().toString()).equals("Day") == false) && ((month.getSelectedItem().toString()).equals("Month") == false) && ((year.getSelectedItem().toString()).equals("Year") == false)) {
                            model.insert(ac);
                            model.insert1(us);
                            notification.setText("Create account" + txtAccount.getText() + "\n"
                                    + "Password : *********\n"
                                    + "demoralized by the charms of pleasure of the moment, so \n"
                                    + "they cannot foresee the pain and trouble that are bound");

                        } else {
                            JOptionPane.showMessageDialog(null, "Enter full information");
                        }

                    }
                } else {
                    showError(errors);
                }
            } else {
                lblAccountM.setForeground(Color.red);
                lblAccountM.setText("Account exists");
            }

        }
    }

    class Login implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LogInForm logInForm = new LogInForm();
            frame.setVisible(false);

        }

    }

    private void showError(HashMap<String, String> errors) {

        if (errors.containsKey("txtAccount")) {
            lblAccountM.setForeground(Color.decode("#E64A19"));
            lblAccountM.setText(errors.get("txtAccount"));
        } else {
            lblAccountM.setForeground(Color.green);
            lblAccountM.setText("Valid");
        }
        if (errors.containsKey("txtPassword")) {
            lblPasswordM.setForeground(Color.decode("#E64A19"));
            lblPasswordM.setText(errors.get("txtPassword"));
        } else {
            lblPasswordM.setForeground(Color.green);
            lblPasswordM.setText("Valid");
        }
        if (errors.containsKey("txtPassword1")) {
            lblPassword1M.setForeground(Color.decode("#E64A19"));
            lblPassword1M.setText(errors.get("txtPassword1"));
        } else {
            lblPassword1M.setForeground(Color.green);
            lblPassword1M.setText("Valid");
        }
        if (errors.containsKey("txtName")) {
            lblNameM.setForeground(Color.decode("#E64A19"));
            lblNameM.setText(errors.get("txtName"));
        } else {
            lblNameM.setForeground(Color.green);
            lblNameM.setText("Valid");
        }
        if (errors.containsKey("txtEmail")) {
            lblEmailM.setForeground(Color.decode("#E64A19"));
            lblEmailM.setText(errors.get("txtEmail"));
        } else {
            lblEmailM.setForeground(Color.green);
            lblEmailM.setText("Valid");
        }
        if (errors.containsKey("txtPhone")) {
            lblPhoneM.setForeground(Color.decode("#E64A19"));
            lblPhoneM.setText(errors.get("txtPhone"));
        } else {
            lblPhoneM.setForeground(Color.green);
            lblPhoneM.setText("Valid");
        }
        if (errors.containsKey("txtAddress")) {
            lblAddressM.setForeground(Color.decode("#E64A19"));
            lblAddressM.setText(errors.get("txtAddress"));
        } else {
            lblAddressM.setForeground(Color.green);
            lblAddressM.setText("Valid");
        }
        if (errors.containsKey("txtIdentifyCard")) {
            lblIdentifyCardM.setForeground(Color.decode("#E64A19"));
            lblIdentifyCardM.setText(errors.get("txtIdentifyCard"));
        } else {
            lblIdentifyCardM.setForeground(Color.green);
            lblIdentifyCardM.setText("Valid");
        }
    }

    private void resetMessage() {
        lblAccountM.setText("");
        lblPasswordM.setText("");
        lblPassword1M.setText("");
        lblNameM.setText("");
        lblEmailM.setText("");
        lblPhoneM.setText("");
        lblAddressM.setText("");
        lblIdentifyCardM.setText("");

    }

    private void reset() {
        txtAccount.setText("");
        txtPassword.setText("");
        txtPassword1.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        txtIdentifyCard.setText("");

    }

    public static void main(String[] args) {
        CreateAccount qq = new CreateAccount();
    }
}
