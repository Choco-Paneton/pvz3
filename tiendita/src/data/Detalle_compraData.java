
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
                + "cantidad=?, "
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
     
    public static int delete(int id)  throws Exception{
        int comit = 0;
        String sql = "DELETE FROM detalle_compra WHERE id = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
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
     
    public static List<Detalle_compra> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<Detalle_compra> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM detalle_compra ORDER BY id";
        } else {
            sql = "SELECT * FROM detalle_compra WHERE (id LIKE'" + filter + "%' OR "
                    + "cantidad LIKE'" + filter + "%' OR "
                    + "id LIKE'" + filter + "%') "
                    + "ORDER BY id";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Detalle_compra d = new Detalle_compra();
                d.setId(rs.getInt("id"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setPrecio_unitario(rs.getFloat("precio_unitario"));
                d.setPrecio_total_producto(rs.getFloat("precio_total_producto"));
                d.setCompra_id(rs.getInt("compra_id"));
                d.setProducto_id(rs.getInt("producto_id"));
                //d.setActivo(rs.getInt("activo"));
                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }
     
    public static Detalle_compra getById(int id) {
        Detalle_compra d = new Detalle_compra();
        int i = 0;
        String sql = "SELECT * FROM detalle_compra WHERE id = ? ";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setPrecio_unitario(rs.getFloat("precio_unitario"));
                d.setPrecio_total_producto(rs.getFloat("precio_total_producto"));
                d.setCompra_id(rs.getInt("compra_id"));
                d.setProducto_id(rs.getInt("producto_id"));
                /*try {
                    d.setFecha(sdf.parse(rs.getString("fecha")));
                } catch (Exception e) {
                }*/
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return d;
    }

}
