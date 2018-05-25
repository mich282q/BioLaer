package biolaer.dk.biolaer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        Button infoBtn = (Button) findViewById(R.id.infoBtn);
        final Button easyBtn = (Button) findViewById(R.id.easyBtn);
        final Button hardBtn = (Button) findViewById(R.id.hardBtn);

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

    }
}
