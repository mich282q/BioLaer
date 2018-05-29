package biolaer.dk.biolaer;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EasyHsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_hs);
        // Tvinger activityen til at være i Portrait orientation mode.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button returnBtn = (Button) findViewById(R.id.returnBtn);

        //Metode som får returnBtn til at hoppe tilbage til aktiviteten, som var før den nuværende.
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyHsActivity.super.onBackPressed();
            }
        });
    }
}
