package Commande;

import mou.*;

public class CommandCreationRectangle extends CommandCreationForme {

  private Point SG, ID;
  private int longueur;
  private int largeur;
  private String nom;

 
  public CommandCreationRectangle(String nom, Point SG, int longueur, int largeur, Dessin dessin) {
    super(dessin);
    
    this.longueur = ID.getx()-SG.getx();
    this.largeur = SG.gety()-ID.gety();
    this.nom = nom;
  }

  @Override
  public void execute() {
    if (!this.exist(this.nom)) {
      super.dessin.ajoute(new Rectangle(nom, SG, ID));
    }
  }
}
