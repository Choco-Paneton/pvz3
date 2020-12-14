
package data;

import entities.Proveedor;

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

public class ProveedorData {
    
    static Connection cn = Coon_sqlite.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ProveedorData.class.getName());  
    
    public static int create(Proveedor r){
        
        int rsId_proveedor = 0;
        String[] returns = {"id_proveedor"};
        String sql = "INSERT INTO Proveedor(ruc, email, telefono, persona_id)"
                + " "
                + "VALUES(?,?,?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, r.getRuc());
            ps.setString(++i, r.getEmail());
            ps.setString(++i, r.getTelefono());
 
            ps.setInt(++i, r.getPersona_id());
            rsId_proveedor = ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId_proveedor = rs.getInt(1);
                }
                rs.close();
            }
            
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "create", ex);
        }
        return rsId_proveedor;
    }
    
    
    public static int update(Proveedor r) {
        int comit = 0;
        String sql = "UPDATE Proveedor SET "
                + "ruc=?, "
                + "email=?, "
                + "telefono=?, "
                + "persona_id=? "
                + "WHERE id_proveedor=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, r.getRuc());
            ps.setString(++i, r.getEmail());
            ps.setString(++i, r.getTelefono());
            ps.setInt(++i, r.getPersona_id());
            ps.setInt(++i, r.getId_proveedor());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }
    
    public static int delete(int id_proveedor)  throws Exception{
        int comit = 0;
        String sql = "DELETE FROM proveedor WHERE id_proveedor = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id_proveedor);
            comit = ps.executeUpdate();
            
            /*try {
                    d.setFecha(sdf.parse(rs.getString("fecha")));
                } catch (Exception e) {
                }*/
            
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Persona_id:" + ex.getMessage());
        }
        return comit;
    }
}
