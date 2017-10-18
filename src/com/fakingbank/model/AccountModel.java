/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fakingbank.model;

import com.fakingbank.entity.Account;
import com.fakingbank.entity.Transaction;
import com.fakingbank.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daolinh
 */
/**
 * Thực hiện các thao tác với database của lớp Account.
 */
public class AccountModel {

    private TransactionModel transactionModel = new TransactionModel();

    // Thêm mới dữ liệu.
    public boolean insert(Account obj) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("insert into");
        sqlBuilder.append(" ");
        sqlBuilder.append("account");
        sqlBuilder.append(" ");
        sqlBuilder.append("(number, account, password, balance, userIdentifyCard, createdTimeMLS, updatedTimeMLS, status)");
        sqlBuilder.append(" ");
        sqlBuilder.append("values");
        sqlBuilder.append(" ");
        sqlBuilder.append("(?, ?, ?, ?, ?, ?, ?, ?);");

        try {
            Connection con = DAO.getConnection();
            PreparedStatement preStt = con.prepareStatement(sqlBuilder.toString());
            preStt.setString(1, obj.getNumber());
            preStt.setString(2, obj.getAccount());
            preStt.setString(3, obj.getPassword());
            preStt.setLong(4, obj.getBalance());
            preStt.setString(5, obj.getUserIdentifyCard());
            preStt.setLong(6, obj.getCreatedTimeMLS());
            preStt.setLong(7, obj.getUpdatedTimeMLS());
            preStt.setInt(8, obj.getStatus());
            preStt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public boolean insert1(User obj) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("insert into");
        sqlBuilder.append(" ");
        sqlBuilder.append("user");
        sqlBuilder.append(" ");
        sqlBuilder.append("(identifyCard, name, email, phone, birthday, gender, address, createdTimeMLS, updatedTimeMLS, status)");
        sqlBuilder.append(" ");
        sqlBuilder.append("values");
        sqlBuilder.append(" ");
        sqlBuilder.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        try {
            Connection con = DAO.getConnection();
            PreparedStatement preStt = con.prepareStatement(sqlBuilder.toString());
            preStt.setString(1, obj.getIdentifyCard());
            preStt.setString(2, obj.getFullName());
            preStt.setString(3, obj.getEmail());
            preStt.setString(4, obj.getPhone());
            preStt.setString(5, obj.getBirthDay());
            preStt.setString(6, obj.getGender());
            preStt.setString(7, obj.getAddress());
            preStt.setLong(8, obj.getCreatedTimeMLS());
            preStt.setLong(9, obj.getUpdatedTimeMLS());
            preStt.setInt(10, obj.getStatus());
            preStt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    public boolean update(Account obj) {
        return false;
    }

    public boolean delete(String id) {
        return false;
    }

    public Account getById(String id) {
        Account obj = new Account();
        return obj;
    }

    public ArrayList<Account> getList() {
        ArrayList<Account> list = new ArrayList<>();
        return list;
    }

    // Thực hiện cộng tiền vào tài khoản, trả về là số dư mới.
    public long deposit(String targetAccountNumber, long amount) {
        Connection con = null;
        try {
            con = DAO.getConnection();
            con.setAutoCommit(false);

            // 1. Thực hiện truy vấn số dư của tài khoản.
            StringBuilder sqlSelectBuilder = new StringBuilder();
            sqlSelectBuilder.append("select balance from account where number = ?;");
            PreparedStatement queryBalance = con.prepareStatement(sqlSelectBuilder.toString());
            queryBalance.setString(1, targetAccountNumber);
            ResultSet resultBalance = queryBalance.executeQuery();
            // Số dư mặc định bằng 0.
            long balance = 0;
            if (resultBalance.next()) {
                balance = resultBalance.getLong("balance");
            }

            // 2. Tiến hành cộng tiền vào tài khoản.
            balance += amount;

            StringBuilder sqlUpdate = new StringBuilder();
            sqlUpdate.append("update account");
            sqlUpdate.append(" ");
            sqlUpdate.append("set balance = ?");
            sqlUpdate.append(" ");
            sqlUpdate.append("where");
            sqlUpdate.append(" ");
            sqlUpdate.append("number = ?;");
            PreparedStatement updateBalance = con.prepareStatement(sqlUpdate.toString());
            updateBalance.setLong(1, balance); // số dư mới của tài khoản.
            updateBalance.setString(2, targetAccountNumber); // tài khoản cộng tiền.
            updateBalance.executeUpdate();

            // Lưu lịch sử giao dịch.
            Transaction tx = new Transaction();
            tx.setSenderAccountNumber(targetAccountNumber);
            tx.setReceiverAccountNumber(targetAccountNumber);
            tx.setAmount(amount);
            tx.setType(1);
            tx.setMessage("Deposit money.");
            tx.setStatus(1);
            if (transactionModel.insert(tx)) {
                con.commit(); // Lưu tất cả các thay đổi của các lệnh vừa thực thi vào db.
                return balance;
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    public long withdraw(String strAccountNumber, long amount) {
        Connection con = null;
        try {
            con = DAO.getConnection();
            con.setAutoCommit(false);

            StringBuilder sqlSelectBuilder = new StringBuilder();
            sqlSelectBuilder.append("select balance from account where number = ?;");
            PreparedStatement queryBalance = con.prepareStatement(sqlSelectBuilder.toString());
            queryBalance.setString(1, strAccountNumber);
            ResultSet resultBalance = queryBalance.executeQuery();

            long balance = 0;
            if (resultBalance.next()) {
                balance = resultBalance.getLong("balance");
            }

            balance -= amount;

            StringBuilder sqlUpdate = new StringBuilder();
            sqlUpdate.append("update account");
            sqlUpdate.append(" ");
            sqlUpdate.append("set balance = ?");
            sqlUpdate.append(" ");
            sqlUpdate.append("where");
            sqlUpdate.append(" ");
            sqlUpdate.append("number = ?;");
            PreparedStatement updateBalance = con.prepareStatement(sqlUpdate.toString());
            updateBalance.setLong(1, balance);
            updateBalance.setString(2, strAccountNumber);
            updateBalance.executeUpdate();

            Transaction tx = new Transaction();
            tx.setSenderAccountNumber(strAccountNumber);
            tx.setReceiverAccountNumber(strAccountNumber);
            tx.setAmount(amount);
            tx.setType(2);
            tx.setMessage("withdraw money.");
            tx.setStatus(1);
            if (transactionModel.insert(tx)) {
                con.commit();
                return balance;
            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    // Thực hiện chuyển tiền đến tài khoản đích, tham số thứ nhất là số lượng tiền
    // cần chuyển, tham số thứ hai là số tài khoản nhận tiền. Trả về số dư hiện tại
    // của tài khoản thực hiện.
    public long transfer(long amount, String strNumber1, String strNumber2) {

        Connection con = null;
        try {
            con = DAO.getConnection();
            con.setAutoCommit(false);
            if (true) {

            }
            StringBuilder sql1 = new StringBuilder();
            sql1.append("select balance from account where number = ?;");
            PreparedStatement queryBalance1 = con.prepareStatement(sql1.toString());
            queryBalance1.setString(1, strNumber1);
            ResultSet resultBalance1 = queryBalance1.executeQuery();
            long balance1 = 0;
            if (resultBalance1.next()) {
                balance1 = resultBalance1.getLong("balance");
            }

            balance1 -= amount;
            StringBuilder sqlUpdate1 = new StringBuilder();
            sqlUpdate1.append("update account");
            sqlUpdate1.append(" ");
            sqlUpdate1.append("set balance = ?");
            sqlUpdate1.append(" ");
            sqlUpdate1.append("where");
            sqlUpdate1.append(" ");
            sqlUpdate1.append("number = ?;");
            PreparedStatement updateBalance1 = con.prepareStatement(sqlUpdate1.toString());
            updateBalance1.setLong(1, balance1);
            updateBalance1.setString(2, strNumber1);
            updateBalance1.executeUpdate();

            Transaction tx = new Transaction();
            tx.setSenderAccountNumber(strNumber1);
            tx.setReceiverAccountNumber(strNumber1);
            tx.setAmount(amount);
            tx.setType(3);
            tx.setMessage("transfer money.");
            tx.setStatus(1);
            transactionModel.insert(tx);

            StringBuilder sql2 = new StringBuilder();
            sql2.append("select balance from account where number = ?;");
            PreparedStatement queryBalance = con.prepareStatement(sql2.toString());
            queryBalance.setString(1, strNumber2);
            ResultSet resultBalance2 = queryBalance.executeQuery();
            long balance2 = 0;
            if (resultBalance2.next()) {
                balance2 = resultBalance2.getLong("balance");
            }

            balance2 += amount;
            StringBuilder sqlUpdate2 = new StringBuilder();
            sqlUpdate2.append("update account");
            sqlUpdate2.append(" ");
            sqlUpdate2.append("set balance = ?");
            sqlUpdate2.append(" ");
            sqlUpdate2.append("where");
            sqlUpdate2.append(" ");
            sqlUpdate2.append("number = ?;");
            PreparedStatement updateBalance2 = con.prepareStatement(sqlUpdate2.toString());
            updateBalance2.setLong(1, balance2);
            updateBalance2.setString(2, strNumber2);
            updateBalance2.executeUpdate();

            Transaction ty = new Transaction();
            ty.setSenderAccountNumber(strNumber2);
            ty.setReceiverAccountNumber(strNumber2);
            ty.setAmount(amount);
            ty.setType(3);
            ty.setMessage("withdraw money.");
            ty.setStatus(1);

            if (transactionModel.insert(ty)) {
                con.commit();
                return amount;

            } else {
                con.rollback();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    // Kiểm tra thông tin tài khoản với account và password. Trả về null trong 
    // trường hợp không tồn tại account và password hợp lệ.
    public Account checkAuthentication(String account, String password) {
        Account acc = null;
        Connection con = null;
        try {
            con = DAO.getConnection();
            StringBuilder strSQL = new StringBuilder();
            strSQL.append("SELECT number, account, balance FROM account WHERE account = ? AND password = ? AND status = 1;");
            PreparedStatement preStt = con.prepareStatement(strSQL.toString());
            preStt.setString(1, account);
            preStt.setString(2, password);
            System.out.println(preStt);
            ResultSet rs = preStt.executeQuery();
            if (rs.next()) {
                String number = rs.getString("number");
                String accountString = rs.getString("account");
                long balance = rs.getLong("balance");
                acc = new Account();
                acc.setAccount(accountString);
                acc.setNumber(number);
                acc.setBalance(balance);
            }
        } catch (SQLException e) {
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return acc;
    }

    public Account getAccount(String account) {
        Account acc = null;
        Connection con = null;
        try {
            con = DAO.getConnection();
            StringBuilder strSQL = new StringBuilder();
            strSQL.append("SELECT number, account, balance, userIdentifyCard FROM account WHERE account = ? AND status = 1;");
            PreparedStatement preStt = con.prepareStatement(strSQL.toString());
            preStt.setString(1, account);
            System.out.println(preStt);
            ResultSet rs = preStt.executeQuery();
            if (rs.next()) {
                String number = rs.getString("number");
                String strAccount = rs.getString("account");
                long balance = rs.getLong("balance");
                String identifyCard = rs.getString("userIdentifyCard");

                acc = new Account();
                acc.setAccount(strAccount);
                acc.setNumber(number);
                acc.setBalance(balance);
                acc.setUserIdentifyCard(identifyCard);
            }
        } catch (SQLException e) {
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return acc;
    }

    public User getIdentify(String identifyCard) {
        User us = null;
        Connection con = null;
        try {
            con = DAO.getConnection();
            StringBuilder strSQL = new StringBuilder();
            strSQL.append("SELECT identifyCard, name, email, phone, birthday, gender, address FROM user WHERE identifyCard = ? AND status = 1;");
            PreparedStatement preStt = con.prepareStatement(strSQL.toString());
            preStt.setString(1, identifyCard);
            System.out.println(preStt);
            ResultSet rs = preStt.executeQuery();
            if (rs.next()) {
                //  String strIdentifyCard = rs.getString("identifyCard");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String birthday = rs.getString("birthday");
                String gender = rs.getString("gender");
                String address = rs.getString("address");

                us = new User();
                us.setIdentifyCard(identifyCard);
                us.setFullName(name);
                us.setEmail(email);
                us.setPhone(phone);
                us.setBirthDay(birthday);
                us.setGender(gender);
                us.setAddress(address);

            }
        } catch (SQLException e) {
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return us;
    }

    public Account Number(String number) {
        Account acc = null;
        Connection con = null;
        try {
            con = DAO.getConnection();
            StringBuilder strSQL = new StringBuilder();
            strSQL.append("SELECT number, account, balance, userIdentifyCard FROM account WHERE number = ? AND status = 1;");
            PreparedStatement preStt = con.prepareStatement(strSQL.toString());
            preStt.setString(1, number);
            System.out.println(preStt);
            ResultSet rs = preStt.executeQuery();
            if (rs.next()) {
                String number1 = rs.getString("number");
                String strAccount = rs.getString("account");
                long balance = rs.getLong("balance");
                String identifyCard = rs.getString("userIdentifyCard");

                acc = new Account();
                acc.setAccount(strAccount);
                acc.setNumber(number1);
                acc.setBalance(balance);
                acc.setUserIdentifyCard(identifyCard);
            }
        } catch (SQLException e) {
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return acc;
    }

  
    

    public boolean insert2(User obj) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("UPDATE");
        sqlBuilder.append(" ");
        sqlBuilder.append("user");
        sqlBuilder.append(" ");
        sqlBuilder.append("SET");
        sqlBuilder.append(" ");
        sqlBuilder.append(" name=?, email=?, phone=?, birthday=?, gender=?, address=?");
        sqlBuilder.append(" ");
        sqlBuilder.append("where");
        sqlBuilder.append(" ");
        sqlBuilder.append("identifyCard=?;");
        try {
            Connection con = DAO.getConnection();
            PreparedStatement preStt = con.prepareStatement(sqlBuilder.toString());
           
            preStt.setString(1, obj.getFullName());
            preStt.setString(2, obj.getEmail());
            preStt.setString(3, obj.getPhone());
            preStt.setString(4, obj.getBirthDay());
            preStt.setString(5, obj.getGender());
            preStt.setString(6, obj.getAddress());
            preStt.setString(7, obj.getIdentifyCard());
            preStt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }
    
        public boolean ChangePass(Account obj) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("UPDATE");
        sqlBuilder.append(" ");
        sqlBuilder.append("account");
        sqlBuilder.append(" ");
        sqlBuilder.append("SET");
        sqlBuilder.append(" ");
        sqlBuilder.append(" number=?, account=?, password=?, balance=?, userIdentifyCard=?");
        sqlBuilder.append(" ");
        sqlBuilder.append("where");
        sqlBuilder.append(" ");
        sqlBuilder.append("account=?;");
        try {
            Connection con = DAO.getConnection();
            PreparedStatement preStt = con.prepareStatement(sqlBuilder.toString());
           
            preStt.setString(1, obj.getPassword());
            preStt.setString(2, obj.getAccount());
            preStt.setString(3, obj.getAccount());
            preStt.setLong(4, obj.getBalance());
            preStt.setString(5, obj.getUserIdentifyCard());
            preStt.setString(6, obj.getAccount());
    
            preStt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

}
