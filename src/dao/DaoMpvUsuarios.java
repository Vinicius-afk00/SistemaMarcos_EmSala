/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.MpvUsuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import testes.JdbcSelect;

/**
 *
 * @author u08538003160
 */
public class DaoMpvUsuarios extends DaoAbstract{

    @Override
    public void insert(Object object) {
        MpvUsuarios mpvUsuarios = (MpvUsuarios) object;
       try {
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
            user = "marcos_vilhanueva";
            password = "marcos_vilhanueva";
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "insert into mpv_usuarios values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, mpvUsuarios.getMpvIdUsuarios());
            pst.setString(2, mpvUsuarios.getMpvNome());
            pst.setString(3, mpvUsuarios.getMpvApelido());
            pst.setString(4, mpvUsuarios.getMpvCpf());
            pst.setDate(5, null);//mpv_dta_nascimento
            pst.setInt(6, mpvUsuarios.getMpvNivel());
            pst.setString(7, mpvUsuarios.getMpvSenha());
            pst.setString(8, mpvUsuarios.getMpvAtivo());
            pst.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcSelect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JdbcSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        
    }

    @Override
    public void delete(Object object) {
        
    }

    @Override
    public Object list(int id) {
        return null;
    }

    @Override
    public Object listAll() {
        return null;
    }
    
    
}
