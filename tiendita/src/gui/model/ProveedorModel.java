
package gui.model;

import data.ProveedorData;
import entities.Categoria;
import entities.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProveedorModel extends AbstractTableModel {

    private List<Proveedor> list = new ArrayList();
    private String[] columns = {"Id","Id Persona", "ruc", "email", "telefono"};
    private Class[] columnsType = {Integer.class, Integer.class, String.class, String.class, String.class};

    public ProveedorModel() {
        list = ProveedorData.list("");
    }
    public ProveedorModel(String filter) {

        list = ProveedorData.list(filter);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Proveedor p = (Proveedor) list.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return p.getPersona_id();
            case 2:
                return p.getRuc();
            case 3:
                return p.getEmail();
            case 4:
                return p.getTelefono();
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
