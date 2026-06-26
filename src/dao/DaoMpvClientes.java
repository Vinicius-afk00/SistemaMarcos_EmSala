/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            
            String sql = "INSERT INTO cliente "
                    + "(id_cliente, nome, cpf, email, telefone)"
                    + " VALUES (?,?,?,?,?);";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, mpvClientes.getId_cliente());
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
        try {
            MpvClientes mpvClientes = (MpvClientes) object;
            String sql = "UPDATE cliente SET nome=?, cpf=?, email=?, telefone=? WHERE id_cliente=?";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setString(1, mpvClientes.getNome());
            pst.setString(2, mpvClientes.getCpf());
            pst.setString(3, mpvClientes.getEmail());
            pst.setString(4, mpvClientes.getTelefone());
            pst.setInt(5, mpvClientes.getId_cliente());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        try {
            MpvClientes mpvClientes = (MpvClientes) object;
            String sql = "DELETE FROM cliente WHERE id_cliente=?";
            PreparedStatement smt = cnt.prepareStatement(sql);
            smt.setInt(1, mpvClientes.getId_cliente());
            smt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        try {
            String sql = "SELECT * FROM cliente WHERE id_cliente=?";
            MpvClientes cliente = null;
            
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                cliente = new MpvClientes();
                
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
            }
            
            return cliente ;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Object listAll() {
        List<MpvClientes> lista = new ArrayList<>();
        try {
            String sql = "Select * from cliente";
            
            PreparedStatement smt = cnt.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            
            while(rs.next()){
                MpvClientes cliente = new MpvClientes();
                
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                lista.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
