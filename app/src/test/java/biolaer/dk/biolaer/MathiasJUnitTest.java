package biolaer.dk.biolaer;

import android.os.Bundle;
import android.widget.TextView;


import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class MathiasJUnitTest {

    /* Ved brug af assertEquals kan vi teste om vi får det forventede resultat som vist i
        simpleTest moetden
     */
    @Test
    public void simpleTest(){

        //Deklarer variabler
        int a = 2;
        int b = 2;
        int result = 4;

        //AssertStatement
         assertEquals( result, a+b);

    }
    @Test
    public void testSame() {

        /* Ved brug af assertSame kan vi teste om det begge objekter referer til det samme objekt
            */

        //Deklarer variabler
        String string1 = "Denne string er ens med den anden string";
        String string2 = "Denne string er ens med den anden string";

        //AssertStatement
        assertSame(string1, string2);

    }

    /* Ved brug af assertNotSame tester vi at begge objekter ikke er det samme objekt */

    @Test
    public void testNotSame(){
        //Deklarer variabler
        String string1 = "Vi tester om denne String er den samme som String2";
        String string2 = "Vi tester om denne String er den samme som String1";

        //AssertStatement
        assertNotSame(string1, string2);
    }
}