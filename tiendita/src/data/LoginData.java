
package data;

import entities.Logine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import util.ErrorLogger;

public class LoginData {

    static Connection cn = Coon_sqlite.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ProductoData.class.getName());

    public static int create(Logine p) {
        int rsId = 0;
        String[] returns = {"id"};
        String sql = "INSERT INTO login(nombre, apellido_paterno, "
                + "apellido_materno, usuario, password) "
                + "VALUES(?,?,?,?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, p.getNombre());
            ps.setString(++i, p.getApellido_paterno());
            ps.setString(++i, p.getApellido_materno());
            ps.setString(++i, p.getUsuario());
            ps.setString(++i, p.getPassword());
            rsId = ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId = rs.getInt(1);
                }
                rs.close();
            }
            ps.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "create", ex);
        } finally{
            Coon_sqlite.closeSQLite(cn);
        }
        return rsId;
    }

    public static int update(Logine p) {
        int comit = 0;
        String sql = "UPDATE login SET "
                + "nombre=?, "
                + "apellido_paterno=?, "
                + "apellido_materno=?, "
                + "usuario=?, "
                + "password=? "
                + "WHERE id=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, p.getNombre());
            ps.setString(++i, p.getApellido_paterno());
            ps.setString(++i, p.getApellido_materno());
            ps.setString(++i, p.getUsuario());
            ps.setString(++i, p.getPassword());
            ps.setInt(++i, p.getId());
            comit = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        } finally{
            Coon_sqlite.closeSQLite(cn);
        }
        return comit;
    }

    public static int delete(int id) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM login WHERE id = ? ";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            comit = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            throw new Exception("Detalle:" + ex.getMessage());
        } finally{
            Coon_sqlite.closeSQLite(cn);
        }
        return comit;
    }

    public static List<Logine> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }

        List<Logine> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM login ORDER BY id";
        } else {
            sql = "SELECT * FROM login WHERE (id LIKE'" + filter + 
                    "%' OR " + "nombre LIKE'" + filter + 
                    "%' OR " + "apellido_paterno LIKE'" + filter + 
                    "%' OR " + "apellido_materno LIKE'" + filter + 
                    "%' OR " + "usuario LIKE'" + filter + 
                    "%') "
                    + "ORDER BY id";
        }
           
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Logine p = new Logine();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setUsuario(rs.getString("usuario"));
                p.setPassword(rs.getString("password"));
                
                ls.add(p);
            }
            st.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        } finally{
            Coon_sqlite.closeSQLite(cn);
        }
        return ls;
    }
    
    public static boolean list(Logine l) {
        
        String sql = "SELECT usuario, password FROM login";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String nombre = rs.getString("usuario");
                String pass = rs.getString("password");
                if (nombre.equals(l.getUsuario()) && pass.equals(l.getPassword())) {
                    return true;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        } finally{
            Coon_sqlite.closeSQLite(cn);
        }
        return false;
    }
 
    public static Logine getByPId(int id) {
        
        Logine p = new Logine();

        String sql = "SELECT * FROM login WHERE id = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setUsuario(rs.getString("usuario"));
                p.setPassword(rs.getString("password"));
            }
            rs.close();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        } finally{
            Coon_sqlite.closeSQLite(cn);
        }
        return p;
    }
}
