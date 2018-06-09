package biolaer.dk.biolaer;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Vi har IKKE lavet nogen Instrumented Tests.
 * Derfor er denne klasse i princippet overflødig.
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("biolaer.dk.biolaer", appContext.getPackageName());
    }
}
