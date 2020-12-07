
package data;

import entities.Compra;

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
    
    public static int create(Compra c) {
        int rsId = 0;
        String[] returns = {"id"};
        String sql = "INSERT INTO venta(fecha_venta, cliente_id)"
                + " "
                + "VALUES(?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, currentTime);
            ps.setInt(++i, c.getProveedor_id());
            rsId = ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId = rs.getInt(1);
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
        return rsId;
    }
    

}
