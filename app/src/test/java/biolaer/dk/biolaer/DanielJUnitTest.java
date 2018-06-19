package biolaer.dk.biolaer;

//Importerer nødvendige libraries
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Denne klasse udgør Daniels JUnit-test.
 */
public class DanielJUnitTest {

    //Standard addition-test
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    /**
     * INDLEDNING:
     * Da hele vores applikation er bygget på, at brugeren kan svare på biologispørgsmål,
     * er det utrolig vigtigt, at klassen "easyFragment" eksisterer, da det er den, som fremkalder
     * random spørgsmål i den lette kategori af quizzen.
     *
     * TEST:
     * Derfor tester denne metode, om "easyFragment" eksisterer i folderen "Activities".
     * Hvis den ikke findes, bliver der throwet en ClassNotFound-exception.
     */
    @Test
    public void testClassExists() {
        try {
            Class.forName("biolaer.dk.biolaer.Activities.easyFragment");
        } catch (ClassNotFoundException e) {
            Assert.fail("Der skal være en klasse kaldet easyFragment!");
        }
    }

    /**
     * INDLEDNING:
     * Et Intent-objekt er limen mellem to activities. Det er derfor væsentligt, at dette objekt
     * fx indeholder argumentet "packageContext", så objektet ved, hvor det skal fragtes hen.
     *
     * TEST:
     * Med "assertNotNull" kan man teste, om et objekt har indhold eller er null.
     * I denne test tester jeg, om variablen "test" er initialiseret.
     */
    @Test
    public void testClassProperty() {

        String test = "Test tekst";

        assertNotNull(test);
    }
}