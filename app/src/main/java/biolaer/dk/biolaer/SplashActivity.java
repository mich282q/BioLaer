package biolaer.dk.biolaer;

//Nødvendige imports
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

/**
 * Denne klasse udgør den Splash Activity, der vises kort inden selve app'en åbner op.
 * Den er angivet som både LAUCHER og MAIN i Manifest-filen, men den reelle main er dog
 * i praksis stadig MainActivity.java.
 */
public class SplashActivity extends AppCompatActivity {

    // Hvor længe skal Splash Activity vises, før app'en åbner rigtigt.
    private final int SPLASH_DISPLAY_LENGTH = 1000; //7 sekunder

    // Connecter progress baren i bunden af Splash Activity med baren i xml-filen
    //private ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

    /** Overrider Android's default onCreate-metode og initialiserer med ønsket indhold */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        // Handler der starter MainActivity og lukker Splash Screen efter nogle sekunder.
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                // Opretter et intent-objekt der starter MainActivity.
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}