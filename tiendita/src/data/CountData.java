
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import util.ErrorLogger;

public class CountData {
    
    static ErrorLogger log = new ErrorLogger(ClienteData.class.getName());
    
    public static int getNProducto() {

        int intN = 0;
        
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        
        String sql = "SELECT * FROM Producto";
        
        try {
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                intN = rs.getRow();
            }
            return intN;
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return 0;
    }
    public static int getNCategoria() {
        
        int intN = 0;
        
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        
        String sql = "SELECT * FROM Categoria";
        
        try {
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                intN = rs.getRow();
            }
            return intN;
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return 0;
    }
    public static int getNProveedor() {
        
        int intN = 0;
        
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        
        String sql = "SELECT * FROM Proveedor";
        
        try {
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                intN = rs.getRow();
            }
            return intN;
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return 0;
    }
    public static int getNCliente() {
        
        int intN = 0;
        
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        
        String sql = "SELECT * FROM Cliente";
        
        try {
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                intN = rs.getRow();
            }
            return intN;
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return 0;
    }
    public static int getNCompra() {
        
        int intN = 0;
        
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        
        String sql = "SELECT * FROM Compra";
        
        try {
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                intN = rs.getRow();
            }
            return intN;
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return 0;
    }
    public static int getNVenta() {
        
        int intN = 0;
        
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        
        String sql = "SELECT * FROM ventas";
        
        try {
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                intN = rs.getRow();
            }
            return intN;
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return 0;
    }
    public static int getNProductoPro() {
        
        int intN = 0;
        
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        
        String sql = "SELECT * FROM productos";
        
        try {
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                intN = rs.getRow();
            }
            return intN;
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return 0;
    }
    public static int getNClientePro() {
        
        int intN = 0;
        
        Connection cn = Coon_sqlite.connectSQLite();
        PreparedStatement ps;
        
        String sql = "SELECT * FROM clientes";
        
        try {
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                intN = rs.getRow();
            }
            return intN;
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return 0;
    }
}
