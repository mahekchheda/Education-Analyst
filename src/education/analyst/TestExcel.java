/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package education.analyst;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mahekchheda
 */
public class TestExcel {
    public static void main(String args[]){
        Connection con = null;
        Statement pst = null;

        String url = "jdbc:mysql://localhost:3306/mynewgig";
        String user = "root";
        String password = "";

        try {

            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established!!");
            pst = con.createStatement();
            ResultSet rs = pst.executeQuery("SELECT COUNT(*) FROM TEACHER;");
            rs.next();
            System.out.println(rs.getString(1));

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(TestExcel.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(TestExcel.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    
}
