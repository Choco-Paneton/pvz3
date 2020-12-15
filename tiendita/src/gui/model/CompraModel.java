
package gui.model;

import data.CompraData;
import entities.Compra;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import util.Config;

public class CompraModel extends AbstractTableModel {

    private List<Compra> lis = new ArrayList();
    private String[] columns = {"#", "id compra", "Fecha de la compra"};
    private Class[] columnsType = {Integer.class, Integer.class, String.class};
    static SimpleDateFormat dfIGU = new SimpleDateFormat(Config.DEFAULT_DATE_STRING_FORMAT_PE);
    
    public CompraModel(String filter, Date fi, Date ff) {
        lis = CompraData.list(filter, fi, ff);
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        Compra d = (Compra) lis.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return d.getId_compra();
            case 2:
                return dfIGU.format( d.getFecha_compra());
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        //Producto c = (Producto) lis.get(row);
        if (column >= 0 && column != 0) {
            //return true;
        }
        return false;//bloquear edicion
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
        return lis.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    public Object getRow(int row) {
        this.fireTableRowsUpdated(row, row);
        return lis.get(row);
    }
}
