
package gui.model;

import data.ClienteData;
import entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteModel extends AbstractTableModel {

    private List<Cliente> list = new ArrayList();
    private String[] columns = {"Id cliente", "ruc", "telefono", "email"};
    private Class[] columnsType = {Integer.class, String.class, String.class, String.class};

    public ClienteModel() {
        
        list = ClienteData.list("");
    }

    public ClienteModel(String filter) {

        list = ClienteData.list(filter);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Cliente c = (Cliente) list.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return c.getRuc();
            case 2:
                return c.getTelefono();
            case 3:
                return c.getEmail();
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