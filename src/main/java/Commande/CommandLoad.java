package Commande;

import DAO.DAOFactory;

public class CommandLoad implements Command {

  private String nom;
  private DrawingTUI DT;

 
  public CommandLoad(String nom, DrawingTUI draw) {
    this.nom = nom;
    this.DT = draw;
  }

  @Override
  public void execute() {
    this.DT.setDessin(DAOFactory.getDessinDao().find(this.nom));
  }
}
