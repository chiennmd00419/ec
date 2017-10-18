/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fakingbank.entity;

import java.util.Calendar;

/**
 *
 * @author daolinh
 */
public class Transaction {
                    
    private long id;
    private int type; // Gửi tiền 1 | Rút tiền 2 | Chuyển tiền 3.
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private long amount;    
    private String message;
        
    private long createdTimeMLS; // Ngày thực hiện giao dịch.
    private long updatedTimeMLS;
    private int status; // Thành công 1 | Thất bại 0 | Chờ 2. 

    public Transaction() {        
        this.id = Calendar.getInstance().getTimeInMillis();
        this.createdTimeMLS = Calendar.getInstance().getTimeInMillis();
        this.updatedTimeMLS = Calendar.getInstance().getTimeInMillis();
        this.status = 2;
    }        

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }        

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCreatedTimeMLS() {
        return createdTimeMLS;
    }

    public void setCreatedTimeMLS(long createdTimeMLS) {
        this.createdTimeMLS = createdTimeMLS;
    }

    public long getUpdatedTimeMLS() {
        return updatedTimeMLS;
    }

    public void setUpdatedTimeMLS(long updatedTimeMLS) {
        this.updatedTimeMLS = updatedTimeMLS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
