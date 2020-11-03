/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/**
 *
 * @author Fer
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLVersion {

    Connection con;

    public MySQLVersion() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreriadb;", "root", "");
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
    }

    public static void main(String[] args) {
        MySQLVersion cn = new MySQLVersion();
        Statement st;
        ResultSet rs;
        String query = "SELECT VERSION()";
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            cn.con.close();
        } catch (Exception e) {
        }

    }
}
