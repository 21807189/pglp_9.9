package DAO;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import mou.Point;
import mou.Rectangle;

public class RectangleDAO extends DAO<Rectangle> {

  @Override
  public Rectangle create(Rectangle obj) {
    this.connect();
    
    try (PreparedStatement insert =
        this.connect.prepareStatement(
            "INSERT INTO Rectangle(nom, x, y, longueur, hauteur) values(?, ?, ?, ?, ?)"); ) {
    	
      System.out.println("RectangleDao: " + DAO.nom + ":" + obj.getnom());
      
      insert.setString(1, DAO.nom + ":" + obj.getnom());
      insert.setInt(2, obj.SG.getx());
      insert.setInt(3, obj.SG.gety());
      insert.setInt(4, obj.getlongueur());
      insert.setInt(5, obj.getlargeur());
      
      insert.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.disconnect();
    return null;
  }

  @Override
   	public Rectangle find(String id) {
    Rectangle r = null;
    this.connect();
    		try (PreparedStatement select =
        this.connect.prepareStatement("SELECT * FROM Rectangle R WHERE R.nom = ?")) {
      select.setString(1, id);
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    this.disconnect();

    return r;
  }

  @Override
  	public void delete(String id) {
	  
    this.connect();
    try (PreparedStatement delete =
        this.connect.prepareStatement("DELETE FROM Rectangle R WHERE R.nom = ?"); ) {
    	
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
public Rectangle update(Rectangle obj) {
	// TODO Auto-generated method stub
	return null;
}
}
