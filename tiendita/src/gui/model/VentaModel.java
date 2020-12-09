/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import data.VentaData;
import entities.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jhoselyn
 */
public class VentaModel extends AbstractTableModel{
    
    private List<Venta> listVenta = new ArrayList();
    private String[] columns = {"N", "Descripcion", "precio"};
    private Class[] columnsType = {Integer.class, String.class, Float.class};
    
    public VentaModel(){
        /*listVenta = VentaData.list("");*/
    }
    
    public VentaModel(Venta v){
        
    }
    

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
