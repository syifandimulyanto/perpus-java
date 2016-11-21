/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anakodingperpustakaan.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fandi
 */
public class Database {
    public static Connection setConnection()
    {
        String jdbc = "jdbc:mysql://localhost/anakoding_perpustakaan";
        Connection con  = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(jdbc, "root", "");
            System.out.println("Koneksi berhasil");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi gagal");
        } catch (SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi gagal");
        }
        return con;
    }
    public static int execute(String SQL)
    {
        int status = 0;
        Connection con = setConnection();
        try{
            Statement st = con.createStatement();
            status = st.executeUpdate(SQL);
        }catch (SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    public static ResultSet executeQuery(String SQL)
    {
        ResultSet rs = null;
        Connection con = setConnection();
        try{
            Statement st = con.createStatement();
            rs = st.executeQuery(SQL);
        }catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
