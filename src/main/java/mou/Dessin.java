package mou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Dessin implements ComposantDessin {
    private String nom;
    private ArrayList<ComposantDessin> composants;

    public Dessin(final String n) {
        this.nom = n;
        this.composants = new ArrayList<>();
    }

    public void ajoute(final ComposantDessin d) {
        composants.add(d);
    }
    
    public void ajouteTout(final List<ComposantDessin> comp) {
        composants.addAll(comp);
    }

    @Override
    public void deplacer(final Point pp) {
        for (ComposantDessin d : composants) {
            d.deplacer(pp);
        }
    }
   
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dessin)) {
            return false;
        }
        Dessin other = (Dessin) obj;
        if (composants == null) {
            if (other.composants != null) {
                return false;
            }
        } else if (!composants.equals(other.composants)) {
            return false;
        }
        if (nom == null) {
            if (other.nom != null) {
                return false;
            }
        } else if (!nom.equals(other.nom)) {
            return false;
        }
        return true;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void afficher(){
        System.out.println("("+this.nom+","+this.composants+")") ;
    }

    
   
}
