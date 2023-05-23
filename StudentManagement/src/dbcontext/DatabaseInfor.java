/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dbcontext;

/**
 *
 * @author WinD
 */
public interface DatabaseInfor {
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;databaseName=StudentMN;"+"encrypt=true;trustServerCertificate=true;sslProtocol=TLsv1.2";
        String user="sa";
        String password = "63";
}
