
package gui.profe.data;

import data.Coon_sqlite;
import entities.VentaLineaProfe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import util.ErrorLogger;

public class VentaLineaDatas {
    static Connection cn = Coon_sqlite.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(VentaLineaDatas.class.getName());

    
    public static int create(VentaLineaProfe d) {
        int rsId = 0;
        String[] returns = {"id"};
        String sql = "INSERT INTO venta_lineas(descripcion, cant, precio, descto, subtotal, venta_id,  prod_id) " //activo
                + "VALUES(?,?,?,?,?   ,?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, d.getDescripcion());
            ps.setDouble(++i, d.getCant());
            ps.setDouble(++i, d.getPrecio());
            ps.setDouble(++i, d.getDescto());
            ps.setDouble(++i, d.getSubtotal());
            
            ps.setInt(++i, d.getVenta_id());
            ps.setInt(++i, d.getProd_id());
            
            rsId = ps.executeUpdate();// 0 no o 1 si commit
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId = rs.getInt(1); // select tk, max(id)  from venta_lineas
                    //System.out.println("rs.getInt(rsId): " + rsId);
                    // soy sullon local
                    //
                    System.out.println("saul rs.getInt(rsId): " + rsId);
                    
                }
                rs.close();
            }
        } catch (SQLException ex) {
            //System.err.println("create:" + ex.toString());
            log.log(Level.SEVERE, "create", ex);
        }
        return rsId;
    }

    public static int update(VentaLineaProfe d) {
        System.out.println("actualizar d.getId(): " + d.getId());
        int comit = 0;
        String sql = "UPDATE venta_lineas SET "
                + "descripcion=?, "
                + "cant=?, "
                + "precio=?, "
                + "descto=?, "
                + "subtotal=?, "
                + "prod_id=? "
                
                + "WHERE id=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, d.getDescripcion());
            ps.setDouble(++i, d.getCant());
            ps.setDouble(++i, d.getPrecio());
            ps.setDouble(++i, d.getDescto());
            ps.setDouble(++i, Math.round(d.getCant() * d.getPrecio() * 100.0) / 100.0 ); //ps.setDouble(++i, d.getSubtotal());
            
            //ps.setInt(++i, d.getVenta_id());
            ps.setInt(++i, d.getProd_id());
            
            ps.setInt(++i, d.getId());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }
    

    public static int delete(int id) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM venta_lineas WHERE id = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Detalle:" + ex.getMessage());
        }
        return comit;
    }

    public static List<VentaLineaProfe> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<VentaLineaProfe> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM venta_lineas ORDER BY id";
        } else {
            sql = "SELECT * FROM venta_lineas WHERE (id LIKE'" + filter + "%' OR "
                    + "descripcion LIKE'" + filter + "%' OR cant LIKE'" + filter + "%' OR "
                    + "id LIKE'" + filter + "%') "
                    + "ORDER BY descripcion";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                VentaLineaProfe d = new VentaLineaProfe();
                d.setId(rs.getInt("id"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setCant(rs.getDouble("cant"));
                d.setPrecio(rs.getDouble("precio"));
                d.setDescto(rs.getDouble("descto"));
                d.setSubtotal(rs.getDouble("subtotal"));
                d.setProd_id(rs.getInt("prod_id"));
                d.setVenta_id(rs.getInt("venta_id"));
                d.setActivo(rs.getInt("activo"));
                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }

    public static VentaLineaProfe getByPId(int id) {
        VentaLineaProfe d = new VentaLineaProfe();

        String sql = "SELECT * FROM venta_lineas WHERE id = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setDescripcion(rs.getString("descripcion"));
                 d.setCant(rs.getDouble("cant"));
                d.setPrecio(rs.getDouble("precio"));
                d.setDescto(rs.getDouble("descto"));
                d.setSubtotal(rs.getDouble("subtotal"));
                d.setProd_id(rs.getInt("prod_id"));
                d.setVenta_id(rs.getInt("venta_id"));
                d.setActivo(rs.getInt("activo"));
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return d;
    }
    
    
    public static List<VentaLineaProfe> listByVenta(int venta_id) { // devolver todas las lineas de una venta

        System.out.println("listByVenta.comp_id:" + venta_id);

        List<VentaLineaProfe> ls = new ArrayList();

        String sql = "";
         sql = " SELECT * FROM venta_lineas "
                + " WHERE venta_id = " + venta_id + " "
                + " ORDER BY id ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                VentaLineaProfe d = new VentaLineaProfe();
                d.setId(rs.getInt("id"));
                d.setDescripcion(rs.getString("descripcion"));                
                d.setCant(rs.getDouble("cant"));
                d.setPrecio(rs.getDouble("precio"));
                d.setDescto(rs.getDouble("descto"));
                d.setSubtotal(rs.getDouble("subtotal"));
                d.setProd_id(rs.getInt("prod_id"));
                d.setVenta_id(rs.getInt("venta_id"));
                d.setActivo(rs.getInt("activo"));
                
                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }
}
