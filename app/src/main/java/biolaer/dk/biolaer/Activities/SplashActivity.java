package biolaer.dk.biolaer.Activities;

//Nødvendige imports
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import biolaer.dk.biolaer.R;

/**
 * Denne klasse udgør den Splash Activity, der vises kort inden selve app'en åbner op.
 * Den er angivet som både LAUCHER og MAIN i Manifest-filen, men den reelle main er dog
 * i praksis stadig MainActivity.java.
 */
public class SplashActivity extends AppCompatActivity {

    /* Hvor længe skal Splash Activity vises, før app'en åbner rigtigt.
    Angiv evt. til 500, når der debugges, men husk bagefter at ændre til 5000 */
    private final int SPLASH_DISPLAY_LENGTH = 5000; //5000 = 5 sekunder

    //Metode der fortsat fjerner navigationsbaren, selvom der klikkes et sted i aktiviteten.
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    /** Overrider Android's default onCreate-metode og initialiserer med ønsket indhold */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        //Følgende kodestykke fjerner bl.a. navigationsbaren i bunden af aktiviteten.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

        // Handler der starter MainActivity og lukker Splash Screen efter nogle sekunder.
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                // Opretter et intent-objekt der starter MainActivity.
                Intent mainIntent = new Intent(SplashActivity.this,
                        MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}