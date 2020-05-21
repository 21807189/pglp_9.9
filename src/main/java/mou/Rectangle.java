package mou;


public class Rectangle extends Forme {
	
	//InfDroit correcpond au point inferieur droite
	public Point SG;
    private Point InfDroit;

    public Rectangle(final String nom, final Point SG, final Point ID) {
        super(nom, SG);
        this.InfDroit = ID;
    }

 
    public int getlongueur() {
        int l = this.InfDroit.getx() - super.getpointprincipal().getx();
        return (l < 0) ? -l : l;
    }
    
    public int getlargeur() {
        int lg =  super.getpointprincipal().gety()-this.InfDroit.gety();
        return (lg < 0) ? -lg : lg;
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


	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void ComposantDessin(String nom) {
		// TODO Auto-generated method stub
		
	}

    
}
