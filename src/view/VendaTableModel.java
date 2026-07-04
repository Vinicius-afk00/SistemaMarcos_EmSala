/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.MpvVenda;

/**
 *
 * @author Vinicius
 */
public class VendaTableModel extends AbstractTableModel{
    private List vendas;

    /**
     * @return the vendas
     */
    public List getVendas() {
        return vendas;
    }

    /**
     * @param vendas the vendas to set
     */
    public void setVendas(List vendas) {
        this.vendas = vendas;
    }

    @Override
    public int getRowCount() {
        return vendas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpvVenda venda = (MpvVenda) this.vendas.get(rowIndex);
        if(columnIndex == 0)
            return venda.getId_pedido();
        if(columnIndex == 1)
            return venda.getData();
        if(columnIndex == 2)
            return venda.getTotal();
        if(columnIndex == 3)
            return venda.getId_cliente();
        if(columnIndex == 4)
            return venda.getId_vendedor();
        else
        return "";
    }

    
}
