package biolaer.dk.biolaer;

//Nøvendige imports
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity { //Extender AppCompatActivity

    /**
     * Overrider den default metode "onCreate" og tilføjer det indhold, vi ønsker "GameActivity"
     * skal fødes med. Bl.a. nødvendige fields og logik.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Tvinger activitien til at være i "Portrait orientation mode".
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Fields der connecter til buttons i xml-filen.
        Button startBtn = (Button) findViewById(R.id.startBtn);
        Button highscoreBtn = (Button) findViewById(R.id.highscoreBtn);
        Button returnBtn = (Button) findViewById(R.id.returnBtn);
        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);

        //Metode til startBtn som får knappen til at springe videre til LevelActivity.
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent levelActivity = new Intent(getApplicationContext(), LevelActivity.class);
                startActivity(levelActivity);
            }
        });

        //Metode til startBtn som får knappen til at springe videre til HighscoreActivity.
        highscoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent highscoreActivity = new Intent(getApplicationContext(), HighscoreActivity.class);
                startActivity(highscoreActivity);
            }
        });

        //Metode som får returnBtn til at hoppe tilbage til aktiviteten, som var før den nuværende.
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameActivity.super.onBackPressed();
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