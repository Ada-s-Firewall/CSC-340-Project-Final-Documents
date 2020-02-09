/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Halie Pearson
 */
public class DataBase {
    
    public static void main(String[] args) {
        Connection connectionObject = null;
        Statement statementObject = null;
        ResultSet resultObject = null;
        String query = "select * from ADASFIREWALL.USERACCOUNT";
        
        try{
            connectionObject = DriverManager.getConnection("jdbc:derby://localhost:1527/MyMusicListDataBase", "AdasFirewall", "csc340");
            statementObject = connectionObject.createStatement();
            resultObject = statementObject.executeQuery(query);
            while(resultObject.next()){
                int id = resultObject.getInt("ID");
                String userName = resultObject.getString("USERNAME");
                String password = resultObject.getString("PASSWORD");
                String email = resultObject.getString("EMAIL");
                System.out.println(id + "\t  " + userName+ "\t  " + password + "\t  " + email );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
