/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fakingbank.swing;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lan
 */
public class FormHandle {

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_REGEX = "^0(1\\d{9}|9\\d{8})$";

    public boolean vaildateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean vaildatePhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public HashMap<String, String> validateLogin(String account, String password) {
        HashMap<String, String> errors = new HashMap<>();

        if (account.isEmpty()) {
            errors.put("txtAccount", "*Enter Account");
        }
        if (password.isEmpty()) {
            errors.put("txtPassword", "*Enter Password");
        }
        return errors;

    }
    
        public HashMap<String, String> validatePassword(String password1, String password2, String password3) {
        HashMap<String, String> errors = new HashMap<>();

        if (password1.isEmpty()) {
            errors.put("txtpass1", "*Enter Password");
        }
        if (password2.isEmpty()) {
            errors.put("txtpass2", "*Enter Password");
        }
         if (password3.isEmpty()) {
            errors.put("txtpass3", "*Enter Password");
        }
        return errors;

    }

    public HashMap<String, String> validateCreate(String account, String password, String password1, String name, String email, String phone, String address, String identifyCard) {
        HashMap<String, String> errors = new HashMap<>();

        if (account.isEmpty()) {
            errors.put("txtAccount", "*Enter Account");
        }
        if (password.isEmpty()) {
            errors.put("txtPassword", "*Enter Password");
        }
        if (password1.isEmpty()) {
            errors.put("txtPassword1", "*Enter Password");
        }
        if (name.isEmpty()) {
            errors.put("txtName", "*Enter Name");
        }
        if (email.isEmpty()) {
            errors.put("txtEmail", "*Enter Email");
        }
        if (phone.isEmpty()) {
            errors.put("txtPhone", "*Enter Phone");
        }
        if (address.isEmpty()) {
            errors.put("txtAddress", "*Enter Address");
        }
        if (identifyCard.isEmpty()) {
            errors.put("txtIdentifyCard", "*Enter IdentifyCard");
        }

        return errors;

    }

    public HashMap<String, String> validateUpdate(String name, String email, String phone, String birthday, String gender, String address) {
        HashMap<String, String> errors = new HashMap<>();

        if (name.isEmpty()) {
            errors.put("txtName", "*Enter Name");
        }
        if (email.isEmpty()) {
            errors.put("txtEmail", "*Enter Email");
        }
        if (phone.isEmpty()) {
            errors.put("txtPhone", "*Enter Phone");
        }
        if (birthday.isEmpty()) {
            errors.put("txtBirthday", "*Enter Birthday");
        }
        if (gender.isEmpty()) {
            errors.put("txtGender", "*Enter Gender");
        }
        if (address.isEmpty()) {
            errors.put("txtAddress", "*Enter Address");
        }

        return errors;

    }
}
