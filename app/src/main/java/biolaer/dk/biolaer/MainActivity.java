package biolaer.dk.biolaer;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * Denne klasse indeholder bl.a. onCreate-metoden, som starter vores MainActivity.
 * I MainActivity vælger man hvilken kategori indenfor biologiens verden man ønsker
 * der bliver 'quizzet' om.
 *
 * @author Daniel, Mathias, Michael, Sebastian og Thomas.
 * @version 1.0
 * @since Maj 2018
 *
 * Background music obtained from: www.bensound.com
 * Sound effects obtained from: www.zapsplat.com
 */
public class MainActivity extends AppCompatActivity {

    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this,MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Baggrundsmusikken
        MusicService mServ = new MusicService();
        Intent music = new Intent();
        music.setClass(this,MusicService.class);
        startService(music);
         **/

        // Tvinger activityen til at være i Portrait orientation mode.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final Button confirmBtn = (Button) findViewById(R.id.confirmBtn);
        final Spinner categorySpin = (Spinner) findViewById(R.id.categorySpinner);
        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);

        /**Opretter en ArrayApadter med brug af string array og knytter spinner_array på som er
         lavet i xml-filen under values. */
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinners_array, android.R.layout.simple_spinner_item);

        //Bare udseende, så det bliver lidt mere lækkert når man klikker på spinneren.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Sætter adapteren til spinneren
        categorySpin.setAdapter(adapter);

        //Metode som vælger ud fra spinnerens valg
        categorySpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0://Her har vi ELISA
                        //Metode som får confirmBtn til at udføre en ordre
                        confirmBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //Intent som hopper videre til GameActivity
                                Intent gameActivity = new Intent(getApplicationContext(), GameActivity.class);
                                startActivity(gameActivity);
                            }
                        });
                        break;

                    case 1: //Midlertidig "Test"
                        //Metode som får confirmBtn til at udføre en ordre
                        confirmBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //Viser en lille besked på skærmen :)
                                Toast.makeText(MainActivity.this, "Under udvikling.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;

                    case 2: //Midlertidig "Test"
                        //Metode som får confirmBtn til at udføre en ordre
                        confirmBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //Viser en lille besked på skærmen :)
                                Toast.makeText(MainActivity.this, "Under udvikling.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Metoden er nødvendig for at onItemSelectedListener kan virke
                //Umiddelbart er det ikke nødvendigt at have noget her
            }
        });

        optionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent optionsActivity = new Intent(getApplicationContext(), OptionsActivity.class);
                startActivity(optionsActivity);
            }
        });
    }
}