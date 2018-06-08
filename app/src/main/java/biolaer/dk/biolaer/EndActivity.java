package biolaer.dk.biolaer;

//Nødvendige imports
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class EndActivity extends AppCompatActivity {

    QuestionsActivity fa1 = new QuestionsActivity();

    TextView displayScore;
    EditText insertName;
    Button submitButton;
    String point = "10";


    //Variabler til Firebase-connection
    FirebaseDatabase database;
    DatabaseReference highscore;

    //søger for de ikke kan gå tilbage og svare videre på spørgsmålen.
  /*  @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
*/
    QuestionsActivity questionsActivity = new QuestionsActivity();
    //Scoren scoren fra QuestionsActivity
    int samledeScore = questionsActivity.getPointT();


    public void dataAdded(){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(EndActivity.this);
        builder
                .setMessage("Du er blevet tilføjet til highscorelisten! :)")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(mainActivity);
                    }
                })
                .show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        //Firebase connection
        database = FirebaseDatabase.getInstance();
        highscore = FirebaseDatabase.getInstance().getReference("highscore").child("highscore_easy");

        //Tvinger activitien til at være i "Portrait orientation mode".
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        //Display score
        displayScore = (TextView) findViewById(R.id.pointTxt);


        displayScore.setText(samledeScore + "");





        //Knapper
        submitButton = (Button)findViewById(R.id.submitBtn_button);
        insertName = (EditText)findViewById(R.id.insertNameTxt);

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

        /** Kalder en "setOnClickListener" på "submitButton"  som indeholder metoden addScore
         * som tilføjer navn og score til highscore databasen **/
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addScore();
            }
        });
    }


   private void addScore() {

        String name = insertName.getText().toString().trim();

        String key = highscore.push().getKey();

        if(!TextUtils.isEmpty(insertName.getText().toString())){

            Map<String, Object> score = new HashMap<>();
            score.put("navn", name);
            score.put("point", samledeScore);
            highscore.push().setValue(score);

            dataAdded();

           /* String id = highscore.push().getKey();

            QuestionsActivity qa = new QuestionsActivity(name, point);

            highscore.child(id).setValue(qa);*/

            Toast.makeText(this,"Score tilføjet!", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this,"Indtast navn!", Toast.LENGTH_LONG).show();
        }
    }
}