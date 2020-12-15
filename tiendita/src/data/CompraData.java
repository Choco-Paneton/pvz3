
package data;

import entities.Compra;
import entities.Producto;

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
    
    public static List<Compra> list(String filter, Date fi, Date ff) {
        
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
                
        String fechati = null;
        if (fi == null) {
            fechati = currentTime;
        } else {
            fechati = sdf.format(fi);
        }
        
        String fechat = null;
        if (ff == null) {
            fechat = currentTime;
        } else {
            fechat = sdf.format(ff);
        }
        
        List<Compra> ls = new ArrayList();
        String sql = "";
        
        if (filtert.equals("")) {
             sql = "SELECT * FROM Compra "
                    + " WHERE strftime('%Y-%m-%d', fecha_compra) >= strftime('%Y-%m-%d', '" + fechati + "') "
                    + " AND strftime('%Y-%m-%d', fecha_compra) <= strftime('%Y-%m-%d', '" + fechat + "') "
                    + "ORDER BY fecha_compra";
        } else {
            sql = "SELECT * FROM Compra WHERE (id_compra LIKE '" + filtert + "%')"
                    + " AND strftime('%Y-%m-%d', fecha_compra) >= strftime('%Y-%m-%d', '" + fechati + "') "
                    + " AND strftime('%Y-%m-%d', fecha_compra) <= strftime('%Y-%m-%d', '" + fechat + "') "
                    + "ORDER BY fecha_compra";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Compra d = new Compra();
                d.setId_compra(rs.getInt("id_compra"));
                d.setProveedor_id(rs.getInt("proveedor_id"));
                try {
                    d.setFecha_compra(sdf.parse(rs.getString("fecha_compra")));
                } catch (Exception e) {
                    
                }
                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
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
