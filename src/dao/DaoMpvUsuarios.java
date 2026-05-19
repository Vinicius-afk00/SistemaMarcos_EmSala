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
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import testes.JdbcSelect;

/**
 *
 * @author u08538003160
 */
public class DaoMpvUsuarios extends DaoAbstract{

    @Override
    public boolean insert(Object object) {
        MpvUsuarios mpvUsuarios = (MpvUsuarios) object;
       try {
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
            user = "marcos_vilhanueva";
            password = "marcos_vilhanueva";
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO mpv_usuarios "
                    + "(mpv_nome, mpv_apelido, mpv_cpf, mpv_dataNascimento, mpv_nivel, mpv_senha, mpv_ativo)"
                    + " VALUES (?,?,?,?,?,?,?);";
            PreparedStatement pst = cnt.prepareStatement(sql);
            //pst.setInt(1, mpvUsuarios.getMpvIdUsuarios());
            pst.setString(1, mpvUsuarios.getMpvNome());
            pst.setString(2, mpvUsuarios.getMpvApelido());
            pst.setString(3, mpvUsuarios.getMpvCpf());
            pst.setDate(4, (Date) mpvUsuarios.getMpvDataNascimento());//mpv_dta_nascimento
            pst.setInt(5, mpvUsuarios.getMpvNivel());
            pst.setString(6, mpvUsuarios.getMpvSenha());
            pst.setString(7, mpvUsuarios.getMpvAtivo());
            pst.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoMpvUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
       return true;
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
