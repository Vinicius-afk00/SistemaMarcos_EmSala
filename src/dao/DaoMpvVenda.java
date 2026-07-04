/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MpvVenda;

/**
 *
 * @author Vinicius
 */
public class DaoMpvVenda extends DaoAbstract{
    
    Connection cnt;
    public DaoMpvVenda(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
            user = "marcos_vilhanueva";
            password = "marcos_vilhanueva";
            cnt = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvVenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMpvVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean insert(Object object) {
        MpvVenda mpvVenda = new MpvVenda();
        try {
            
            String sql = "INSERT INTO venda "
                    + "(id_pedido, data, total, id_cliente, id_vendedor)"
                    + " VALUES (?,?,?,?,?);";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, mpvVenda.getId_pedido());
            pst.setDate(2, (Date) mpvVenda.getData());
            pst.setDouble(3, mpvVenda.getTotal());
            pst.setInt(4, mpvVenda.getId_cliente());
            pst.setInt(5, mpvVenda.getId_vendedor());
            pst.executeUpdate();
            
            } catch (SQLException ex) {
            Logger.getLogger(DaoMpvVenda.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
       return true; 
    }

    @Override
    public void update(Object object) {
        try {
            MpvVenda mpvVenda = (MpvVenda) object;
            String sql = "UPDATE venda SET data=?, total=?, id_cliente=?, id_vendedor=? WHERE id_pedido=?";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setDate(1, (Date) mpvVenda.getData());
            pst.setDouble(2, mpvVenda.getTotal());
            pst.setInt(3, mpvVenda.getId_cliente());
            pst.setInt(4, mpvVenda.getId_vendedor());
            pst.setInt(5, mpvVenda.getId_pedido());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        try {
            MpvVenda mpvVenda = (MpvVenda) object;
            String sql = "DELETE FROM venda WHERE id_pedido=?";
            PreparedStatement smt = cnt.prepareStatement(sql);
            smt.setInt(1, mpvVenda.getId_pedido());
            smt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        try {
            String sql = "SELECT * FROM venda WHERE id_pedido=?";
            MpvVenda venda = null;
            
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                venda = new MpvVenda();
                
                venda.setId_pedido(rs.getInt("id_pedido"));
                venda.setData(rs.getDate("data"));
                venda.setTotal(rs.getDouble("total"));
                venda.setId_cliente(rs.getInt("id_cliente"));
                venda.setId_vendedor(rs.getInt("id_vendedor"));
            }
            
            return venda ;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Object listAll() {
        List<MpvVenda> lista = new ArrayList<>();
        try {
            String sql = "Select * from venda";
            
            PreparedStatement smt = cnt.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            
            while(rs.next()){
                MpvVenda venda = new MpvVenda();
                
                venda.setId_pedido(rs.getInt("id_pedido"));
                venda.setData(rs.getDate("data"));
                venda.setTotal(rs.getDouble("total"));
                venda.setId_cliente(rs.getInt("id_cliente"));
                venda.setId_vendedor(rs.getInt("id_vendedor"));
                lista.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
