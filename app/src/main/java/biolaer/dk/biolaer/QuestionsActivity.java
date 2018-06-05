package biolaer.dk.biolaer;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class QuestionsActivity extends AppCompatActivity {


    String point;
    String navn;

    public QuestionsActivity(){

    }

    public QuestionsActivity(String point, String navn) {
        this.point = point;
        this.navn = navn;
    }
    public void setPoint(String point) {
        this.point = point;

    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getPoint() {
        return point;
    }

    public String getNavn() {
        return navn;
    }

Question qq = new Question();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
         Timer timer = new Timer();

       //EditText actualPoint_textView = (EditText) findViewById(R.id.pointTest);
        //actualPoint_textView.setText(qq.point);


        // Tvinger activityen til at være i Portrait orientation mode.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);

        /** Kalder en "setOnClickListener" på "optionsBtn" der dikterer, hvad der skal ske,
         når brugeren klikker på cockwheel-ikonet i hjørnet */
        optionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent optionsActivity = new Intent(getApplicationContext(), OptionsActivity.class);
                startActivity(optionsActivity);
            }
        });



    }
}