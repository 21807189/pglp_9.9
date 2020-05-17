package mou;

public class Point implements Deplace {
    private int x;
    private int y;

   
    public Point(final int abs, final int ord) {
        this.x = abs;
        this.y = ord;
    }

   
    public void deplacer(final Point pp) {
        this.x += pp.getx();
        this.y += pp.gety();
    }

    public int getx() {
        return x;
    }

    
    public int gety() {
        return y;
    }

    public Point nouveau() {
        return new Point(x, y);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point other = (Point) obj;
        if (x != other.x) {
            return false;
        }
        if (y != other.y) {
            return false;
        }
        return true;
    }
    public void afficher() {
        System.out.println("(" + this.x + ", " + this.y + ")");
    }
}
