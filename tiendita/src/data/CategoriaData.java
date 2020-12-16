package data;

import entities.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import util.ErrorLogger;

public class CategoriaData {
    
    static ErrorLogger log = new ErrorLogger(CategoriaData.class.getName());

    public static int create(Categoria c) {
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        int rsId_categoria = 0;
        String[] returns = {"id_categoria"};
        String sql = "INSERT INTO Categoria(nombre_categoria) "
                + "VALUES(?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, c.getNombre_categoria());
            rsId_categoria = ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId_categoria = rs.getInt(1);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "create", ex);
        } finally {
            Coon_sqlite.closeSQLite(cn);
        }
        return rsId_categoria;
    }

    public static int update(Categoria c) {
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        int comit = 0;
        String sql = "UPDATE Categoria SET "
                + "nombre_categoria = ? "
                + "WHERE id_categoria = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, c.getNombre_categoria());
            ps.setInt(++i, c.getId_categoria());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        } finally {
            Coon_sqlite.closeSQLite(cn);
        }
        return comit;
    }

    public static int delete(int id_categoria) throws Exception {
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        int comit = 0;
        String sql = "DELETE FROM Categoria WHERE id_categoria = ? ";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id_categoria);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            throw new Exception("Detalle:" + ex.getMessage());
        } finally {
            Coon_sqlite.closeSQLite(cn);
        }
        return comit;
    }

    public static List<Categoria> list(String filter) {
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }

        List<Categoria> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM Categoria ORDER BY id_categoria";
        } else {
            sql = "SELECT * FROM Categoria WHERE (id_categoria LIKE'" + filter + 
                    "%' OR nombre_categoria LIKE '" + filter + "%') " + "ORDER BY id_categoria";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId_categoria(rs.getInt("id_categoria"));
                c.setNombre_categoria(rs.getString("nombre_categoria"));
                ls.add(c);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        } finally {
            //Coon_sqlite.closeSQLite(cn);
        }
        return ls;
    }

    public static Categoria getByPId(int id_categoria) {
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        
        Categoria c = new Categoria();

        String sql = "SELECT * FROM Categoria WHERE id_categoria = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id_categoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setId_categoria(rs.getInt("id_categoria"));
                c.setNombre_categoria(rs.getString("nombre_categoria"));
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        } finally {
            //Coon_sqlite.closeSQLite(cn);
        }
        return c;
    }
    
    public static Categoria getNombreById(int id_categoria) {
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        
        Categoria c = new Categoria();

        String sql = "SELECT * FROM Categoria WHERE id = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id_categoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setId_categoria(rs.getInt("id_categoria"));
                c.setNombre_categoria(rs.getString("nombre_categoria"));
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        } finally {
            Coon_sqlite.closeSQLite(cn);
        }
        return c;
    }
}
