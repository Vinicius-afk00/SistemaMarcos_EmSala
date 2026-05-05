    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author u08538003160
 */
public class JdbcCrud {
    public static void main(String[] args) {
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, password;
                    url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
                    user = "marcos_vilhanueva";
                    password = "marcos_vilhanueva";
                    Connection cnt;
                    cnt = DriverManager.getConnection(url, user, password);
//                    Statement stm = cnt.createStatement();
//                    String slq = "insert into "
//                            + "mpv_usuarios(mpv_idusuarios,mpv_nome, mpv_apelido, mpv_cpf) "
//                            + "values(103, 'vinicius', 'vpd', '646887456843')";
//                    stm.executeUpdate(slq);
//                    String sql = "insert into "
//                            + "mpv_usuarios(mpv_idusuarios,mpv_nome, mpv_apelido, mpv_cpf)"
//                            + " values (?, ?, ?, ?)";
//                    String sql = "update mpv_usuarios"
//                            + " set mpv_nome = ?, mpv_apelido= ?, mpv_cpf= ?"
//                            + " where mpv_idusuarios= ?";
                      String sql = "delete from mpv_usuarios where mpv_idusuarios = ?";
                    PreparedStatement pst = cnt.prepareStatement(sql);
                    pst.setInt(1, 503);
//                    pst.setString(1, "Vinicius Peres Dorneles");
//                    pst.setString(2, "vpd");
//                    pst.setString(3, "56893262666");
                    pst.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Conectou");
    }
}
