
package data;

import entities.Proveedor;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import util.ErrorLogger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

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
    
    public static List<Proveedor> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<Proveedor> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM Proveedor ORDER BY id_proveedor";
        } else {
            sql = "SELECT * FROM Proveedor WHERE (id_proveedor LIKE'" + filter + 
                    "%' OR " + "ruc LIKE'" + filter + 
                    "%' OR " + "email LIKE'" + filter + 
                    "%' OR " + "telefono LIKE'" + filter + 
                    "%' OR " + "persona_id LIKE'" + filter + 
                    "%') "
                    + "ORDER BY id_proveedor";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setId_proveedor(rs.getInt("id_proveedor"));
                p.setRuc(rs.getString("ruc"));
                p.setEmail(rs.getString("email"));
                p.setTelefono(rs.getString("telefono"));
                p.setPersona_id(rs.getInt("persona_id"));
                ls.add(p);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        } finally {
            //Coon_sqlite.closeSQLite(cn);
        }
        return ls;
    }
    
    public static Proveedor getByPId(int id_preveedor) {
        
        Proveedor p = new Proveedor();

        String sql = "SELECT * FROM Proveedor WHERE id_proveedor = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id_preveedor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setId_proveedor(rs.getInt("id_proveedor"));
                p.setRuc(rs.getString("ruc"));
                p.setEmail(rs.getString("email"));
                p.setTelefono(rs.getString("telefono"));
                p.setPersona_id(rs.getInt("persona_id"));
            }
            ps.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        } finally {
            Coon_sqlite.closeSQLite(cn);
        }
        return p;
    }
}
