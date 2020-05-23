package Commande;

import java.util.List;
import mou.*;

public class SupprimerElementCommand implements Command {

  private String supprimer;
  private Dessin dessin;

  
  public SupprimerElementCommand(Dessin dessin, String supprimer) {
    this.dessin = dessin;
    this.supprimer = supprimer;
  }

  @Override
  public void execute() {
    List<ComposantDessin> comp = this.dessin.getcomposants();
    for (int i = 0; i < comp.size(); i++) {
      if (comp.get(i).getNom().matches(supprimer)) {
        comp.remove(i);
      }
    }
  }
}
