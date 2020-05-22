package Commande;

import mou.*;

	public class CommandCreationCarre extends CommandCreationForme {
	
	  private String nom;
	  private Point SG;
	  private int cote;
	
	  
	  public CommandCreationCarre(String nom, Point SG, int cote, Dessin dessin) {
	
	    super(dessin);
	    this.nom = nom;
	    this.SG = SG;
	    this.cote = cote;
	  }
	
	  @Override
	  
	  public void execute() {
	    if (!this.exist(this.nom)) {
	      super.dessin.ajoute(new Carre(nom, SG, cote));
	    }
	  }
	}
