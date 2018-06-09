package biolaer.dk.biolaer.Activities;

//Nødvendige imports
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import biolaer.dk.biolaer.R;

/**
 * Denne klasse udgør det skærmbillede brugeren ser, når der skal vælges, hvilken sværhedsgrad
 * der skal vises highscore for.
 */
public class HighscoreActivity extends AppCompatActivity {

    /**
     * Denne metode overrider den default onCreate-metode, og initialiserer den med de fields,
     * der skal præsenteres på vores HighscoreActivity.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        //Tvinger activitien til at være i "Portrait orientation mode".
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Følgende kodestykke fjerner navigationsbaren i bunden af aktiviteten.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        /* Fields der connecter til buttons i xml-filen.
        De to knapper eastBtn og hardBtn skal være final for at virke optimalt! */
        Button infoBtn = (Button) findViewById(R.id.infoBtn);
        final Button easyBtn = (Button) findViewById(R.id.easyBtn);
        final Button hardBtn = (Button) findViewById(R.id.hardBtn);
        Button returnBtn = (Button) findViewById(R.id.returnBtn);
        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);

        //Metode til info-knappen, som ændrer teksten på knapperne frem og tilbage.
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (easyBtn.getText().equals("Let")) {
                    easyBtn.setText("Direkte ELISA");
                    hardBtn.setText("Indirekte Sandwich ELISA");
                }
                else {
                    easyBtn.setText("Let");
                    hardBtn.setText("Svær");
                }
            }
        });

        //Metode som får easyBtn til at hoppe til EasyHsActivity
        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent easyHsActivity = new Intent(getApplicationContext(), EasyHsActivity.class);
                startActivity(easyHsActivity);
            }
        });

        //Metode som får hardBtn til at hoppe til HardHsActivty
        hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hardHsActivity = new Intent(getApplicationContext(), HardHsActivity.class);
                startActivity(hardHsActivity);
            }
        });

        //Metode som får returnBtn til at hoppe tilbage til activiten, som var før den nuværende.
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HighscoreActivity.super.onBackPressed();
            }
        });

        /** Kalder en "setOnClickListener" på "optionsBtn" der dikterer, hvad der skal ske,
         når brugeren klikker på cockwheel-ikonet i hjørnet **/
        optionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent optionsActivity = new Intent(getApplicationContext(), OptionsActivity.class);
                startActivity(optionsActivity);
            }
        });
    }
}