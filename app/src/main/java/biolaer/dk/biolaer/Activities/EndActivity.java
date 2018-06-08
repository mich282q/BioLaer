package biolaer.dk.biolaer.Activities;

//Nødvendige imports
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import biolaer.dk.biolaer.R;

public class EndActivity extends AppCompatActivity {

    //Deklarerer variabler
    TextView displayScore, displayRank;
    EditText insertName;
    Button submitButton;
    Button tryAgainButton;

    //Variabler til Firebase-connection
    FirebaseDatabase database;
    DatabaseReference highscore;

    //Opretter et nyt objekt af QuestionsActivity
    QuestionsActivity questionsActivity = new QuestionsActivity();

    //Metode til at udelukker muligheden for at efter forkert svar gå tilbage og spille videre.
   @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }


    //Samlet score fra QuestionsActivity
    int samledeScore = questionsActivity.getPointT();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        //Firebase connection
        database = FirebaseDatabase.getInstance();
        highscore = FirebaseDatabase.getInstance()
                .getReference("highscore")
                .child("highscore_easy");

        //Tvinger activitien til at være i "Portrait orientation mode".
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        //Display score
        displayScore = (TextView) findViewById(R.id.pointTxt);
        displayScore.setText(samledeScore + "");

        //Display rank
        displayRank = (TextView) findViewById(R.id.rankTxt);
        displayRank.setText(questionsActivity.getRank());

        //Knap til at starte spillet på ny
        tryAgainButton = (Button)findViewById(R.id.tryAgainBtn_button);

        tryAgainButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent levelActivity = new Intent(getApplicationContext(), LevelActivity.class);
                startActivity(levelActivity);
            }
        });

        //Submit knappen
        submitButton = (Button)findViewById(R.id.submitBtn_button);

        /** Kalder en "setOnClickListener" på "submitButton"  som indeholder metoden addScore
         * som tilføjer navn og score til highscore databasen **/
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                addScore();
                startActivity(mainActivity);
            }
        });

        //Indtast navn felt som tager imod brugerinput.
        insertName = (EditText)findViewById(R.id.insertNameTxt);

        //Knap til indstillinger (OptionsActivity)
        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);

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

    /** addScore metoden tilføjer brugerindtastet navn og total scoren fra brugerens spil session
      til firebase databasen. **/
   private void addScore() {

       // Tager imod det indtastede navn.
        String name = insertName.getText().toString().trim();
       // Genererer et unikt ID til databasen.
        String key = highscore.push().getKey();

        // Tjekker om navn er blevet indtastet, og udfører en handling ud fra det.
        if(!TextUtils.isEmpty(insertName.getText().toString())){

            // Opretter HashMap til at samle data.
            Map<String, Object> score = new HashMap<>();

            // Tilføjer elementer til HashMap
            score.put("navn", name);
            score.put("point", samledeScore);

            // Indsender dataerne med deres rigtige værdier til firebase databasen.
            // Dataen bliver lagt ind i databasen under et unikt ID.
            highscore.push().setValue(score);

            // Laver en toast med bekræftelse på at dataen er blevet tilføjet til databasen.
            Toast.makeText(this,"Score tilføjet!", Toast.LENGTH_LONG).show();

        } else {
            // Viser en fejlmeddelse om at der mangler at blive indtastet navn.
            Toast.makeText(this,"Indtast navn!", Toast.LENGTH_LONG).show();
        }
    }
}