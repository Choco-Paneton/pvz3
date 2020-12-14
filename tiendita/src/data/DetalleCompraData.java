
package data;

import entities.DetalleCompra;

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

public class DetalleCompraData {
    
    static Connection cn = Coon_sqlite.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(DetalleCompraData.class.getName());
    
    public static int create(DetalleCompra d){
        
        int rsId_detallecompra = 0;
        String[] returns = {"id_detallecompra"};
        String sql = "INSERT INTO DetalleCompra(cantidad, precio_unitario, precio_total_producto, compra_id, producto_id)"
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
            rsId_detallecompra = ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId_detallecompra = rs.getInt(1);
                }
                rs.close();
            }
            
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "create", ex);
        }
        return rsId_detallecompra;
    }
    
    
    public static int update(DetalleCompra d) {
        int comit = 0;
        String sql = "UPDATE DetalleCompra SET "
                + "cantidad=?, "
                + "precio_unitario=?, "
                + "precio_total_producto=?, "
                + "compra_id=?, "
                + "producto_id=? "
                + "WHERE id_detallecompra=?";
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
     
    public static int delete(int id_detallecompra)  throws Exception{
        int comit = 0;
        String sql = "DELETE FROM DetalleCompra WHERE id_detallecompra= ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id_detallecompra);
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
     
    public static List<DetalleCompra> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<DetalleCompra> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM DetalleCompra ORDER BY id_detallecompra";
        } else {
            sql = "SELECT * FROM detalle_compra WHERE (id_detallecompra LIKE'" + filter + "%' OR "
                    + "cantidad LIKE'" + filter + "%' OR "
                    + "id_detallecompra LIKE'" + filter + "%') "
                    + "ORDER BY id_detallecompra";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DetalleCompra d = new DetalleCompra();
                d.setId_detallecompra(rs.getInt("id_detallecompra"));
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
     
    public static DetalleCompra getById(int id_detallecompra) {
        DetalleCompra d = new DetalleCompra();
        int i = 0;
        String sql = "SELECT * FROM detalle_compra WHERE id_detallecompra= ? ";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id_detallecompra);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d.setId_detallecompra(rs.getInt("id_detallecompra"));
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
