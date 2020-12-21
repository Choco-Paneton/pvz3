
package data;

import util.ErrorLogger;
import entities.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ProductoData {

    static Connection cn = Coon_sqlite.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ProductoData.class.getName());

    public static int create(Producto p) {
        int rsId_producto = 0;
        String[] returns = {"id_producto"};
        String sql = "INSERT INTO Producto(descripcion, nombre_producto, "
                + "cantidad, status, igv, precio_unitario, precio_sub_total, "
                + "categoria_id) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, p.getDescripcion());
            ps.setString(++i, p.getNombre_producto());
            ps.setInt(++i, p.getCantidad());
            ps.setBoolean(++i, p.isStatus());
            ps.setBoolean(++i, p.isIgv());
            ps.setFloat(++i, p.getPrecio_unitario());
            ps.setFloat(++i, p.getPrecio_sub_total());
            ps.setInt(++i, p.getCategoria_id());
            rsId_producto = ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId_producto = rs.getInt(1);
                }
                rs.close();
            }
            //ps.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "create", ex);
        } finally{
            //Coon_sqlite.closeSQLite(cn);
        }
        return rsId_producto;
    }

    public static int update(Producto p) {
        int comit = 0;
        String sql = "UPDATE Producto SET "
                + "descripcion=?, "
                + "nombre_producto=?, "
                + "cantidad=?, "
                + "status=?, "
                + "igv=?, "
                + "precio_unitario=?, "
                + "precio_sub_total=? "
                + "WHERE id_producto=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, p.getDescripcion());
            ps.setString(++i, p.getNombre_producto());
            ps.setInt(++i, p.getCantidad());
            ps.setBoolean(++i, p.isStatus());
            ps.setBoolean(++i, p.isIgv());
            ps.setFloat(++i, p.getPrecio_unitario());
            ps.setFloat(++i, p.getPrecio_sub_total());
            
            comit = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        } finally {
            Coon_sqlite.closeSQLite(cn);
        }
        return comit;
    }

    public static int delete(int id_producto) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM Producto WHERE id_producto = ? ";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id_producto);
            comit = ps.executeUpdate();
            //ps.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            throw new Exception("Detalle:" + ex.getMessage());
        } finally {
            //Coon_sqlite.closeSQLite(cn);
        }
        return comit;
    }

    public static List<Producto> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }

        List<Producto> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM Producto ORDER BY id_producto";
        } else {
            sql = "SELECT * FROM Producto WHERE (id_producto LIKE'" + filter + 
                    "%' OR " + "nombre_producto LIKE'" + filter + 
                    "%' OR " + "cantidad LIKE'" + filter + 
                    "%' OR " + "precio_unitario LIKE'" + filter + 
                    "%') "
                    + "ORDER BY id_producto";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Producto p = new Producto();
                p.setId_producto(rs.getInt("id_producto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setNombre_producto(rs.getString("nombre_producto"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setStatus(rs.getBoolean("status"));
                p.setIgv(rs.getBoolean("igv"));
                p.setPrecio_unitario(rs.getFloat("precio_unitario"));
                p.setPrecio_sub_total(rs.getFloat("precio_sub_total"));
                ls.add(p);
            }
            rs.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        } finally {
            //Coon_sqlite.closeSQLite(cn);
        }
        return ls;
    }

    public static Producto getByPId(int id_producto) {
        
        Producto p = new Producto();

        String sql = "SELECT * FROM Producto WHERE id_producto = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id_producto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setId_producto(rs.getInt("id_producto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setNombre_producto(rs.getString("nombre_producto"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setStatus(rs.getBoolean("status"));
                p.setIgv(rs.getBoolean("igv"));
                p.setPrecio_unitario(rs.getFloat("precio_unitario"));
                p.setPrecio_sub_total(rs.getFloat("precio_sub_total"));
            }
            //ps.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        } finally {
            //Coon_sqlite.closeSQLite(cn);
        }
        return p;
    }
}
