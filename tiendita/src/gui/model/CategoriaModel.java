
package gui.model;

import data.CategoriaData;
import data.ProductoData;
import entities.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CategoriaModel extends AbstractTableModel {

    private List<Categoria> list = new ArrayList();
    private String[] columns = {"Id", "Nombre categoria"};
    private Class[] columnsType = {Integer.class, String.class};

    public CategoriaModel() {
        list = CategoriaData.list("");
    }

    public CategoriaModel(String filter) {

        list = CategoriaData.list(filter);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Categoria p = (Categoria) list.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return p.getNombre_categoria();
            default:
                return null;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class getColumnClass(int column) {
        return columnsType[column];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    public Object getRow(int row) {
        this.fireTableRowsUpdated(row, row);
        return list.get(row);
    }
}
