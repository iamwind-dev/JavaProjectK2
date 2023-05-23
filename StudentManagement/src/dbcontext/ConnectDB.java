/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbcontext;

import static dbcontext.DatabaseInfor.driverName;
import static dbcontext.DatabaseInfor.password;
import static dbcontext.DatabaseInfor.url;
import static dbcontext.DatabaseInfor.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duong
 */
public class ConnectDB implements DatabaseInfor{
    private static ConnectDB instance;
    public Connection openConnection(){
        try {
            try {
                Class.forName(driverName);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static ConnectDB getInstance(){
        if(instance == null ){
            instance = new ConnectDB();
        }
        return instance;
    }
}
