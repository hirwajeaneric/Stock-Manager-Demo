package Controller;

import Model.Stock;
import Util.DatabaseConnector;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hirwa
 */
public class StockDao extends DatabaseConnector {
    public void save(Stock stck){
        try {
            getConnection();
            String saveQuerry = "INSERT INTO stock VALUES (?,?,?,?,?,?)";
            
            ps = con.prepareStatement(saveQuerry);
            ps.setString(1, stck.getType());
            ps.setString(2, stck.getName());
            ps.setString(3, stck.getQuantity());
            ps.setString(4, stck.getQuality());
            ps.setString(5, stck.getPrice());
            ps.setString(6, stck.getEntryDate());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            getDisconnection();
        }
    }
    
    public void delete(Stock st){
        try {
            getConnection();
            String deleteQuerry = "DELETE FROM stock WHERE name=?";
            
            ps = con.prepareStatement(deleteQuerry);
            ps.setString(1, st.getName());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(StockDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            getDisconnection();
        }
        
    }
}
