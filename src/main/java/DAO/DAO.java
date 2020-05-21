package DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO<T> implements AutoCloseable {

  protected Connection connect = null;

  public Statement stmt = null;

  public abstract T create(T obj);

  public abstract T update(T obj);

  public abstract T find(String id);

  public abstract void delete(String id);

  public static String nom = "default";

  /** 
   * Connexion avec le SGBD.
   */
  
  
  public void connect() {

    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      connect = DriverManager.getConnection("jdbc:derby:test");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      try {
        connect.close();
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  }

  public void disconnect() {

    try {
      connect.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

public void update(String id) {
	// TODO Auto-generated method stub
	
}
}
