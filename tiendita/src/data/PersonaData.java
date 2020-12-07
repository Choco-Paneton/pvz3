
package data;

import entities.Persona;
import util.ErrorLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class PersonaData {

    static Connection cn = Coon_sqlite.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ClienteData.class.getName());

    public static int create(Persona d) {
        int rsId = 0;
        String[] returns = {"id"};
        String sql = "INSERT INTO Persona(nombre, apellido_materno, apellido_paterno, dni, sexo) "
                + "VALUES(?, ?, ?, ?, ?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, d.getNombre());
            ps.setString(++i, d.getApellido_paterno());
            ps.setString(++i, d.getApellido_materno());
            ps.setString(++i, d.getDni());
            ps.setString(++i, d.getSexo());
            rsId = ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId = rs.getInt(1);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            ErrorLogger.log(Level.SEVERE, "create", ex);
        }
        return rsId;
    }

    public static int update(Persona d) {
        int comit = 0;
        String sql = "UPDATE persona SET "
                + "nombre=?, "
                + "apelldo_materno=? "
                + "apellido_paterno=?"
                + "dni=?"
                + "sexo=?"
                + "WHERE id=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, d.getNombre());
            ps.setString(++i, d.getApellido_paterno());
            ps.setString(++i, d.getApellido_materno());
            ps.setString(++i, d.getDni());
            ps.setString(++i, d.getSexo());
            ps.setInt(++i, d.getId());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            ErrorLogger.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }

    public static int delete(int id) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM Persona WHERE id = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            ErrorLogger.log(Level.SEVERE, "delete", ex);
            throw new Exception("Detalle:" + ex.getMessage());
        }
        return comit;
    }

    public static List<Persona> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<Persona> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM Persona ORDER BY id";
        } else {
            sql = "SELECT * FROM Persona WHERE (id LIKE'" + filter + "%' OR "
                    + "nombre LIKE'" + filter + "%' OR apellidos_materno'" + filter + "%' OR apellidos_paterno'" + filter + "%' OR dni'"
                    + "id LIKE'" + filter + "%') "
                    + "ORDER BY nombre";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Persona d = new Persona();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setApellido_materno(rs.getString("apellido_materno"));
                d.setApellido_paterno(rs.getString("apellido_paterno"));
                d.setDni(rs.getString("dni"));
                d.setSexo(rs.getString("sexo"));
                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }

    public static Persona getByPId(int id) {
        Persona d = new Persona();

        String sql = "SELECT * FROM Persona WHERE id = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setApellido_paterno(rs.getString("apellido_materno"));
                d.setApellido_materno(rs.getString("apellido_paterno"));
                d.setDni(rs.getString("dni"));
                d.setSexo(rs.getString("sexo"));
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return d;
    }
}
