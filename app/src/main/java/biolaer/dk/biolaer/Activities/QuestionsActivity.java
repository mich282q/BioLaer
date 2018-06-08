package biolaer.dk.biolaer.Activities;

//Importerer nødvendige libraries
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import biolaer.dk.biolaer.BusinessLogic.Timer;
import biolaer.dk.biolaer.R;

public class QuestionsActivity extends AppCompatActivity {




    //Klassevariabler el. fields
    static TextView actualPoint_textView;
    public static int pointT;

    //Metode der tilføjer 100 point til dine samlede point
    public void addPoints(){
        pointT = Integer.parseInt(actualPoint_textView.getText().toString());
        actualPoint_textView.setText(pointT + 100 + "");
    }

    public int getPointT() {
        pointT = Integer.parseInt(actualPoint_textView.getText().toString());
        return  pointT; }



        public String getRank(){
        String rank = "";
        if (pointT == 0){
            rank = "Noob";
        }
        else if (pointT == 100){
        rank = "Begynder";
        }
        else if (pointT == 200){
            rank = "Folkeskoleelev";
        }
        else if (pointT == 300){
            rank = "Gymnasieelev";
        }
       else {
            rank = "Pro";
        }
        return rank;
        }

        TextView actualTime_textView;

    Fragment1 fragment1 = new Fragment1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Timer timer = new Timer();

        //actualTime_textView = (TextView) findViewById(R.id.actualTime_textView);

        //Lokale fields der forbinder til xml-filen
        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);
        actualPoint_textView = (TextView) findViewById(R.id.actualPoint_textView);

        //Tvinger aktiviteten til at være i "Portrait orientation mode".
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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