package biolaer.dk.biolaer;

import android.os.Bundle;


import java.util.Locale;

import static org.junit.Assert.*;

public class MathiasJUnitTest {

    /* Ved brug af assertEquals kan vi teste om vi får det forventede resultat som vist i
        simpleTest moetden
     */

    public void simpleTest(){

        //Deklarer variabler
        int a = 2;
        int b = 2;
        int result = 4;

        //AssertStatement
         assertEquals( result, a+b);

    }

    public void testSame() {

        /* Ved brug af assertSame kan vi teste om det begge objekter referer til det samme objekt
            derefter for at double tjekke er der taget assertNotSame i brug, som ligeledes tester
            at begge objekter IKKE referer til det samme objekt.
         */

        //Deklarer variabler
        String string1 = "Vi tester om denne String er den samme som String2";
        String string2 = "Vi tester om denne String er den samme som String1";

        //AssertStatement
        assertSame(string1, string2);
        assertNotSame(string1, string2);

    }


}