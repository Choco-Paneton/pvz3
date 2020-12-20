package gui.profe;

import data.VentaData;
import gui.profe.data.VentaLineaDatas;
import entities.Venta;
import entities.VentaLineaProfe;
import entities.VentaProfe;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VentaLineasTableModel extends AbstractTableModel {

    private List<VentaLineaProfe> lis = new ArrayList();
    private String[] columns = {"#", "Producto", "Precio un", "Cantidad", "Subtotal", "Acciones"};
    private Class[] columnsType = {Integer.class, String.class, Double.class, Double.class, Double.class, Object.class};

    public VentaLineasTableModel() {
            
    }

    public VentaLineasTableModel(VentaProfe d) {
        this.lis = VentaLineaDatas.listByVenta(d.getId());//trae la lista, remplaza en "lis", con relación al cliente
        this.lis.add(new VentaLineaProfe());//agrega una fila a la tabla
    }

    public VentaLineasTableModel(String filter) {

        lis = VentaLineaDatas.list(filter);//busqueda
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        VentaLineaProfe d = (VentaLineaProfe) lis.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return d.getDescripcion();
            case 2:
                return d.getPrecio();
            case 3:
                return d.getCant();
            case 4:
                return d.getSubtotal();
            case 5:
                return "Add/delete";
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object valor, int row, int column) {
        VentaLineaProfe d = (VentaLineaProfe) lis.get(row);
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
        VentaLineaProfe d = (VentaLineaProfe) lis.get(row);
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

    public void addRow(VentaLineaProfe d) { // con db no se usa
        this.lis.add(d);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lis.size(), lis.size());
    }

    public void removeRow(int linha) { // con db no se usa
        this.lis.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public Object getRow(int row) { // usado para paintForm
        this.fireTableRowsUpdated(row, row);
        return lis.get(row);
    }

}
