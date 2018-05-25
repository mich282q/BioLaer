package biolaer.dk.biolaer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button confirmBtn = (Button) findViewById(R.id.confirmBtn);
        Spinner categorySpinner = (Spinner) findViewById(R.id.categorySpinner);

    }
}
