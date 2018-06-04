package biolaer.dk.biolaer;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

public class EndActivity extends AppCompatActivity {

    EditText insertName;
    Button submitButton;
    String point = "10";

    FirebaseDatabase database;
    DatabaseReference highscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        //Firebase
        database = FirebaseDatabase.getInstance();
        highscore = FirebaseDatabase.getInstance().getReference("highscore");



        // Tvinger activityen til at være i Portrait orientation mode.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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
                addScore(insertName, point);
            }
        });
    }

   private void addScore(EditText insertName, String point) {



        /*String name = insertName.getText().toString().trim();
        String point = "10";*/

        if(!TextUtils.isEmpty(insertName.getText().toString())){

            highscore.child("highscore").child(point).setValue(insertName,point);

           /* String id = highscore.push().getKey();

            QuestionsActivity qa = new QuestionsActivity(name, point);

            highscore.child(id).setValue(qa);*/

            Toast.makeText(this,"Score tilføjet!", Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this,"Indtast navn!", Toast.LENGTH_LONG).show();
        }

    }

}
