/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fakingbank.swing;

import com.fakingbank.entity.User;
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
import javax.swing.JTextField;

/**
 *
 * @author Lan
 */
public class Information {

    private JFrame frame;
    private JPanel panel;

    private JLabel lblIdentifyCard;
    private JLabel lblName;
    private JLabel lblEmail;
    private JLabel lblPhone;
    private JLabel lblBirthday;
    private JLabel lblGender;
    private JLabel lblAddress;

    private JTextField txtIdentifyCard;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtBirthday;
    private JTextField txtGender;
    private JTextField txtAddress;

    private JLabel lblNameM;
    private JLabel lblEmailM;
    private JLabel lblPhoneM;
    private JLabel lblBirthdayM;
    private JLabel lblGenderM;
    private JLabel lblAddressM;

    private JButton exit;
    private JButton login;
   
    AccountModel ac = new AccountModel();
    FormHandle handle = new FormHandle();
    AccountModel model = new AccountModel();

    public Information(String identifyCard) {
        User us = ac.getIdentify(identifyCard);

        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setBounds(650, 70, 620, 635);

        panel = new JPanel();
        panel.setBounds(0, 0, 620, 635);
        panel = new ImagePanel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\panel2.png").getImage());

        lblIdentifyCard = new JLabel("IdentifyCard");
        lblName = new JLabel("Name");
        lblEmail = new JLabel("Email");
        lblPhone = new JLabel("Phone");
        lblBirthday = new JLabel("Birthday");
        lblGender = new JLabel("Gender");
        lblAddress = new JLabel("Address");

        lblNameM = new JLabel();
        lblEmailM = new JLabel();
        lblPhoneM = new JLabel();
        lblBirthdayM = new JLabel();
        lblAddressM = new JLabel();
        lblGenderM = new JLabel();

        txtIdentifyCard = new JTextField();
        txtName = new JTextField();
        txtEmail = new JTextField();
        txtPhone = new JTextField();
        txtBirthday = new JTextField();
        txtGender = new JTextField();
        txtAddress = new JTextField();

        txtIdentifyCard.setText(us.getIdentifyCard());
        txtName.setText(us.getFullName());
        txtEmail.setText(us.getEmail());
        txtPhone.setText(us.getPhone());
        txtBirthday.setText(us.getBirthDay());
        txtGender.setText(us.getGender());
        txtAddress.setText(us.getAddress());

        txtIdentifyCard.setEditable(false);
        txtName.setEditable(false);
        txtEmail.setEditable(false);
        txtPhone.setEditable(false);
        txtBirthday.setEditable(false);
        txtGender.setEditable(false);
        txtAddress.setEditable(false);
        txtIdentifyCard.setBackground(Color.white);
        txtName.setBackground(Color.white);
        txtEmail.setBackground(Color.white);
        txtPhone.setBackground(Color.white);
        txtBirthday.setBackground(Color.white);
        txtGender.setBackground(Color.white);
        txtAddress.setBackground(Color.white);

        
        login = new JButton("Login");
        exit = new JButton("Exit");

        lblName.setBounds(120, 20, 100, 30);
        lblEmail.setBounds(120, 70, 100, 30);
        lblPhone.setBounds(120, 120, 100, 30);
        lblBirthday.setBounds(120, 170, 100, 30);
        lblGender.setBounds(120, 220, 100, 30);
        lblAddress.setBounds(120, 270, 100, 30);
        lblIdentifyCard.setBounds(120, 320, 100, 30);

        lblNameM.setBounds(220, 40, 150, 30);
        lblEmailM.setBounds(220, 90, 150, 30);
        lblPhoneM.setBounds(220, 140, 150, 30);
        lblBirthdayM.setBounds(220, 190, 150, 30);
        lblGenderM.setBounds(220, 240, 150, 30);
        lblAddressM.setBounds(220, 290, 150, 30);

        txtName.setBounds(220, 20, 250, 30);
        txtEmail.setBounds(220, 70, 250, 30);
        txtPhone.setBounds(220, 120, 250, 30);
        txtBirthday.setBounds(220, 170, 250, 30);
        txtGender.setBounds(220, 220, 250, 30);
        txtAddress.setBounds(220, 270, 250, 30);
        txtIdentifyCard.setBounds(220, 320, 250, 30);

       
        exit.setBounds(350, 370, 80, 30);
        login.setBounds(200, 370, 80, 30);

        lblName.setFont(new Font("Arial", 2, 16));
        lblEmail.setFont(new Font("Arial", 2, 16));
        lblPhone.setFont(new Font("Arial", 2, 16));
        lblBirthday.setFont(new Font("Arial", 2, 16));
        lblGender.setFont(new Font("Arial", 2, 16));
        lblAddress.setFont(new Font("Arial", 2, 16));
        lblIdentifyCard.setFont(new Font("Arial", 2, 16));

        lblName.setForeground(Color.decode("#2E7D32"));
        lblEmail.setForeground(Color.decode("#2E7D32"));
        lblPhone.setForeground(Color.decode("#2E7D32"));
        lblBirthday.setForeground(Color.decode("#2E7D32"));
        lblGender.setForeground(Color.decode("#2E7D32"));
        lblAddress.setForeground(Color.decode("#2E7D32"));
        lblIdentifyCard.setForeground(Color.decode("#2E7D32"));

       
        login.setForeground(Color.white);
        exit.setForeground(Color.white);
        login.setBackground(Color.decode("#7CB342"));
        exit.setBackground(Color.decode("#7CB342"));
        login.setFont(new Font("Arial", 2, 16));
        exit.setFont(new Font("Arial", 2, 16));

        
        exit.addActionListener(new Exit());
        login.addActionListener(new Login());

        panel.add(lblIdentifyCard);
        panel.add(lblName);
        panel.add(lblEmail);
        panel.add(lblPhone);
        panel.add(lblBirthday);
        panel.add(lblGender);
        panel.add(lblAddress);

        panel.add(lblNameM);
        panel.add(lblEmailM);
        panel.add(lblPhoneM);
        panel.add(lblBirthdayM);
        panel.add(lblGenderM);
        panel.add(lblAddressM);

        panel.add(txtName);
        panel.add(txtEmail);
        panel.add(txtPhone);
        panel.add(txtBirthday);
        panel.add(txtGender);
        panel.add(txtAddress);
        panel.add(txtIdentifyCard);

        panel.add(login);
        panel.add(exit);
        frame.add(panel);

        frame.add(panel);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

   
    class Login implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String edit = "Edit";
            String save = "Save";
            boolean y = (login.getText()).equals(save);
            boolean t = (login.getText()).equals(edit);

            if (t) {
                login.setText(save);
                txtName.setEditable(true);
                txtEmail.setEditable(true);
                txtPhone.setEditable(true);
                txtBirthday.setEditable(true);
                txtGender.setEditable(true);
                txtAddress.setEditable(true);

            }
            if (y) {

                if (true) {
                    String name = txtName.getText();
                    String email = txtEmail.getText();
                    String phone = txtPhone.getText();
                    String birthday = txtBirthday.getText();
                    String gender = txtGender.getText();
                    String address = txtAddress.getText();
                    String iden = txtIdentifyCard.getText();
                    User us = new User();

                    us.setFullName(name);
                    us.setEmail(email);
                    us.setPhone(phone);
                    us.setBirthDay(birthday);
                    us.setGender(gender);
                    us.setAddress(address);
                    us.setIdentifyCard(iden);

                    HashMap<String, String> errors = new FormHandle().validateUpdate(name, email, phone, birthday, gender, address);
                    int result = 999;
                    if (errors.size() == 0) {
                        //resetMessage();
                        result = JOptionPane.showConfirmDialog(null, "Create account");
                        if (result == 0) {

                            if (handle.vaildateEmail(email) == false) {
                                lblEmailM.setForeground(Color.red);
                                lblEmailM.setText("Invalid email");
                            }
                            if (handle.vaildatePhone(phone) == false) {
                                lblPhoneM.setForeground(Color.red);
                                lblPhoneM.setText("Phonenumber not valid");
                            }
                            if (true) {
                                model.insert2(us);
                                txtName.setEditable(false);
                                txtEmail.setEditable(false);
                                txtPhone.setEditable(false);
                                txtBirthday.setEditable(false);
                                txtGender.setEditable(false);
                                txtAddress.setEditable(false);
                                login.setText(edit);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Enter full information");
                        }

                    } else {

                        showError(errors);
                    }
                }
            }
        }

    }

    class Exit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
        }

    }

    private void showError(HashMap<String, String> errors) {

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
        if (errors.containsKey("txtBirthday")) {
            lblBirthdayM.setForeground(Color.decode("#E64A19"));
            lblBirthdayM.setText(errors.get("txtBirthday"));
        } else {
            lblBirthdayM.setForeground(Color.green);
            lblBirthdayM.setText("Valid");
        }
        if (errors.containsKey("txtGender")) {
            lblGenderM.setForeground(Color.decode("#E64A19"));
            lblGenderM.setText(errors.get("txtGender"));
        } else {
            lblGenderM.setForeground(Color.green);
            lblGenderM.setText("Valid");
        }
        if (errors.containsKey("txtAddress")) {
            lblAddressM.setForeground(Color.decode("#E64A19"));
            lblAddressM.setText(errors.get("txtAddress"));
        } else {
            lblAddressM.setForeground(Color.green);
            lblAddressM.setText("Valid");
        }

    }
}
