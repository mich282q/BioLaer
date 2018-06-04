package biolaer.dk.biolaer;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        // Tvinger activityen til at være i Portrait orientation mode.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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

        /*
 // udkast til rankTxt.
        TextView rankTxt = (TextView) findViewById(R.id.rankTxt);


        public void getpoint(){
            String rankTitle;

            if (point < 200) {
                rankTitle = "highschool";
            }
            else if (point < 300) {
                rankTitle = "HF";
            }
            else if (point < 400) {
                rankTitle = "HTX";
            }
            else if (point <500) {
                rankTitle = "EASJ";
            }
        }
        */
    }
}
