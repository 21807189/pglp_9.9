package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mou.Point;
import mou.Triangle;

public class TriangleDAO extends DAO<Triangle> {

  @Override
  public Triangle create(Triangle obj) {
    this.connect();
    try (PreparedStatement insert =
        this.connect.prepareStatement(
            "INSERT INTO Triangle(nom, pax, pay, pbx, pbay, pcx, pcy) values(?, ?, ?, ?, ?, ?, ?)"); ) {
    	
      insert.setString(1, DAO.nom + ":" + obj.getnom());
      insert.setInt(2, obj.pointa.getx());
      insert.setInt(3, obj.pointa.gety());
      
      insert.setInt(4, obj.pointb.getx());
      insert.setInt(5, obj.pointb.gety());
      
      insert.setInt(6, obj.pointc.getx());
      insert.setInt(7, obj.pointc.gety());
      insert.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.disconnect();
    return null;
  }

  @Override
  public Triangle find(String id) {
	  
    Triangle t = null;
    this.connect();
    
    try (PreparedStatement select =
        this.connect.prepareStatement("SELECT * FROM Triangle t WHERE t.nom = ?")) {
      select.setString(1, id);
      	try (ResultSet res = select.executeQuery()) {
        if (res.next()) {
          t =
              new Triangle(
                  res.getString("nom").split(":")[1],
                  new Point(res.getInt("ax"), res.getInt("ay")),
                  new Point(res.getInt("bx"), res.getInt("bay")),
                  new Point(res.getInt("cx"), res.getInt("cy")));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    this.disconnect();

    return t;
  }

  @Override
  public void delete(String id) {
    this.connect();
    try (PreparedStatement delete =
        this.connect.prepareStatement("DELETE FROM Triangle t WHERE t.nom = ?"); ) {
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
public Triangle update(Triangle obj) {
	// TODO Auto-generated method stub
	return null;
}
}
