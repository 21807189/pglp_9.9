package mou;

public class Cercle extends Forme {
    private int rayon;
    public Point centre; 

    public Cercle(final String nom, final Point centre, final int r) {
        super(nom, centre);
        this.rayon = r;
    }

    public int getrayon() {
    	return rayon;
    }
   
    @Override
    public void afficher() {
        System.out.println(super.getnom() + " : Cercle(centre="+ super.getpointprincipal() + ",rayon=" + this.rayon+ ")");
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
