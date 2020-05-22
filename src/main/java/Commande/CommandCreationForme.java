package Commande;

import mou.Dessin;

import mou.ComposantDessin;

public abstract class CommandCreationForme implements Command {

  protected Dessin dessin;

  
  public CommandCreationForme(Dessin dessin) {
    this.dessin = dessin;
  }

  
  public boolean exist(String nom) {

    boolean res = false;

    for (ComposantDessin comp : dessin.getcomposants()) {

      if (comp.getNom().matches(nom)) {
        return true;
      }
    }

    return false;
  }
}
