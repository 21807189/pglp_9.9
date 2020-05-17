package mou;


public class Rectangle extends Forme {
	
	//InfDroit correcpond au point inferieur droite
    private Point InfDroit;

    public Rectangle(final String nom, final Point SG, final Point ID) {
        super(nom, SG);
        this.InfDroit = ID;
    }

   
    public int getlongueur() {
        int l = this.InfDroit.getx() - super.getpointprincipal().getx();
        return (l < 0) ? -l : l;
    }

  
    public void deplacer(final Point pp) {
        super.deplacer(pp);
        this.InfDroit.deplacer(pp);
    }

    @Override
    public void afficher() {
        System.out.println(super.getnom() + " : Rectangle(PointSuperieurGauche="
                + super.getpointprincipal() + ",PointInferieurDroite="
                + this.InfDroit+ ")");
    }

    
}
