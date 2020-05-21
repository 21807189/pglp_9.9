package DAO;

import mou.*;

public class DAOFactory {

  public static DAO<Dessin> getDessinDao() {

    return new DessinDAO();
  }

  public static DAO<Groupe> getGroupeDao() {

    return new GroupeDAO();
  }

  public static DAO<Carre> getCarreDao() {

    return new CarreDAO();
  }

  public static DAO<Cercle> getCercleDao() {
    return new CercleDAO();
  }

  public static DAO<Rectangle> getRectangleDao() {

    return new RectangleDAO();
  }

  public static DAO<Triangle> getTriangleDao() {
    return new TriangleDAO();
  }
}
