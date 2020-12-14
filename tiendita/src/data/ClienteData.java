
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
        int rsId_cliente = 0;
        String[] returns = {"id_cliente"};
        String sql = "INSERT INTO clientes(ruc, telefono, email, persona_id) "
                + "VALUES(?,?,?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, d.getRuc());
            ps.setString(++i, d.getTelefono());
            ps.setString(++i, d.getEmail());
            ps.setInt(++i, d.getPersona_id());
            rsId_cliente = ps.executeUpdate();// 0 no o 1 si commit
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId_cliente = rs.getInt(1); // select tk, max(id)  from clientes
                    //System.out.println("rs.getInt(rsId): " + rsId);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            //System.err.println("create:" + ex.toString());
            ErrorLogger.log(Level.SEVERE, "create", ex);
        }
        return rsId_cliente;
    }

    public static int update(Cliente d) {
        //System.out.println("actualizar d.getId_cliente(): " + d.getId_cliente());
        int comit = 0;
        String sql = "UPDATE Cliente SET "
                + "ruc=?, "
                + "telefono=? "
                + "email=? "
                + "persona_id=? "
                + "WHERE id_cliente=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, d.getRuc());
            ps.setString(++i, d.getTelefono());
            ps.setString(++i, d.getEmail());
            ps.setInt(++i, d.getPersona_id());
            ps.setInt(++i, d.getId_cliente());
           
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            ErrorLogger.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }

    public static int delete(int id_cliente) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            ErrorLogger.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Persona_id:" + ex.getMessage());
        }
        return comit;
    }
    
    public static List<Cliente> listCombo(String filter){
        List<Cliente> listCliente = new ArrayList();
        listCliente.add(new Cliente());
        listCliente.addAll(list(filter));
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
            sql = "SELECT * FROM Cliente ORDER BY id_cliente";
        } else {
            sql = "SELECT * FROM Cliente WHERE (id_cliente LIKE'" + filter + "%' OR "
                    + "nombres LIKE'" + filter + "%' OR info_adic LIKE'" + filter + "%' OR "
                    + "id_cliente LIKE'" + filter + "%') "
                    + "ORDER BY id_cliente";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente d = new Cliente();
                d.setId_cliente(rs.getInt("id_cliente"));
                d.setRuc(rs.getString("ruc"));
                d.setTelefono(rs.getString("telefono"));
                d.setEmail(rs.getString("email"));
                d.setPersona_id(rs.getInt("persona_id"));
                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }

    public static Cliente getByPId(int id_cliente) {
        Cliente d = new Cliente();

        String sql = "SELECT * FROM clientes WHERE id_cliente = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id_cliente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d.setId_cliente(rs.getInt("id_cliente"));
                d.setRuc(rs.getString("ruc"));
                d.setTelefono(rs.getString("telefono"));
                d.setEmail(rs.getString("email"));
                d.setPersona_id(rs.getInt("persona_id"));
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
    







