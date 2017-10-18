/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fakingbank.entity;

import java.util.UUID;

/**
 *
 * @author daolinh
 */

// Class lưu thông tin tài khoản ngân hàng.
public class Account {
    
    private String number; // Số tài khoản ngân hàng, khoá chính.
    private String account; // Tài khoản đăng nhập.
    private String password; // Mật khẩu.
    private long balance; // Số tiền còn lại trong tài khoản.    
    // Số chứng minh thư người dùng. Cái này dùng để
    // lấy thông tin chi tiết từ bảng user.
    private String userIdentifyCard;
    
    // Ngày tạo tài khoản, lưu dưới dạng long time milisecond.
    private long createdTimeMLS;
    // Ngày update tài khoản.
    private long updatedTimeMLS;
    // Trạng thái tài khoản. Có hai giá trị: 0 (lock hoặc đã bị xoá), 1 (hoạt động).
    private int status;
    
    // Contructor khởi tạo tài khoản,
    // luôn sinh ra một random string để làm số tài khoản.
    // Bên cạnh đó còn khởi tạo ngày tạo và ngày cập nhật.
    // Trạng thái status mặc định là 1.
    public Account() {
        this.number = UUID.randomUUID().toString();
        this.createdTimeMLS = System.currentTimeMillis();
        this.updatedTimeMLS = this.createdTimeMLS;
        this.status = 1;
    }       

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getUserIdentifyCard() {
        return userIdentifyCard;
    }

    public void setUserIdentifyCard(String userIdentifyCard) {
        this.userIdentifyCard = userIdentifyCard;
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
