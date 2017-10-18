/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fakingbank.swing;

import com.fakingbank.entity.Account;
import com.fakingbank.image.ImageLabel;
import com.fakingbank.model.AccountModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lan
 */
public class MenuBank {

    private JFrame frame;
    private JPanel panel;

    private JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lblNumber,lblAccount;
    private JTextField txtNumber;

    AccountModel ac = new AccountModel();
    private String cmt;
    private String a;
    private String b;
    public MenuBank(String account) {
        Account acc = ac.getAccount(account);

        frame = new JFrame();
        panel = new JPanel();

        frame.setSize(622, 900);
        frame.setLocationRelativeTo(null);

        panel.setBounds(0, 0, 622, 900);
        panel = new ImagePanel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\panel1.png").getImage());

        lbl1 = new JLabel();
        lbl2 = new JLabel();
        lbl3 = new JLabel();
        lbl4 = new JLabel();
        lbl5 = new JLabel();
        lbl6 = new JLabel();
        lblNumber = new JLabel("Bank number");
       
     
         cmt = acc.getUserIdentifyCard();
         a = acc.getPassword();
         b = acc.getAccount();
        lblAccount = new JLabel(acc.getAccount());
       

        txtNumber = new JTextField(acc.getNumber());
      
        txtNumber.setEditable(false);
      
        txtNumber.setBackground(Color.white);
      

        lbl1 = new ImageLabel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\L1.png").getImage());
        lbl2 = new ImageLabel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\L2.png").getImage());
        lbl3 = new ImageLabel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\L3.png").getImage());
        lbl4 = new ImageLabel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\L4.png").getImage());
        lbl5 = new ImageLabel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\L5.png").getImage());
        lbl6 = new ImageLabel(new ImageIcon("C:\\Users\\Lan\\Desktop\\fakingbank\\img\\L6.png").getImage());

        lblNumber.setBounds(50, 50, 150, 30);
    
        txtNumber.setBounds(200, 50, 250, 30);
      

        lblNumber.setFont(new Font("Arial", 1, 17));
     
        lblNumber.setForeground(Color.white);
     

        lbl1.setBounds(0, 620, 300, 70);
        lbl3.setBounds(0, 700, 300, 70);
        lbl5.setBounds(0, 780, 300, 70);
        lbl2.setBounds(310, 620, 300, 70);
        lbl4.setBounds(310, 700, 300, 70);
        lbl6.setBounds(310, 780, 300, 70);

        lbl1.addMouseListener(new L1());
        lbl2.addMouseListener(new L2());
        lbl3.addMouseListener(new L3());
        lbl4.addMouseListener(new L4());
        lbl5.addMouseListener(new L5());
        lbl6.addMouseListener(new L6());

       
        panel.add(lblAccount);
        panel.add(lblNumber);
     
        panel.add(txtNumber);
      
        panel.add(lbl1);
        panel.add(lbl2);
        panel.add(lbl3);
        panel.add(lbl4);
        panel.add(lbl5);
        panel.add(lbl6);

        frame.add(panel);
        panel.setLayout(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    class L1 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Deposit nn = new Deposit(lblAccount.getText());
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lbl1.setBounds(5, 620, 300, 70);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            lbl1.setBounds(0, 620, 300, 70);
        }
    }

    class L2 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Withdraw bb = new Withdraw(lblAccount.getText());

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lbl2.setBounds(300, 620, 300, 70);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            lbl2.setBounds(310, 620, 300, 70);
        }
    }

    class L3 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Transfer cc = new Transfer(lblAccount.getText());
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lbl3.setBounds(5, 700, 300, 70);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            lbl3.setBounds(0, 700, 300, 70);
        }
    }

    class L4 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Information qq = new Information(cmt);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lbl4.setBounds(300, 700, 300, 70);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            lbl4.setBounds(310, 700, 300, 70);
        }
    }

    class L5 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Password password = new Password(b);
          
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lbl5.setBounds(5, 780, 300, 70);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            lbl5.setBounds(0, 780, 300, 70);
        }
    }

    class L6 implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
           LogInForm logInForm = new LogInForm();
            frame.setVisible(false);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lbl6.setBounds(300, 780, 300, 70);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            lbl6.setBounds(310, 780, 300, 70);
        }
    }

}
