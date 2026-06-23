/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MpvClientes;

/**
 *
 * @author Vinicius
 */
public class DaoMpvClientes extends DaoAbstract{
    Connection cnt;
    public DaoMpvClientes(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
            user = "marcos_vilhanueva";
            password = "marcos_vilhanueva";
            cnt = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMpvClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean insert(Object object) {
        MpvClientes mpvClientes = (MpvClientes) object;
        try {
            
            String sql = "INSERT INTO clientes "
                    + "(id_cliente, nome, cpf, email, telefone)"
                    + " VALUES (?,?,?,?,?);";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, mpvClientes.getId_cliete());
            pst.setString(2, mpvClientes.getNome());
            pst.setString(3, mpvClientes.getCpf());
            pst.setString(4, mpvClientes.getEmail());
            pst.setString(5, mpvClientes.getTelefone());
            pst.executeUpdate();
            
            } catch (SQLException ex) {
            Logger.getLogger(DaoMpvClientes.class.getName()).log(Level.SEVERE, null, ex);
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
