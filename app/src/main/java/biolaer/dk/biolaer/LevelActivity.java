package biolaer.dk.biolaer;

//Nødvendige imports
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Denne klasse indeholder vores activity for valg af sværhedsgrad i app'en.
 * Klassen har onCreate og onClick-metoder.
 */
public class LevelActivity extends AppCompatActivity { //Extender AppCompatActivity

    /**
     * Overrider den default metode, der automatisk oprettes til en activity, og definerer i stedet
     * de fields og actions, vi ønsker i vores onCreate-metode. Bl.a. knapper til sværhedsgrad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        // Tvinger activitien til at være i "Portrait orientation mode".
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Connecter fields til buttons fra xml-filen.
        Button infoBtn = (Button) findViewById(R.id.infoBtn);
        final Button easyBtn = (Button) findViewById(R.id.easyBtn);
        final Button hardBtn = (Button) findViewById(R.id.hardBtn);
        Button returnBtn = (Button) findViewById(R.id.returnBtn);
        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);

        //Metode til info-knappen, som ændret teksten på knapperne frem og tilbage.
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Hvad der sker, når der klikkes på knappen.
                if (easyBtn.getText()=="Let") {
                    easyBtn.setText("Direkte ELISA");
                    hardBtn.setText("Indirekte Sandwich ELISA");
                }
                else {
                    easyBtn.setText("Let");
                    hardBtn.setText("Svær");
                }
            }
        });

        //Metode som får returnBtn til at hoppe tilbage activiteten, som var før den nuværende.
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LevelActivity.super.onBackPressed();
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
         * Når der klikkes på "Let-knappen" går den til QuestionsActivity-klassen.
         * Hvis spillet skal udvides, så der kommer Svær-niveau, skal dette som systemet er
         * konstrueret lige nu, linke til en anden activity!! */
        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent easyActivity = new Intent(getApplicationContext(), QuestionsActivity.class);
                startActivity(easyActivity);
            }
        });
    }
}