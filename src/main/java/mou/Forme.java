package mou;

public abstract class Forme implements Deplace {
	
    private Point point_principal;
    private String nom;

    protected Forme(final String n, final Point p) {
        this.nom = n;
        this.point_principal = p;
    }

    public void deplacer(final Point pp) {
        this.point_principal.deplacer(pp);
    }

    public void afficher() {
    	
    	
	}

   // nouveau correspond au nouveau point
    
    public Point getpointprincipal() {
        return point_principal.nouveau();
    }

    public String getnom() {
        return nom;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Forme)) {
            return false;
        }
        Forme other = (Forme) obj;
        if (nom == null) {
            if (other.nom != null) {
                return false;
            }
        } else if (!nom.equals(other.nom)) {
            return false;
        }
        if (point_principal == null) {
            if (other.point_principal != null) {
                return false;
            }
        } else if (!point_principal.equals(other.point_principal)) {
            return false;
        }
        return true;
    }

	   
}
