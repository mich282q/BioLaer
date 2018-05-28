package biolaer.dk.biolaer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HighscoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        Button infoBtn = (Button) findViewById(R.id.infoBtn);
        final Button easyBtn = (Button) findViewById(R.id.easyBtn);
        final Button hardBtn = (Button) findViewById(R.id.hardBtn);
        Button returnBtn = (Button) findViewById(R.id.returnBtn);

        //Metode til info-knappen, som ændret teksten på knapperne frem og tilbage.
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (easyBtn.getText()=="Let"){
                    easyBtn.setText("Direkte ELISA");
                    hardBtn.setText("Indirekte Sandwich ELISA");}
                else{
                    easyBtn.setText("Let");
                    hardBtn.setText("Svær");
                }
            }

        });

        //Metode som får easyBtn til at hoppe til EasyHsActivity
        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent easyHsActivity = new Intent(getApplicationContext(), EasyHsActivity.class);
                startActivity(easyHsActivity);
            }
        });

        //Metode som får hardBtn til at hoppe til HardHsActivty
        hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hardHsActivity = new Intent(getApplicationContext(), HardHsActivity.class);
                startActivity(hardHsActivity);
            }
        });

        //Metode som får returnBtn til at hoppe tilbage activiten, som var før den nuværende.
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HighscoreActivity.super.onBackPressed();
            }
        });
    }
}
