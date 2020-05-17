package mou;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class CercleTest {

    
    @Test
    public void deplaceTest() {
    	
        Cercle c = new Cercle("c1", new Point(0, 0), 5);
        c.deplacer(new Point(1, 1));
        Cercle nouveau = new Cercle("c1", new Point(1, 1), 5);
        assertEquals(nouveau, c);
    }
}
