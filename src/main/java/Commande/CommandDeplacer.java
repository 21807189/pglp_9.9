package Commande;

import mou.*;

public class CommandDeplacer implements Command {

	  private Forme forme;
	  private int x;
	  private int y;
	  private Point pp;

  
	public CommandDeplacer(Forme forme, int x, int y) {
	    this.forme = forme;
	    this.x = x;
	    this.y = y;
    
  }

  @Override
  public void execute() {

    this.forme.deplacer(pp);
  }
}
