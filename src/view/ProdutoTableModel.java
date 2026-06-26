/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.MpvProdutos;
/**
 *
 * @author Vinicius
 */
public class ProdutoTableModel extends AbstractTableModel{
    private List produtos;
    
    /**
     * @return the produto
     */
    public List getProduto() {
        return produtos;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(List produto) {
        this.produtos = produto;
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MpvProdutos produto = (MpvProdutos) this.produtos.get(rowIndex);
        if(columnIndex == 0)
            return produto.getId_produtos();
        if(columnIndex == 1)
            return produto.getDescricao();
        if(columnIndex == 2)
            return produto.getPreco();
        else
        return "";
    }
}
