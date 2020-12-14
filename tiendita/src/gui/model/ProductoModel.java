
package gui.model;

import data.ProductoData;
import entities.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProductoModel extends AbstractTableModel {

    private List<Producto> list = new ArrayList();
    private String[] columns = {"Id", "Producto", "Descripción", "Cantidad", "Status", "Igv", "Precio unitario", "Precio subtotal"};
    private Class[] columnsType = {Integer.class, String.class, String.class, Integer.class, String.class, String.class, Float.class, Float.class};

    public ProductoModel() {
        list = ProductoData.list("");
    }

    public ProductoModel(String filter) {

        list = ProductoData.list(filter);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Producto p = (Producto) list.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return p.getNombre_producto();
            case 2:
                return p.getDescripcion();
            case 3:
                return p.getCantidad();
            case 4:
                if (p.isStatus()) {
                    return "si";
                }
                return "no";
            case 5:
                if (p.isIgv()) {
                    return "si";
                }
                return "no";
            case 6:
                return p.getPrecio_unitario();
            case 7:
                return p.getPrecio_sub_total();
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