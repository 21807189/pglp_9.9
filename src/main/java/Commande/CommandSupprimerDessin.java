package Commande;

import DAO.DAOFactory;

public class CommandSupprimerDessin implements Command {

  private String nom;

  
  public CommandSupprimerDessin(String nom) {
    this.nom = nom;
  }

  @Override
  public void execute() {
    DAOFactory.getDessinDao().delete(nom);
  }
}
