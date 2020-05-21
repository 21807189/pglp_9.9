package DAO;

import java.sql.Connection;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mou.Carre;
import mou.ComposantDessin;
import mou.Point;
import DAO.*;



public class CarreDAO extends DAO<Carre> {


	public  boolean existe_table(String nomTable) throws SQLException{
		this.connect();
		boolean existe;
		DatabaseMetaData dmd = connect.getMetaData();
		
		ResultSet tables = dmd.getTables(connect.getCatalog(),null,nomTable,null);
		existe = tables.next();
		tables.close();
		return existe;	
}
    public void createTable() {
        try {
            if (!existe_table("carre")) {
                try (Statement stmt = connect.createStatement()) {
                    stmt.execute("Create table carre ("
                            + "nom varchar(30) not null, "
                            + "SGX int not null, " + "SGY int not null,"
                            + "cote int not null, "
                            + "dessinID int not null,"
                            + "primary key (nom, dessinID), "
                            + "foreign key (dessinID) references dessin(dessinID))");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.disconnect();
        return;
      }

   
   
    public void insert(final Carre obj, final int dessinID, final Connection connect){
    	this.connect();
            try (PreparedStatement insertCarre = this.connect.prepareStatement(
                    "INSERT INTO carre values (?, ?, ?, ?)")) {
            	insertCarre.setString(1, DAO.nom + ":" + obj.getnom());
            	insertCarre.setInt(2, obj.getpointprincipal().getx());
            	insertCarre.setInt(3, obj.getpointprincipal().gety());
            	insertCarre.setInt(4, obj.getcote());
            	insertCarre.executeUpdate();
              } catch (SQLException e) {
                e.printStackTrace();
              }
              this.disconnect();
              //return null;
            } 

   
    @Override
    public Carre find(String nom) {
      Carre c = null;
      this.connect();
      try (PreparedStatement select = this.connect.prepareStatement("SELECT * FROM Carre C WHERE C.nom = ?")) {
        select.setString(1, nom);
        
      } catch (SQLException e) {
        e.printStackTrace();
      }

      this.disconnect();

      return c;
    }
    
    @Override
    public void delete(String id) {
      this.connect();
      try (PreparedStatement delete =
          this.connect.prepareStatement("DELETE FROM Carre C WHERE C.nom = ?"); ) {
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
    public Carre update(final Carre obj) {
      this.connect();
      try (PreparedStatement update =
          this.connect.prepareStatement(
                  "UPDATE carre SET SGX = ?, SGY = ?, cote = ? "
                          + "WHERE nom = ? AND dessinID = ?")) {
              update.setInt(1, obj.getpointprincipal().getx());
              update.setInt(2, obj.getpointprincipal().gety());
              update.setInt(3,obj.getcote());
              update.setString(4, obj.getnom());
              update.execute();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      this.disconnect();
	return obj;
    }

	@Override
	public Carre create(Carre obj) {
		// TODO Auto-generated method stub
		return null;
	}

 

}
