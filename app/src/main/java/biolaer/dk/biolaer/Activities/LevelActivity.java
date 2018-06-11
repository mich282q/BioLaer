package biolaer.dk.biolaer.Activities;

//Nødvendige imports
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import biolaer.dk.biolaer.R;

/**
 * Denne klasse indeholder vores activity for valg af sværhedsgrad i app'en.
 * Klassen har onCreate og onClick-metoder.
 */
public class LevelActivity extends AppCompatActivity { //Extender AppCompatActivity

    @Override
    public void onBackPressed() { //Overrider return mode
        //Søger for at når man trykker på return knap, kommer man til Main Class
        this.startActivity(new Intent(LevelActivity.this,MainActivity.class));

        return;
    }

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

    /**
     * Overrider den default metode, der automatisk oprettes til en activity, og definerer i stedet
     * de fields og actions, vi ønsker i vores onCreate-metode. Bl.a. knapper til sværhedsgrad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        //Tvinger activitien til at være i "Portrait orientation mode".
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Følgende kodestykke fjerner bl.a. navigationsbaren i bunden af aktiviteten.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

        //Connecter fields til buttons fra xml-filen.
        Button infoBtn = (Button) findViewById(R.id.infoBtn);
        final Button easyBtn = (Button) findViewById(R.id.easyBtn);
        final Button hardBtn = (Button) findViewById(R.id.hardBtn);
        Button returnBtn = (Button) findViewById(R.id.returnBtn);
        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);

        //Metode til info-knappen, som ændrer teksten på knapperne frem og tilbage.
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Hvad der sker, når der klikkes på knappen.
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

        //Metode som får returnBtn til at hoppe tilbage til activiteten, som var før den nuværende.
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LevelActivity.super.onBackPressed();
                //søger for at nå man trykker på return knapper kommer man til Main Class
                startActivity(new Intent(LevelActivity.this,MainActivity.class));
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

        /** VIGTIG INFO:
         * Når der klikkes på enten "Let" eller "Svær" går den til QuestionsActivity-klassen.
         * Hvis du vælger "Let" loades Fragment1 så i aktiviteten.
         * Hvis du vælger "Svær" loades Fragment2 så i aktiviteten. */
        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent easyActivity = new Intent(getApplicationContext(), QuestionsActivity.class);
                startActivity(easyActivity);
            }
        });

        //Toast til knappen "Svær", da denne sværhedsgrad ikke er udviklet endnu.
        hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LevelActivity.this, "Under udvikling", Toast.LENGTH_SHORT).show();

            }
        });
    }
}