package Commande;

import mou.Groupe;
import mou.Point;


public class CommandDeplacerGroupe implements Command {

	  private Groupe groupe;
	  private int x;
	  private int y;
	  private Point pp;

  public CommandDeplacerGroupe(Groupe groupe, int x, int y) {
	  
    this.groupe = groupe;
    this.x = x;
    this.y = y;
  }

	  @Override
	  public void execute() {
	
	    this.groupe.deplacer(pp);
	  }
}
