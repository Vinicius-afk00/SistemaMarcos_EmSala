/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.MpvUsuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import testes.JdbcSelect;

/**
 *
 * @author u08538003160
 */
public class DaoMpvUsuarios extends DaoAbstract{
    Connection cnt;
    public DaoMpvUsuarios(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
            user = "marcos_vilhanueva";
            password = "marcos_vilhanueva";
            cnt = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMpvUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean insert(Object object) {
        MpvUsuarios mpvUsuarios = (MpvUsuarios) object;
       try {
            
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
            
            } catch (SQLException ex) {
            Logger.getLogger(DaoMpvUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
       return true; 
    }

    @Override
    public void update(Object object) {
        try {
            MpvUsuarios mpvUsuarios = (MpvUsuarios) object;
            String sql = "UPDATE mpv_usuarios SET mpv_nome=?, mpv_apelido=?, mpv_cpf=?, mpv_dataNascimento=?, mpv_nivel=?, mpv_senha=?, mpv_ativo=? WHERE mpv_idusuarios=?";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setString(1, mpvUsuarios.getMpvNome());
            pst.setString(2, mpvUsuarios.getMpvApelido());
            pst.setString(3, mpvUsuarios.getMpvCpf());
            pst.setDate(4, (Date) mpvUsuarios.getMpvDataNascimento());//mpv_dta_nascimento
            pst.setInt(5, mpvUsuarios.getMpvNivel());
            pst.setString(6, mpvUsuarios.getMpvSenha());
            pst.setString(7, mpvUsuarios.getMpvAtivo());
            pst.setInt(8, mpvUsuarios.getMpvIdUsuarios());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        try {
            MpvUsuarios mpvUsuarios = (MpvUsuarios) object;
            String sql = "DELETE FROM mpv_usuarios WHERE mpv_idusuarios=?";
            PreparedStatement smt = cnt.prepareStatement(sql);
            smt.setInt(1, mpvUsuarios.getMpvIdUsuarios());
            smt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        
        try {
            String sql = "SELECT * FROM mpv_usuarios WHERE mpv_idusuarios=?";
            MpvUsuarios usuario = null;
            
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                usuario = new MpvUsuarios();
                
                usuario.setMpvIdUsuarios(rs.getInt("mpv_idusuarios"));
                usuario.setMpvNome(rs.getString("mpv_nome"));
                usuario.setMpvApelido(rs.getString("mpv_apelido"));
                usuario.setMpvCpf(rs.getString("mpv_cpf"));
                usuario.setMpvDataNascimento(rs.getDate("mpv_dataNascimento"));
                usuario.setMpvNivel(rs.getInt("mpv_nivel"));
                usuario.setMpvSenha(rs.getString("mpv_senha"));
                usuario.setMpvAtivo(rs.getString("mpv_ativo"));
            }
            
            return usuario ;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Object listAll() {
        List<MpvUsuarios> lista = new ArrayList<>();
        try {
            String sql = "Select * from mpv_usuarios";
            
            PreparedStatement smt = cnt.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            
            while(rs.next()){
                MpvUsuarios usuario = new MpvUsuarios();
                
                usuario.setMpvIdUsuarios(rs.getInt("mpv_idusuarios"));
                usuario.setMpvNome(rs.getString("mpv_nome"));
                usuario.setMpvApelido(rs.getString("mpv_apelido"));
                usuario.setMpvCpf(rs.getString("mpv_cpf"));
                usuario.setMpvDataNascimento(rs.getDate("mpv_dataNascimento"));
                usuario.setMpvNivel(rs.getInt("mpv_nivel"));
                usuario.setMpvSenha(rs.getString("mpv_senha"));
                usuario.setMpvAtivo(rs.getString("mpv_ativo"));
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    
}
