package Commande;

import mou.*;

public class CommandCreationTriangle extends CommandCreationForme{

  private String nom;
  private Point pointa;
  private Point pointb;
  private Point pointc;

  
  public CommandCreationTriangle(String nom, Point pa, Point pb, Point pc, Dessin dessin) {
    super(dessin);
    this.nom = nom;
    this.pointa = pa;
    this.pointb = pb;
    this.pointc = pc;
  }

  @Override
  public void execute() {
    if (!this.exist(this.nom)) {
      super.dessin.ajoute(new Triangle(nom, pointa, pointb, pointc));
    }
  }
}
