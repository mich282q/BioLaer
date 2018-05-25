package biolaer.dk.biolaer;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Tvinger activityen til at være i Portrait orientation mode. 
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button confirmBtn = (Button) findViewById(R.id.confirmBtn);
        Spinner categorySpinner = (Spinner) findViewById(R.id.categorySpinner);

        /*Opretter en arrayapadter med brug af string array og knytter spinner_array på som er
        lavet i xml filen under values. */
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinners_array, android.R.layout.simple_spinner_item);

        //Bare udseende, så det bliver lidt mere lækkert når man klikker på spinneren.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Sætter adapteren til spinneren
        categorySpinner.setAdapter(adapter);

    }
}
