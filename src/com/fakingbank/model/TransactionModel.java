/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fakingbank.model;

import com.fakingbank.entity.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author daolinh
 */
public class TransactionModel {
    public boolean insert(Transaction obj){
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("insert into");
        sqlBuilder.append(" ");
        sqlBuilder.append("transaction");
        sqlBuilder.append(" ");
        sqlBuilder.append("(id, type, senderAccountNumber, receiverAccountNumber, amount, message, createdTimeMLS, updatedTimeMLS, status)");
        sqlBuilder.append(" ");
        sqlBuilder.append("values");
        sqlBuilder.append(" ");
        sqlBuilder.append("(?, ?, ?, ?, ?, ?, ?, ?, ?);");

        try {
            Connection con = DAO.getConnection();
            PreparedStatement preStt = con.prepareStatement(sqlBuilder.toString());
            preStt.setLong(1, obj.getId());
            preStt.setInt(2, obj.getType());
            preStt.setString(3, obj.getSenderAccountNumber());
            preStt.setString(4, obj.getReceiverAccountNumber());
            preStt.setLong(5, obj.getAmount());
            preStt.setString(6, obj.getMessage());            
            preStt.setLong(7, obj.getCreatedTimeMLS());
            preStt.setLong(8, obj.getUpdatedTimeMLS());
            preStt.setInt(9, obj.getStatus());
            preStt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }        
        return false;
    }
}
