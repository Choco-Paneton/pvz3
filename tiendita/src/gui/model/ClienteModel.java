
package gui.model;

import data.ProductoData;
import entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteModel extends AbstractTableModel {

    private List<Cliente> list = new ArrayList();
    private String[] columns = {"Id cliente", "Id Persona", "ruc", "telefono", "email"};
    private Class[] columnsType = {Integer.class, Integer.class, String.class, String.class, String.class};

    public ClienteModel() {
        
        //list = ProductoData.list("");
    }

    public ClienteModel(String filter) {

        //list = ProductoData.list(filter);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Cliente c = (Cliente) list.get(row);
        switch (column) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return "s";
            case 3:
                return "s";
            case 4:
                return "s";
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
}