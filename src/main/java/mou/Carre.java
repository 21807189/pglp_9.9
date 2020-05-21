package mou;

public class Carre extends Forme {
	
	public Point ID;
	private int cote;
	 int x,y;

    public Carre(final String nom, final Point SG, final int cote) {
    	
        super(nom, SG);
        this.ID=new Point((SG.getx()) + cote, SG.gety() + cote);
        this.cote=(ID.getx()-SG.getx());
        
    }
    
    public int getcote() {
    	return cote;
    }
    
    public int getx() {
    	return x;
    }
    
    public int gety() {
    	return y;
    }
    


   
    @Override
    public void afficher() {
        System.out.println(super.getnom() + " : Carré(HautGauche="
                + super.getpointprincipal() + ",cote="
                + this.cote + ")");
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
