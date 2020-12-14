
package data;

import entities.Compra;

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

public class CompraData {
    
    static Connection cn = Coon_sqlite.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(CompraData.class.getName());
    
    static SimpleDateFormat sdf = new SimpleDateFormat(SQLiteConfig.DEFAULT_DATE_STRING_FORMAT);
    
    static Date dateNowBuy = new Date();
    static String currentTime = sdf.format(dateNowBuy);
    
    public static int create(Compra o) {
        int rsId_compra = 0;
        String[] returns = {"id_compra"};
        String sql = "INSERT INTO Compra (fecha_venta, cliente_id)"
                + " "
                + "VALUES(?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, currentTime);
            ps.setInt(++i, o.getProveedor_id());
            rsId_compra = ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId_compra = rs.getInt(1);
                }
                rs.close();
                
            /*try {
                    d.setFecha(sdf.parse(rs.getString("fecha")));
                } catch (Exception e) {
                }*/
            }
            
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "create", ex);
        }
        return rsId_compra;
    }
    
    public static int update(Compra o) {
        int comit = 0;
        String sql = "UPDATE Compra SET "
                + "fecha_compra=?, "
                + "proveedor_id=? "
                + "WHERE id_compra=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, sdf.format(o.getFecha_compra()));
            ps.setInt(++i, o.getProveedor_id());
            ps.setInt(++i, o.getId_compra());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }
    
    
    public static int delete(int id_compra)  throws Exception{
        int comit = 0;
        String sql = "DELETE FROM compra WHERE id_compra= ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id_compra);
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
    
    public static List<Compra> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        
        List<Compra> listVenta = new ArrayList();
        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT o.*, r.ruc, p.nombre, p.apellido_paterno, p.apellido_materno FROM COMPRA as o"
                   + "INNER JOIN Proveedor as r On r.id = o.proveedor_id "
                   + "INNER JOIN Persona as p On p.id = r.persona_id "
                   + "ORDER BY p.nombre ";
        } else {
            sql = "SELECT o.*, r.ruc, p.nombre, p.apellido_paterno, p.apellido_materno FROM VENTA as "
                   + "INNER JOIN Proveedor as r On r.id = o.proveedor_id "
                   + "INNER JOIN Persona as p On p.id = r.persona_id "
                   + "where (r.ruc LIKE'" + filter + "%' OR "
                   + " p.nombre LIKE'" + filter + "%' OR "
                   + " p.apellido_paterno LIKE'" + filter + "%' OR "
                   + " p.apellido_materno LIKE'" + filter + "%') "
                   + "ORDER BY p.nombre ";
     
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Compra o = new Compra();
                o.setId_compra(rs.getInt("id_compra"));
                o.setFecha_compra(rs.getDate("fecha_venta"));
                /*try {
                    d.setFecha(sdf.parse(rs.getString("fecha")));
                } catch (Exception e) {
                }*/
                listVenta.add(o);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return listVenta;
    }
    
    public static Compra getById(int id_compra) {
        Compra o = new Compra();
        int i = 0;
        String sql = "SELECT * FROM venta WHERE id_compra= ? ";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id_compra);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                o.setId_compra(rs.getInt("id_compra"));
                o.setFecha_compra(rs.getDate("fecha_compra"));
                o.setProveedor_id(rs.getInt("proveedor_id"));
                /*try {
                    d.setFecha(sdf.parse(rs.getString("fecha")));
                } catch (Exception e) {
                }*/
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return o;
    }

}
