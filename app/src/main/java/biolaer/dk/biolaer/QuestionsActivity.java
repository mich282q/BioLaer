package biolaer.dk.biolaer;

//Importerer nødvendige libraries
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
import android.widget.Toast;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import org.w3c.dom.Text;

public class QuestionsActivity extends AppCompatActivity {

    //Klassevariabler el. fields
    TextView actualPoint_textView;

    //Metode der tilføjer 100 point til dine samlede point
    public void addPoints(){
        int pointT = Integer.parseInt(actualPoint_textView.getText().toString());
        actualPoint_textView.setText(pointT + 100 + "");
    }

    Fragment1 fragment1 = new Fragment1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Timer timer = new Timer();

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