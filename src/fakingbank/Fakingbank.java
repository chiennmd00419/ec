/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fakingbank;

import com.fakingbank.model.AccountModel;

/**
 *
 * @author Lan
 */
public class Fakingbank {
     public static void main(String[] args) {
        AccountModel model = new AccountModel();
        
        model.deposit("e9686cb8-1f5e-456c-b71a-abfdae3dab29", 50000);       
    }
}
