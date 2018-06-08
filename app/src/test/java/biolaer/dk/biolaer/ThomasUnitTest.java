package biolaer.dk.biolaer;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * I denne klasse er JUnit-Test uviklet af Thomas.
 * I klassen er udviklet fem tests, som alle bygger på den samme metode.
 * Hver test tjekker om en specifik score giver den ønskede rank.
 * Alle fem tests går succesfuldt igennem.
 */
public class ThomasUnitTest {
    @Test
   public void testRank1(){
        boolean isRankCorrect = false;

        QuestionsActivity obj = new QuestionsActivity();
        QuestionsActivity.pointT = 0;

        if (obj.getRank().equals("Noob")){
            isRankCorrect = true;
        }

        assertTrue(isRankCorrect);

    }
    @Test
    public void testRank2(){
        boolean isRankCorrect = false;

        QuestionsActivity obj = new QuestionsActivity();
        QuestionsActivity.pointT = 100;

        if (obj.getRank().equals("Begynder")){
            isRankCorrect = true;
        }

        assertTrue(isRankCorrect);

    }
    @Test
    public void testRank3(){
        boolean isRankCorrect = false;

        QuestionsActivity obj = new QuestionsActivity();
        QuestionsActivity.pointT = 200;

        if (obj.getRank().equals("Folkeskoleelev")){
            isRankCorrect = true;
        }

        assertTrue(isRankCorrect);

    }
    @Test
    public void testRank4(){
        boolean isRankCorrect = false;

        QuestionsActivity obj = new QuestionsActivity();
        QuestionsActivity.pointT = 300;

        if (obj.getRank().equals("Gymnasieelev")){
            isRankCorrect = true;
        }

        assertTrue(isRankCorrect);

    }
    @Test
    public void testRank5(){
        boolean isRankCorrect = false;

        QuestionsActivity obj = new QuestionsActivity();
        QuestionsActivity.pointT = 301;

        if (obj.getRank().equals("Pro")){
            isRankCorrect = true;
        }

        assertTrue(isRankCorrect);

    }

}

