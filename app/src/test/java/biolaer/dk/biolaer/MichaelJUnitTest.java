package biolaer.dk.biolaer;

import org.junit.Assert;
import org.junit.Test;

/**
 * I denne klasse er gruppens JUnit Tests placeret. Et krav fra faget Programmering.
 */

public  class MichaelJUnitTest {
    /**
     * Tester at Class findes i vores projekt
     */
    @Test
    public void DoesTheObjectExist() {
        try {
            Class.forName("biolaer.dk.biolaer.Activities.HardHsActivity");
        } catch (ClassNotFoundException e) {
            Assert.fail("object was not found");
        }


    }
    /**
     * Tester at Class ikke findes i vores projekt
     */
    @Test
    public void DoesTheObjectExist1() {
        try {
            Class.forName("biolaer.dk.biolaer.tester");
        } catch (ClassNotFoundException e) {
            Assert.fail("object was not found");
        }

    }}

