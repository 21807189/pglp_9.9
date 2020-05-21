package DAO;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import mou.Cercle;

public class CercleDAO extends DAO<Cercle> {
	
  @Override
  public Cercle create(Cercle obj) {
    this.connect();
    
    try (PreparedStatement insert =
        this.connect.prepareStatement(
            "INSERT INTO Cercle(nom, x, y, rayon) values(?, ?, ?, ?)"); ) {
    	
      insert.setString(1, DAO.nom + ":" + obj.getnom());
      insert.setInt(2, obj.centre.getx());
      insert.setInt(3, obj.centre.gety());
      insert.setInt(4, obj.getrayon());
      
      insert.executeUpdate();
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.disconnect();
    return null;
  }

  @Override
  public Cercle find(String id) {
    Cercle c = null;
    this.connect();
    
    try (PreparedStatement select = this.connect.prepareStatement("SELECT * FROM Cercle C WHERE C.nom = ?")) {
    	
      select.setString(1, id);      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    this.disconnect();

    return c;
  }

  @Override
  public void delete(String id) {
    this.connect();
    
    try (PreparedStatement delete =this.connect.prepareStatement("DELETE FROM Cercle C WHERE C.nom = ?"); ) {
      delete.setString(1, id);
      delete.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.disconnect();
  }

  
  @Override
  public void close() throws Exception {
    super.connect.close();
  }

@Override
public Cercle update(Cercle obj) {
	// TODO Auto-generated method stub
	return null;
}
}
