/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.MpvUsuarios;

/**
 *
 * @author u08538003160
 */
public class UsuarioTableModel extends AbstractTableModel{
    private List usuarios;

    /**
     * @return the usuarios
     */
    public List getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpvUsuarios usuario = (MpvUsuarios) usuarios.get(rowIndex);
        if(columnIndex == 0)
            return usuario.getMpvIdUsuarios();
        if(columnIndex == 1)
            return usuario.getMpvNome();
        if(columnIndex == 2)
            return usuario.getMpvCpf();
        else
        return "";
    }
}
