package Commande;

import java.util.List;

import mou.*;


public class CommandCreationGroupe extends CommandCreationForme {

  private String[] Compgroupe;
  private String nom;

  
  public CommandCreationGroupe(String nom, String[] Compgroupe, Dessin dessin) {
    super(dessin);
    this.Compgroupe = Compgroupe;
    this.nom = nom;
  }

  @Override
  public void execute() {
    List<ComposantDessin> complist = this.dessin.getcomposants();
    Groupe groupe = new Groupe(this.nom);

    for (int i = 0; i < Compgroupe.length; i++) {
      if (!this.dessin.exists(Compgroupe[i])) {
        System.out.println("Les composants de ce groupe son introuvable.");
        return;
      }
    }

    for (int i = 0; i < Compgroupe.length; i++) {
      for (int j = 0; j < complist.size(); j++) {
        ComposantDessin comp = complist.get(j);
        if (this.Compgroupe[i].matches(comp.getNom())) {
          groupe.ajoutForme(comp);
          complist.remove(j);
        }
      }
    }
    complist.add(groupe);
  }
}
