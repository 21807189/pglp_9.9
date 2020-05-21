package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import mou.Carre;
import mou.Cercle;
import mou.ComposantDessin;
import mou.Dessin;
import mou.Groupe;
import mou.Rectangle;
import mou.Triangle;

public class DessinDAO extends DAO<Dessin> {

  @Override
  public Dessin create(Dessin obj) {
  
    this.connect();
    try (PreparedStatement dessinInsert =
            this.connect.prepareStatement("INSERT INTO Dessin(dnom) values(?)");
        PreparedStatement carreInsert =
            this.connect.prepareStatement("INSERT INTO CarreDessin(dnom, nom) VALUES(?, ?)");
        PreparedStatement cercleInsert =
            this.connect.prepareStatement("INSERT INTO CercleDessin(dnom, nom) VALUES(?, ?)");
        PreparedStatement triangleInsert =
            this.connect.prepareStatement("INSERT INTO TriangleDessin(dnom, nom) VALUES(?, ?)");
        PreparedStatement groupeDessinInsert =
            this.connect.prepareStatement("INSERT INTO GroupeDessin(dnom, nom) VALUES(?, ?)");
        PreparedStatement rectangleInsert =
            this.connect.prepareStatement(
                "INSERT INTO RectangleDessin(dnom, nom) VALUES(?, ?)"); ) {
    	
      dessinInsert.setString(1, obj.getNom());
      dessinInsert.executeUpdate();
      List<ComposantDessin> listcomp = obj.getcomposants();
      DAO tmp;
      
      for (ComposantDessin comp : listcomp) {
    	  
        if (comp instanceof Groupe) {
          tmp = new GroupeDAO();
          tmp.create((Groupe) comp);
          groupeDessinInsert.setString(1, obj.getNom());
          groupeDessinInsert.setString(2, DAO.nom + ":" + comp.getNom());
          groupeDessinInsert.executeUpdate();
          
        } else if (comp instanceof Cercle) {
          tmp = new CercleDAO();
          tmp.create((Cercle) comp);
          cercleInsert.setString(1, obj.getNom());
          cercleInsert.setString(2, DAO.nom + ":" + comp.getNom());
          cercleInsert.executeUpdate();
          
        } else if (comp instanceof Rectangle) {
          System.out.println(" rectangle: " + comp.getNom());
          tmp = new RectangleDAO();
          tmp.create((Rectangle) comp);
          rectangleInsert.setString(1, obj.getNom());
          rectangleInsert.setString(2, DAO.nom + ":" + comp.getNom());
          rectangleInsert.executeUpdate();
          
        } else if (comp instanceof Carre) {
          tmp = new CarreDAO();
          tmp.create((Carre) comp);
          carreInsert.setString(1, obj.getNom());
          carreInsert.setString(2, DAO.nom + ":" + comp.getNom());
          carreInsert.executeUpdate();
          
        } else if (comp instanceof Triangle) {
          tmp = new TriangleDAO();
          tmp.create((Triangle) comp);
          triangleInsert.setString(1, obj.getNom());
          triangleInsert.setString(2, DAO.nom + ":" + comp.getNom());
          triangleInsert.executeUpdate();
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.disconnect();

    return obj;
  }

  @Override
  public Dessin find(String id) {
    Dessin dessin = null;
    DAO dao;
    this.connect();
    try (PreparedStatement select =
            this.connect.prepareStatement("SELECT D.dnom FROM Dessin D WHERE D.dnom = ?");
        PreparedStatement selectRectangle =
            this.connect.prepareStatement("SELECT * FROM RectangleDessin RD WHERE RD.dnom = ?");
        PreparedStatement selectTriangle =
            this.connect.prepareStatement("SELECT * FROM TriangleDessin TD WHERE TD.dnom = ?");
        PreparedStatement selectCercle =
            this.connect.prepareStatement("SELECT * FROM CercleDessin CD WHERE CD.dnom = ?");
        PreparedStatement selectCarre =
            this.connect.prepareStatement("SELECT * FROM CarreDessin CD WHERE CD.dnom = ?");
        PreparedStatement selectGroupe =
            this.connect.prepareStatement("SELECT * FROM GroupeDessin GD WHERE GD.dnom = ?"); ) {
    	
      select.setString(1, id);
      selectTriangle.setString(1, id);
      selectCarre.setString(1, id);
      selectRectangle.setString(1, id);
      selectCercle.setString(1, id);
      selectGroupe.setString(1, id);
      
      try (ResultSet res = select.executeQuery();
          ResultSet resTriangle = selectTriangle.executeQuery();
          ResultSet resCarre = selectCarre.executeQuery();
          ResultSet resRectangle = selectRectangle.executeQuery();
          ResultSet resCercle = selectCercle.executeQuery();
          ResultSet resGroupe = selectGroupe.executeQuery(); ) {
    	  
        if (res.next()) {
          String n = res.getString("dnom");
        }
        dessin = new Dessin(id);
        while (resCarre.next()) {
          dao = new CarreDAO();
          dessin.ajoute((Carre) dao.find(resCarre.getString("nom")));
        }

        while (resRectangle.next()) {
          System.out.println("trouvé");
          dao = new RectangleDAO();
          dessin.ajoute((Rectangle) dao.find(resRectangle.getString("nom")));
        }

        while (resTriangle.next()) {
          dao = new TriangleDAO();
          dessin.ajoute((Triangle) dao.find(resTriangle.getString("nom")));
        }

        while (resCercle.next()) {
          dao = new CercleDAO();
          dessin.ajoute((Cercle) dao.find(resCercle.getString("nom")));
        }

        while (resGroupe.next()) {
          dao = new GroupeDAO();
          dessin.ajoute((Groupe) dao.find(resGroupe.getString("nom")));
        }
      }
    } catch (SQLException e) {
      System.out.println("Un dessin existe déja avec ce nom. \n");
      e.printStackTrace();
    }

    this.disconnect();

    return dessin;
  }

  @Override
  public void delete(String id) {
    this.connect();
    try (PreparedStatement delete =
        this.connect.prepareStatement("DELETE FROM Dessin D WHERE D.dnom = ?"); ) {
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
public Dessin update(Dessin obj) {
	// TODO Auto-generated method stub
	return null;
}
}
