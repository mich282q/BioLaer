package biolaer.dk.biolaer.Activities;

//Importerer nødvendige libraries
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import biolaer.dk.biolaer.BusinessLogic.Timer;
import biolaer.dk.biolaer.R;

/**
 * Denne klasse fungerer som skærmbillede til alle spørgsmålene.
 * Det er her brugerens point og tid vises.
 * Den er desuden pladsholder for det fragment, der automatisk genererer et nyt spørgsmål,
 * som hentes fra Firebase.
 */
public class QuestionsActivity extends AppCompatActivity {

    //Klassevariabler el. fields
    public static TextView actualPoint_textView; //Skal være static for at virke
    public static int pointT;
    public static TextView actualTime_textView; //Skal være static for at virke
    private MediaPlayer timesUp;
    Timer timer = Fragment1.timer; //timer object som sættes til at være timeren i Fragment1


    //Metode der tilføjer 100 point til dine samlede point
    public void addPoints(){
        pointT = Integer.parseInt(actualPoint_textView.getText().toString());
        actualPoint_textView.setText(pointT + 100 + "");
    }

    //Metode der parser brugerens point til integer og returnerer
    public int getPointT() {
        pointT = Integer.parseInt(actualPoint_textView.getText().toString());
        return pointT;
    }

    /**
     * Denne betode beregner din rang. Baseret på dine samlede point.
     */
    public String getRank(){
        String rank = ""; //Pr. default ingen rang

        if (pointT == 0){
            rank = "Noob";
        }
        else if (pointT == 100){
        rank = "Begynder";
        }
        else if (pointT >= 200 && pointT <= 500){
            rank = "Folkeskoleelev";
        }
        else if (pointT >= 600 && pointT <= 800){
            rank = "Gymnasieelev";
        }
        else if (pointT >= 900 && pointT <= 1200){
            rank = "Biologientusiast";
        }
       else {
            rank = "Pro!";
        }

        return rank;
    }

    //Deklarerer og initialiserer et nyt fragment.
    Fragment1 fragment1 = new Fragment1();

    //Metode til at udelukke muligheden for gå tilbage, hvis der svares forkert på spg.
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    //Metode der fortsat fjerner navigationsbaren, selvom der klikkes et sted i aktiviteten.
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        actualTime_textView = (TextView) findViewById(R.id.actualTime_textView);
        timesUp = MediaPlayer.create(getApplicationContext(), R.raw.timesup);

        actualTime_textView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (actualTime_textView.getText().equals("Tiden er gået!")) {
                    timesUp.start();
                    Intent endActivity = new Intent(getApplicationContext(), EndActivity.class);
                    startActivity(endActivity);
                    Toast.makeText(getApplicationContext(),"Tiden er gået!", Toast.LENGTH_LONG).show();
                    timer.stopTimer();
                }
            }
        });

        //Lokale fields der forbinder til xml-filen
        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);
        actualPoint_textView = (TextView) findViewById(R.id.actualPoint_textView);

        //Tvinger aktiviteten til at være i "Portrait orientation mode".
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Følgende kodestykke fjerner bl.a. navigationsbaren i bunden af aktiviteten.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

        /** Kalder en "setOnClickListener" på "optionsBtn" der dikterer, hvad der skal ske,
         når brugeren klikker på cockwheel-ikonet i hjørnet */
        optionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent optionsActivity = new Intent(getApplicationContext(), OptionsActivity.class);
                startActivity(optionsActivity);
            }
        });
     /*   android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
         boolean fragNumber = true;

     //   if (fragNumber = true)
       // {
            Fragment1 fragment1 = new Fragment1();
            fragmentTransaction.replace(R.id.fragment1, fragment1);
            fragmentTransaction.addToBackStack(null);
        //}
        else if (fragNumber = false)
        {
            Fragment2 fragment2 = new Fragment2();
            fragmentTransaction.replace(R.id.fragment2, fragment2);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit(); */
    }
}