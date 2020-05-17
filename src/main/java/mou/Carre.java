package mou;

public class Carre extends Forme {
	
	private Point cote;

    public Carre(final String nom, final Point SG, final int cote) {
    	
        super(nom, SG);
        this.cote=new Point((SG.getx()) + cote, SG.gety() + cote);
    }


   
    @Override
    public void afficher() {
        System.out.println(super.getnom() + " : Carré(HautGauche="
                + super.getpointprincipal() + ",cote="
                + this.cote + ")");
    }

    
   
}
