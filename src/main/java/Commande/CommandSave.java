package Commande;

import DAO.DAOFactory;
import mou.Dessin;


public class CommandSave implements Command {

	  private Dessin dessin;
	
	  public CommandSave(Dessin dessin) {
	    this.dessin = dessin;
	  }

	  
  public void execute() {
	  
    DAOFactory.getDessinDao().create(this.dessin);
  }
}
