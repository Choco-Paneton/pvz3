
package data;

import entities.Detalle_compra;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import util.ErrorLogger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import org.sqlite.SQLiteConfig;

public class Detalle_compraData {
    
    static Connection cn = Coon_sqlite.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(Detalle_compraData.class.getName());
    
    public static int create(Detalle_compra d){
        
        int rsId = 0;
        String[] returns = {"id"};
        String sql = "INSERT INTO detalle_compra(cantidad, precio_unitario, precio_total_producto, compra_id, producto_id)"
                + " "
                + "VALUES(?,?,?,?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setInt(++i, d.getCantidad());
            ps.setFloat(++i, d.getPrecio_unitario());
            ps.setFloat(++i, d.getPrecio_total_producto());
            
            ps.setInt(++i, d.getCompra_id());
            ps.setInt(++i, d.getProducto_id());
            rsId = ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId = rs.getInt(1);
                }
                rs.close();
            }
            
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "create", ex);
        }
        return rsId;
    }
    
    
     public static int update(Detalle_compra d) {
        int comit = 0;
        String sql = "UPDATE detalle_compra SET "
                + "contidad=?, "
                + "precio_unitario=?, "
                + "precio_total_producto=?, "
                + "compra_id=?, "
                + "producto_id=? "
                + "WHERE id=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, d.getCantidad());
            ps.setFloat(++i, d.getPrecio_unitario());
            ps.setFloat(++i, d.getPrecio_total_producto());
            
            ps.setInt(++i, d.getCompra_id());
            ps.setInt(++i, d.getProducto_id());
          
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }

}
