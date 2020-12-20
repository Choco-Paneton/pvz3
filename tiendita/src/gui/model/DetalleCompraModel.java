
package gui.model;

import data.DetalleCompraData;
import entities.Compra;
import entities.DetalleCompra;
import entities.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DetalleCompraModel extends AbstractTableModel {

    private List<DetalleCompra> lis = new ArrayList();
    private String[] columns = {"#", "Id detalle", "Producto", "Precio unitario"};
    private Class[] columnsType = {Integer.class, Integer.class, String.class, Float.class};

    public DetalleCompraModel() {
        
    }

    public DetalleCompraModel(Compra d) {
        lis = DetalleCompraData.listByCompra(d.getId_compra());//relación al proveedor
        lis.add(new DetalleCompra());
    }
    
    public DetalleCompraModel(String filter) {

        lis = DetalleCompraData.list(filter);//busqueda
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        DetalleCompra d = (DetalleCompra) lis.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return d.getId_detallecompra();
            case 2:
                return d.getProducto();
            case 3:
                return d.getPrecio_unitario();
            default:
                return null;
        }
    }
/*
    @Override
    public void setValueAt(Object valor, int row, int column) {
        VentaLinea d = (VentaLinea) lis.get(row);
        switch (column) {

            case 3:

                System.out.println("setValueAt : " + "" + valor);
                double gr = 0;
                try {
                    gr = Double.parseDouble(valor + ""); //hacer Double
                } catch (NumberFormatException nfe) {
                    System.err.println("" + nfe);
                }
                d.setCant(gr);
                break;
        }
        this.fireTableRowsUpdated(row, row);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        VentaLinea d = (VentaLinea) lis.get(row);
        if (d.getProd_id() > 0 && d.getActivo() == 1) {//indica si hay siquiera un producto
            if (column != 0 && column != 1 && column != 2 && column != 4) { // editar solo la col 3
                return true;
            }
        } else if (d.getProd_id() == 0) {
            if (column == this.columns.length - 1) {//indica que no hay nada para modificar
                return true;
            }
        }
        return false;//bloquear edicion
    }
*/
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
    
    public Object getRow(int row) { // usado para paintForm
        this.fireTableRowsUpdated(row, row);
        return lis.get(row);
    }
}
