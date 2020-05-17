package mou;

public class Cercle extends Forme {
    private int rayon;
    private Point centre; 

    public Cercle(final String nom, final Point centre, final int r) {
        super(nom, centre);
        this.rayon = r;
    }

   
    @Override
    public void afficher() {
        System.out.println(super.getnom() + " : Cercle(centre="+ super.getpointprincipal() + ",rayon=" + this.rayon+ ")");
    }

}
