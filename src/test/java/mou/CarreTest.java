package mou;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CarreTest {

    
    @Test
    public void deplaceTest() {
    	
        Carre c = new Carre("c1", new Point(0,0), 5);
        c.deplacer(new Point(1, 1));
        Carre nouveau = new Carre("c1", new Point(1, 1), 5);
        assertEquals(nouveau, c);
}}
