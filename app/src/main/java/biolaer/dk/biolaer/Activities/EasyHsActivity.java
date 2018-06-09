package biolaer.dk.biolaer.Activities;

//Nødvendige imports
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Collections;

import biolaer.dk.biolaer.R;

/**
 * Denne klasse indeholder fields og logik for klassen "EasyHsActivity", der er den aktivitet,
 * der vises for brugeren, når der vælges den lette sværhedsgrad ift. highscore-listen.
 */
public class EasyHsActivity extends AppCompatActivity { //Extender AppCompatActivity

    //Variabler der anvendes i klassen
    private DatabaseReference mDatabase; //Til Firebase-connection
    private ListView scoreList_dynamic;
    private ArrayList<String> listNavn = new ArrayList<>();
    private ProgressDialog progressDialog; //Til Progress-baren

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

    //Overrider den default onCreate-metode med vores properties til denne aktivitet
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_hs);

        //Tvinger aktiviteten til at være i Portrait orientation mode.
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

        //Connector fields til buttons i xml-filen
        Button returnBtn = (Button) findViewById(R.id.returnBtn);
        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);

        //Firebase-variabler til connection til db
        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference dbnavn = mDatabase.child("highscore");
        final DatabaseReference dbnavn_2 = dbnavn.child("highscore_easy");

        //Forbinder scoreList_dynamic med listview i xml-filen
        scoreList_dynamic = (ListView) findViewById(R.id.scoreList_dynamic);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listNavn);

        scoreList_dynamic.setAdapter(arrayAdapter);

        final Query queryRef = dbnavn_2.orderByChild("point");

        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String navn = (String) dataSnapshot.child("navn").getValue()+ "\n"+
                       dataSnapshot.child("point").getValue();
                listNavn.add(navn);
                arrayAdapter.notifyDataSetChanged();
            }

            // Hvis denne metode fjernes får vi fejl
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Collections.reverse(listNavn);
            }
            // Hvis denne metode fjernes får vi fejl
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                //Umiddelbart intet indhold
            }
            // Hvis denne metode fjernes får vi fejl
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                //Umiddelbart intet indhold
            }

            // Hvis denne metode fjernes får vi fejl
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Umiddelbart intet indhold
            }

        });

        queryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Collections.reverse(listNavn);
            }

            // Hvis denne metode fjernes får vi fejl
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Umiddelbart intet indhold
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

        //Metode som får returnBtn til at hoppe tilbage til aktiviteten, som var før den nuværende.
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyHsActivity.super.onBackPressed();
            }
        });
    }

    //Progress baren kaldes, når aktiviteten startes
    public void onStart() {
        super.onStart();

        //Initialiserer "progressDialog" med titel og besked
        progressDialog = ProgressDialog.show(this,"Vent venligst",
                "Henter highscore...",true);

        //Laver et nyt CountDownTimer-objekt og sætter det til at blive vist 2 sekunder
        CountDownTimer timer = new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
               //Metoden skal være tom
            }

            //Fjerner "progressDialog" igen, når timeren udløber
            @Override
            public void onFinish() {
                progressDialog.dismiss();
            }

        }
        //Starter metoden
        .start();
    }
}