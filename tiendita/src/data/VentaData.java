
package data;

import entities.Venta;

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


public class VentaData {
    static Connection cn = Coon_sqlite.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(VentaData.class.getName());  
    
    static SimpleDateFormat sdf = new SimpleDateFormat(SQLiteConfig.DEFAULT_DATE_STRING_FORMAT);
    
    static Date dateNowSale = new Date();
    static String currentTime = sdf.format(dateNowSale);
    
    public static int create(Venta v) {
        int rsId = 0;
        String[] returns = {"id"};
        String sql = "INSERT INTO venta(fecha_venta, cliente_id)"
                + " "
                + "VALUES(?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, currentTime);
            ps.setInt(++i, v.getCliente_id());
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
    
    public static int update(Venta v) {
        int comit = 0;
        String sql = "UPDATE venta SET "
                + "fecha_venta=?, "
                + "cliente_id=? "
                + "WHERE id=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, sdf.format(v.getFecha_venta()));
            ps.setInt(++i, v.getCliente_id());
            ps.setInt(++i, v.getId());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }
    
    public static int delete(int id)  throws Exception{
        int comit = 0;
        String sql = "DELETE FROM venta WHERE id = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Cliente_id:" + ex.getMessage());
        }
        return comit;
    }
    
    public static List<Venta> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        
        List<Venta> listVenta = new ArrayList();
        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT v.*, c.ruc, p.nombre, p.apellido_paterno, p.apellido_materno FROM VENTA as v"
                   + "INNER JOIN Cliente as c On c.id = v.cliente_id "
                   + "INNER JOIN Persona as p On p.id = c.persona_id "
                   + "ORDER BY p.nombre ";
        } else {
            sql = "SELECT v.*, c.ruc, p.nombre, p.apellido_paterno, p.apellido_materno FROM VENTA as "
                   + "INNER JOIN Cliente as c On c.id = v.cliente_id "
                   + "INNER JOIN Persona as p On p.id = c.persona_id "
                   + "where (c.ruc LIKE'" + filter + "%' OR "
                   + " p.nombre LIKE'" + filter + "%' OR "
                   + " p.apellido_paterno LIKE'" + filter + "%' OR "
                   + " p.apellido_materno LIKE'" + filter + "%') "
                   + "ORDER BY p.nombre ";
     
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Venta v = new Venta();
                v.setId(rs.getInt("id"));
                v.setFecha_venta(rs.getDate("fecha_venta"));
                /*try {
                    d.setFecha(sdf.parse(rs.getString("fecha")));
                } catch (Exception e) {
                }*/
                listVenta.add(v);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return listVenta;
    }
    
    public static Venta getById(int id) {
        Venta v = new Venta();
        int i = 0;
        String sql = "SELECT * FROM venta WHERE id = ? ";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setFecha_venta(rs.getDate("fecha_venta"));
                v.setCliente_id(rs.getInt("cliente_id"));
                /*try {
                    d.setFecha(sdf.parse(rs.getString("fecha")));
                } catch (Exception e) {
                }*/
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return v;
    }
}
