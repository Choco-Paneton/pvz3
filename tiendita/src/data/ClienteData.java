
package data;


import entities.Cliente;
import util.ErrorLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ClienteData {

    static Connection cn = Coon_sqlite.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ClienteData.class.getName());

    public static int create(Cliente d) {
        int rsId = 0;
        String[] returns = {"id"};
        String sql = "INSERT INTO clientes(nombres, info_adic) "
                + "VALUES(?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, d.getRuc());
            ps.setString(++i, d.getTelefono());
            ps.setString(++i, d.getEmail());
            rsId = ps.executeUpdate();// 0 no o 1 si commit
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId = rs.getInt(1); // select tk, max(id)  from clientes
                    //System.out.println("rs.getInt(rsId): " + rsId);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            //System.err.println("create:" + ex.toString());
            ErrorLogger.log(Level.SEVERE, "create", ex);
        }
        return rsId;
    }

    public static int update(Cliente d) {
        System.out.println("actualizar d.getId(): " + d.getId());
        int comit = 0;
        String sql = "UPDATE clientes SET "
                + "nombres=?, "
                + "info_adic=? "
                + "WHERE id=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, d.getRuc());
            ps.setString(++i, d.getTelefono());
            ps.setString(++i, d.getEmail());
            ps.setInt(++i, d.getId());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            ErrorLogger.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }

    public static int delete(int id) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM clientes WHERE id = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            ErrorLogger.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Detalle:" + ex.getMessage());
        }
        return comit;
    }
    
    public static List<Cliente> listCombo(String f){
        List<Cliente> listCliente = new ArrayList();
        listCliente.add(new Cliente());
        listCliente.addAll(list(f));
        return listCliente;
    }

    public static List<Cliente> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<Cliente> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM cliente ORDER BY id";
        } else {
            sql = "SELECT * FROM cliente WHERE (id LIKE'" + filter + "%' OR "
                    + "nombres LIKE'" + filter + "%' OR info_adic LIKE'" + filter + "%' OR "
                    + "id LIKE'" + filter + "%') "
                    + "ORDER BY nombres";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente d = new Cliente();
                d.setId(rs.getInt("id"));
                d.setRuc(rs.getString("ruc"));
                d.setTelefono(rs.getString("telefono"));
                d.setEmail(rs.getString(""));
                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }

    public static Cliente getByPId(int id) {
        Cliente d = new Cliente();

        String sql = "SELECT * FROM clientes WHERE id = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setRuc(rs.getString("nombres"));
                d.setTelefono(rs.getString("info_adic"));
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return d;
    }
    /*
    public static void iniciarTransaccion() {
        try {
            cn.setAutoCommit(false);
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "iniciarTransaccion", ex);
        }
    }

    public static void finalizarTransaccion() {
        try {
            cn.commit();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "finalizarTransaccion", ex);
        }
    }

    public static void cancelarTransaccion() {
        try {
            cn.rollback();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "cancelarTransaccion", ex);
        }
    }
     */
}
    







