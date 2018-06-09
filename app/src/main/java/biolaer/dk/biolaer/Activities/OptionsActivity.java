package biolaer.dk.biolaer.Activities;

//Nødvendige imports
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import biolaer.dk.biolaer.R;

/**
 * Denne klasse indeholder kildekoden til activitien vedr. indstillinger. Det er bl.a. her der
 * kan skrues op og ned for lyden. Dog findes logikken til dette i MusicService-klassen.
 */
public class OptionsActivity extends AppCompatActivity {

    //Variabler til lydindstillinger. Initialiseret til være være null pr. default.
    private SeekBar volumeSeekbar = null;
    private AudioManager audioManager = null;

    //Overrider den default onCreate-metode
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        initControls();

        //Tvinger activitien til at være i "Portrait orientation mode".
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Forbinder variablerne med knapperne i xml-filen.
        Button menuBtn = (Button) findViewById(R.id.menuBtn);
        Button returnBtn = (Button) findViewById(R.id.returnBtn);

        //Metode som får returnBtn til at hoppe tilbage til activitien, som var før den nuværende.
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
            }
        });

        //Metode som får returnBtn til at hoppe tilbage activiten, som var før den nuværende.
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OptionsActivity.super.onBackPressed();
            }
        });

    }

    //Metode der håndterer baggrundsmusikkens seekbar med en try-catch-block.
    private void initControls() {
        try {
            volumeSeekbar = (SeekBar) findViewById(R.id.bgSeek);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            volumeSeekbar.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeSeekbar.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));

            volumeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onStopTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onStartTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                            progress, 0);
                }
            });
        } catch (Exception e) {
            //Fanger exception, hvis det skulle opstå
            e.printStackTrace();
        }
    }
}