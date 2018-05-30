package biolaer.dk.biolaer;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Timer timer = new Timer();

        // Tvinger activityen til at være i Portrait orientation mode.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);
        Button debugBtn = (Button) findViewById(R.id.debugBtn); //Kun til debug

        /** Kalder en "setOnClickListener" på "optionsBtn" der dikterer, hvad der skal ske,
        når brugeren klikker på cockwheel-ikonet i hjørnet */
        optionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent optionsActivity = new Intent(getApplicationContext(), OptionsActivity.class);
                startActivity(optionsActivity);
            }
        });

        /** Når der klikkes på "Debug" går den automatisk til "EndActivity".
         * DETTE ER KUN TIL DEBUG! Kan fjernes senere i processen. */
        debugBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent debug = new Intent(getApplicationContext(), EndActivity.class);
                startActivity(debug);
            }
        });
    }
}
