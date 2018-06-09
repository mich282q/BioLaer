package biolaer.dk.biolaer.Activities;

//Nødvendige imports
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import biolaer.dk.biolaer.BusinessLogic.MusicService;
import biolaer.dk.biolaer.R;

/**
 * Denne klasse indeholder bl.a. onCreate-metoden, som starter vores MainActivity.
 * I MainActivity vælger man hvilken kategori indenfor biologiens verden man ønsker,
 * der bliver 'quizzet' om. I den første udgave af BioLær App kan der kun vælges ELISA.
 *
 * Systemet er udviklet som en del af førsteårseksamen på datamatikerstudiet.
 * Problemstiller og case-person: Marianne Skov, mask@easj.dk
 *
 * @author Daniel, Mathias, Michael, Sebastian og Thomas.
 * @version 1.0
 * @since Maj 2018
 *
 * CREDITS:
 * Background music obtained from: www.bensound.com
 * Sound effects obtained from: www.zapsplat.com
 */
public class MainActivity extends AppCompatActivity {
    //En Android Activity extender enten Activity-klassen eller AppCompatActivity-klassen.

    //Nødvendige klassevariabler
    private boolean mIsBound = false;
    private MusicService mServ;

    /**
     * De følgende metoder omhandler den service, som baggrundsmusikken repræsenterer.
     */
    private ServiceConnection Scon = new ServiceConnection() {
        public void onServiceConnected(ComponentName name, IBinder binder) {
            mServ = ((MusicService.ServiceBinder) binder).getService();
        }
        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService() {
        bindService(new Intent(this, MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService() {
        if (mIsBound) {
            unbindService(Scon);
            mIsBound = false;
        }
    }

    //Overrider den default onCreate-metode med vores properties til Main Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vedr. baggrundsmusikken til app'en
        MusicService mServ = new MusicService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        startService(music);

        //Tvinger activitien til at være i "Portrait orientation mode".
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Følgende kodestykke fjerner navigationsbaren i bunden af aktiviteten.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        //Fields der connecter til knapperne i xml-filen.
        final Button confirmBtn = (Button) findViewById(R.id.confirmBtn);
        final Spinner categorySpin = (Spinner) findViewById(R.id.categorySpinner);
        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);

        /* Opretter en ArrayApadter med brug af string array og knytter spinner_array på,
        som er lavet i xml-filen under values. */
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinners_array, android.R.layout.simple_spinner_item);

        //Bare udseende, så det bliver lidt mere lækkert, når man klikker på spinneren.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Sætter adapteren til spinneren
        categorySpin.setAdapter(adapter);

        //Metode som vælger ud fra spinnerens valg
        categorySpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0://Her har vi ELISA.
                        //Metode som får confirmBtn til at udføre en ordre
                        confirmBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //Intent-objekt som hopper videre til GameActivity
                                Intent gameActivity = new Intent(getApplicationContext(), GameActivity.class);
                                startActivity(gameActivity);
                            }
                        });
                        break;

                    case 1: //Her har vi DNA.
                        //Metode som får confirmBtn til at udføre en ordre
                        confirmBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //Viser en Toast på skærmen, da denne kategori endnu ikke er udviklet.
                                Toast.makeText(MainActivity.this, "Under udvikling", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;

                    case 2: //Her har vi ANATOMI.
                        //Metode som får confirmBtn til at udføre en ordre
                        confirmBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //Viser en Toast på skærmen, da denne kategori endnu ikke er udviklet.
                                Toast.makeText(MainActivity.this, "Under udvikling", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Metoden er nødvendig for at onItemSelectedListener kan virke.
                //Umiddelbart er det ikke nødvendigt at have noget her.
            }
        });

        /** Kalder en "setOnClickListener" på "optionsBtn" der dikterer, hvad der skal ske,
         når brugeren klikker på cockwheel-ikonet i hjørnet **/
        optionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent optionsActivity = new Intent(getApplicationContext(), OptionsActivity.class);
                startActivity(optionsActivity);
            }
        });
    }

    //Definerer hvad der skal ske, når activitien lukkes.
    @Override
    public void onDestroy() {
        super.onDestroy();
        MusicService mServ = new MusicService();
        stopService(new Intent (this, MusicService.class));
        mServ.onDestroy();
    }
}