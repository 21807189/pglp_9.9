package mou;

public class Triangle extends Forme {
	
    public Point pointb;
    public Point pointc;
	public Point pointa;
    

    public Triangle(final String n, final Point pa, final Point pb, final Point pc) {
        super(n, pa);
        this.pointb = pb;
        this.pointc = pc;
    }

    @Override
    public void deplacer(final Point pp) {
        super.deplacer(pp);
        this.pointb.deplacer(pp);
        this.pointc.deplacer(pp);
    }

   @Override
    public void afficher() {
        System.out.println(super.getnom() + " : Triangle(pointa="
                + super.getpointprincipal() + ",pointb="
                + this.pointb + ",pointc=" + this.pointc
                + ")");
    }
    

}
