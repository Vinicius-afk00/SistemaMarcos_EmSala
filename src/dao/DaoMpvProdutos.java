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
                    + "(id_produtos, descricao, tipo, unidade, preco)"
                    + " VALUES (?,?,?,?,?);";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, mpvProdutos.getId_produtos());
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
        try {
            MpvProdutos mpvProdutos = (MpvProdutos) object;
            String sql = "UPDATE produtos SET descricao=?, tipo=?, unidade=?, preco=? WHERE id_produtos=?";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, mpvProdutos.getId_produtos());
            pst.setString(2, mpvProdutos.getDescricao());
            pst.setString(3, mpvProdutos.getTipo());
            pst.setString(4, mpvProdutos.getUnidade());
            pst.setString(5, mpvProdutos.getPreco());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        try {
            MpvProdutos mpvProdutos = (MpvProdutos) object;
            String sql = "DELETE FROM produtos WHERE id_produtos=?";
            PreparedStatement smt = cnt.prepareStatement(sql);
            smt.setInt(1, mpvProdutos.getId_produtos());
            smt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        try {
            String sql = "SELECT * FROM produtos WHERE id_produtos=?";
            MpvProdutos produto = null;
            
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                produto = new MpvProdutos();
                
                produto.setId_produtos(rs.getInt("id_produtos"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTipo(rs.getString("tipo"));
                produto.setUnidade(rs.getString("unidade"));
                produto.setPreco(rs.getString("preco"));
            }
            
            return produto ;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Object listAll() {
        List<MpvProdutos> lista = new ArrayList<>();
        try {
            String sql = "Select * from produtos";
            
            PreparedStatement smt = cnt.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            
            while(rs.next()){
                MpvProdutos produto = new MpvProdutos();
                
                produto.setId_produtos(rs.getInt("id_produtos"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTipo(rs.getString("tipo"));
                produto.setUnidade(rs.getString("unidade"));
                produto.setPreco(rs.getString("preco"));
                lista.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
