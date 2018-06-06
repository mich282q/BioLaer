package biolaer.dk.biolaer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}

/* NOTER fra András:
public class randomQuestionUnitTest {
    @Test
    public void easyRandomQuestion_isCorrect() {
        boolean erDerFejl = false; 
            
        int randomNumber;
        
        //løkke der kører 100 gange {
        randomNumber = Fragment1.randomQuestion(); // Denne skal returnere et tal mellem 4 og 8 
        if  (randomNumber<4) {erDerFejl = true} ;
        if  (randomNumber>8) {erDerFejl = true} ;
        }

        assertFalse(erDerFejl);
    }
}



*/
