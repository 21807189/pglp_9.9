package mou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Groupe implements ComposantDessin {

  private List<ComposantDessin> comp;

  public Groupe(String nom) {

    super();
    comp = new ArrayList<>();
  }

  public void ajoutForme(ComposantDessin comp) {
    this.comp.add(comp);
  }

  
  public void afficher() {
    System.out.println("Groupe " + this.getNom() + ": ");
    for (ComposantDessin comp : this.comp) {
      comp.afficher();
    }
    System.out.println(";");
  }
  
  @Override
  public void deplacer(Point pp) {
    for (ComposantDessin comp : this.comp) {
      comp.deplacer(pp);
    }
  }

  public List<ComposantDessin> getListeNonModifiable() {

    return Collections.unmodifiableList(this.comp);
  }



@Override
public void ComposantDessin(String nom) {
	// TODO Auto-generated method stub
	
}

@Override
public String getNom() {
	// TODO Auto-generated method stub
	return null;
}
}
