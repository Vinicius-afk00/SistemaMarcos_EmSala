/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.MpvClientes;
/**
 *
 * @author Vinicius
 */
public class ClienteTableModel extends AbstractTableModel{
    private List clientes;
    
    /**
     * @return the clientes
     */
    public List getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List clientes) {
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpvClientes cliente = (MpvClientes) this.clientes.get(rowIndex);
        if(columnIndex == 0)
            return cliente.getId_cliente();
        if(columnIndex == 1)
            return cliente.getNome();
        if(columnIndex == 2)
            return cliente.getCpf();
        else
        return "";
    }
}
