package biolaer.dk.biolaer;

import org.junit.Test;

import biolaer.dk.biolaer.Activities.QuestionsActivity;

import static org.junit.Assert.*;

/**
 * I denne klasse er JUnit-Test udviklet af Thomas.
 * I klassen er der udviklet seks tests, som alle bygger på den samme metode.
 * Hver test tjekker om en specifik score giver den ønskede rank.
 * Alle 6 tests går succesfuldt igennem.
 */
public class ThomasJUnitTest {

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
        QuestionsActivity.pointT = 600;

        if (obj.getRank().equals("Gymnasieelev")){
            isRankCorrect = true;
        }

        assertTrue(isRankCorrect);

    }
    @Test
    public void testRank5(){
        boolean isRankCorrect = false;

        QuestionsActivity obj = new QuestionsActivity();
        QuestionsActivity.pointT = 1000;

        if (obj.getRank().equals("Biologientusiast")){
            isRankCorrect = true;
        }

        assertTrue(isRankCorrect);

    }
    @Test
    public void testRank6(){
        boolean isRankCorrect = false;
        QuestionsActivity obj = new QuestionsActivity();
        QuestionsActivity.pointT = 1201;

        if (obj.getRank().equals("Pro!")){
            isRankCorrect = true;
        }

        assertTrue(isRankCorrect);
    }

}

