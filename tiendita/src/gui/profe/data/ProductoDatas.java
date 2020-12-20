package gui.profe.data;

import data.Coon_sqlite;
import entities.Producto;
import entities.ProductoProfe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.ErrorLogger;
import java.util.logging.Level;
import org.sqlite.SQLiteConfig;

public class ProductoDatas {

    static Connection cn = Coon_sqlite.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ProductoDatas.class.getName());//manejo de errores
    static SimpleDateFormat sdf = new SimpleDateFormat(SQLiteConfig.DEFAULT_DATE_STRING_FORMAT);
    
    
    static Date dt = new Date();//fecha actual, de tipo Date
    static String currentTime = sdf.format(dt);
    
    public static int create(ProductoProfe d) {
        int rsId = 0;
        String[] returns = {"id"};
        String sql = "INSERT INTO productos(nombre, detalle, precio, fecha_ven) "
                + "VALUES(?,?,?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, d.getNombre());
            ps.setString(++i, d.getDetalle());
            ps.setDouble(++i, d.getPrecio());
            System.out.println("d.getFecha_ven(): " + d.getFecha_ven());//tipo Date
            ps.setString(++i, sdf.format(d.getFecha_ven()));//tipo Date
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

    public static int update(ProductoProfe d) {
        System.out.println("actualizar d.getId(): " + d.getId());
        int comit = 0;
        String sql = "UPDATE productos SET "
                + "nombre=?, "
                + "detalle=?, "
                + "precio=?, "
                + "fecha_ven=? "
                + "WHERE id=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, d.getNombre());
            ps.setString(++i, d.getDetalle());
            ps.setDouble(++i, d.getPrecio());  
            System.out.println("u d.getFecha_ven(): " + d.getFecha_ven());
            ps.setString(++i, sdf.format(d.getFecha_ven()));
            ps.setInt(++i, d.getId());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }

    public static int delete(int id) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM productos WHERE id = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Detalle:" + ex.getMessage());
        }
        return comit;
    }

    public static List<ProductoProfe> listCmb(String filter) {
        List<ProductoProfe> ls = new ArrayList();
        ls.addAll(list(filter));
        return ls;
    }

    public static List<ProductoProfe> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<ProductoProfe> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM productos ORDER BY id";
        } else {
            sql = "SELECT * FROM productos WHERE (id LIKE'" + filter + "%' OR "
                    + "nombre LIKE'" + filter + "%' OR detalle LIKE'" + filter + "%' OR "
                    + "id LIKE'" + filter + "%') "
                    + "ORDER BY nombre";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ProductoProfe d = new ProductoProfe();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setDetalle(rs.getString("detalle"));
                d.setPrecio(rs.getDouble("precio"));
                try {
                    d.setFecha_ven(sdf.parse(rs.getString("fecha_ven")));//conversión de caracteres
                    //numericos a datos numericos.
                } catch (Exception e) {
                }
                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }
    public static List<ProductoProfe> list(String filter, Date fi, Date ff) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);
        
        
        String fechati = null;
        if (fi == null) {
            System.out.println("list.fechat: SIN FECHAAAiiiiii");
            fechati = currentTime;//fecha actual
        } else {
            fechati = sdf.format(fi);//fecha inicial, la cual el usuario ingresa
        }
        
        System.out.println("list.fechati:" + fechati);
        
        String fechat = null;
        if (ff == null) {
            System.out.println("list.fechat: SIN FECHAAA");
            fechat = currentTime;//fecha actual
        } else {
            fechat = sdf.format(ff);//fecha final, la cual el usuario ingresa
        }
        System.out.println("list.fechat:" + fechat);
        
        List<ProductoProfe> ls = new ArrayList();
        String sql = "";
        
        if (filtert.equals("")) {
             sql = "SELECT * FROM productos "
                    + " WHERE strftime('%Y-%m-%d', fecha_ven) >= strftime('%Y-%m-%d', '" + fechati + "') "
                    + " AND strftime('%Y-%m-%d', fecha_ven) <= strftime('%Y-%m-%d', '" + fechat + "') "
                    + "ORDER BY fecha_ven";
        } else {
            sql = "SELECT * FROM productos WHERE (id LIKE '" + filtert + "%'  "
                    + " OR nombre LIKE '" + filtert + "%' )"
                    + " AND strftime('%Y-%m-%d', fecha_ven) >= strftime('%Y-%m-%d', '" + fechati + "') "
                    + " AND strftime('%Y-%m-%d', fecha_ven) <= strftime('%Y-%m-%d', '" + fechat + "') "
                    + "ORDER BY fecha_ven";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ProductoProfe d = new ProductoProfe();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setDetalle(rs.getString("detalle"));
                d.setPrecio(rs.getDouble("precio"));
                try {
                    d.setFecha_ven(sdf.parse(rs.getString("fecha_ven")));
                } catch (Exception e) {
                }
                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }

    public static ProductoProfe getByPId(int id) {
        ProductoProfe d = new ProductoProfe();

        String sql = "SELECT * FROM productos WHERE id = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setDetalle(rs.getString("detalle"));
                d.setPrecio(rs.getDouble("precio"));
                try {
                    d.setFecha_ven(sdf.parse(rs.getString("fecha_ven")));
                } catch (Exception e) {
                }
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return d;
    }
}
