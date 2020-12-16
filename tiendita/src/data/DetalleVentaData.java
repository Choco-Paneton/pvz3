
package data;

import entities.DetalleVenta;

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

public class DetalleVentaData {
    
    static Connection cn = Coon_sqlite.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(DetalleVentaData.class.getName());
    
    
    public static int create(DetalleVenta d){
        
        int rsId_detalleventa = 0;
        String[] returns = {"id_detalleventa"};
        String sql = "INSERT INTO DetalleCompra(cantidad, precio_unitario, precio_total_producto, venta_id, producto_id)"
                + " "
                + "VALUES(?,?,?,?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setInt(++i, d.getCantidad());
            ps.setFloat(++i, d.getPrecio_unitario());
            ps.setFloat(++i, d.getPrecio_total_producto());
            ps.setInt(++i, d.getVenta_id());
            ps.setInt(++i, d.getProducto_id());
            rsId_detalleventa = ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId_detalleventa = rs.getInt(1);
                }
                rs.close();
            }
            
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "create", ex);
        }
        return rsId_detalleventa;
    }
    
    public static int update(DetalleVenta d) {
        int comit = 0;
        String sql = "UPDATE detalle_compra SET "
                + "cantidad=?, "
                + "precio_unitario=?, "
                + "precio_total_producto=?, "
                + "venta_id=?"
                + "producto_id=? "
                + "WHERE id_detalleventa=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, d.getCantidad());
            ps.setFloat(++i, d.getPrecio_unitario());
            ps.setFloat(++i, d.getPrecio_total_producto());
            ps.setInt(++i, d.getVenta_id());
            ps.setInt(++i, d.getProducto_id());
          
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }
    
    public static int delete(int id_detalleventa)  throws Exception{
        int comit = 0;
        String sql = "DELETE FROM DetalleVenta WHERE id_detalleventa = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id_detalleventa);
            comit = ps.executeUpdate();
            
            /*try {
                    d.setFecha(sdf.parse(rs.getString("fecha")));
                } catch (Exception e) {
                }*/
            
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Producto_id:" + ex.getMessage());
        }
        return comit;
    }
    
    public static List<DetalleVenta> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }

        List<DetalleVenta> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM detalle_venta ORDER BY id_detalleventa";
        } else {
            sql = "SELECT * FROM detalle_venta WHERE (id_detalleventa LIKE'" + filter + "%' OR "
                    + "cantidad LIKE'" + filter + "%' OR "
                    + "id_detalleventa LIKE'" + filter + "%') "
                    + "ORDER BY id_detalleventa";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DetalleVenta d = new DetalleVenta();
                d.setId_detalleventa(rs.getInt("id_detalleventa"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setPrecio_unitario(rs.getFloat("precio_unitario"));
                d.setPrecio_total_producto(rs.getFloat("precio_total_producto"));
                d.setVenta_id(rs.getInt("venta_id"));
                d.setProducto_id(rs.getInt("producto_id"));
                //d.setActivo(rs.getInt("activo"));
                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }
    
    public static DetalleVenta getById(int id_detalleventa){
        DetalleVenta vd = new DetalleVenta();
        String sql = "SELECT * FROM detalle_venta WHERE id_detalleventa = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id_detalleventa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vd.setId_detalleventa(rs.getInt("id_detalleventa"));
                vd.setCantidad(rs.getInt("cantidad"));
                vd.setPrecio_unitario(rs.getFloat("precio_unitario"));
                vd.setPrecio_total_producto(rs.getFloat("precio_total_producto"));
                vd.setVenta_id(rs.getInt("venta_id"));
                vd.setProducto_id(rs.getInt("producto_id"));
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return vd;
    }
    
    public static List<DetalleVenta> listByVenta(int id_detalleventa){
        List<DetalleVenta> lvd = new ArrayList();
        String sql = "";
        
        sql = "SELECT * FROM detalleventa "
                + "WHERE venta_id = " + id_detalleventa + " ORDER BY id_detalleventa";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DetalleVenta d = new DetalleVenta();
                d.setId_detalleventa(rs.getInt("id_detalleventa"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setPrecio_unitario(rs.getFloat("precio_unitario"));
                d.setPrecio_total_producto(rs.getFloat("precio_total_producto"));
                d.setVenta_id(rs.getInt("venta_id"));
                d.setProducto_id(rs.getInt("producto_id"));
                lvd.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        
        return lvd;
    }

}
