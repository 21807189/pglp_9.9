package Commande;

import mou.*;

public class CommandCreationCercle extends CommandCreationForme {

  private String nom;
  private Point centre;
  private int rayon;

  
  public CommandCreationCercle(String nom, Point centre, int rayon, Dessin dessin) {
	    super(dessin);
	    this.nom = nom;
	    this.centre = centre;
	    this.rayon = rayon;
  }

	  public void execute() {
	    if (!this.exist(this.nom)) {
	      super.dessin.ajoute(new Cercle(nom, centre, rayon));
	    }
  }
}
