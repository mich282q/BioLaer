package biolaer.dk.biolaer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button startBtn = (Button) findViewById(R.id.startBtn);
        Button highscoreBtn = (Button) findViewById(R.id.highscoreBtn);

        //Metode til startBtn som får knappen til at springe videre til LevelActivity
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent levelActivity = new Intent(getApplicationContext(), LevelActivity.class);
                startActivity(levelActivity);
            }
        });

        //Metode til startBtn som får knappen til at springe videre til HighscoreActivity
        highscoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent highscoreActivity = new Intent(getApplicationContext(), HighscoreActivity.class);
                startActivity(highscoreActivity);
            }
        });
    }
}
