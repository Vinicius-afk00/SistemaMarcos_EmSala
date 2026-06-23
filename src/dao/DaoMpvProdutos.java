/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MpvProdutos;

/**
 *
 * @author Vinicius
 */
public class DaoMpvProdutos extends DaoAbstract{
    Connection cnt;
    public DaoMpvProdutos(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
            user = "marcos_vilhanueva";
            password = "marcos_vilhanueva";
            cnt = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvProdutos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMpvProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean insert(Object object) {
        MpvProdutos mpvProdutos = (MpvProdutos) object;
        try {
            
            String sql = "INSERT INTO produtos "
                    + "(id_poduto, descricao, tipo, unidade, preco)"
                    + " VALUES (?,?,?,?,?);";
            PreparedStatement pst = cnt.prepareStatement(sql);
            //pst.setInt(1, mpvUsuarios.getMpvIdUsuarios());
            pst.setInt(1, mpvProdutos.getId_produto());
            pst.setString(2, mpvProdutos.getDescricao());
            pst.setString(3, mpvProdutos.getTipo());
            pst.setString(4, mpvProdutos.getUnidade());
            pst.setString(5, mpvProdutos.getPreco());
            pst.executeUpdate();
            
            } catch (SQLException ex) {
            Logger.getLogger(DaoMpvProdutos.class.getName()).log(Level.SEVERE, null, ex);
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
