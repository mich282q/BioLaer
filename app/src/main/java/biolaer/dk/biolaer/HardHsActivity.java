package biolaer.dk.biolaer;

import android.content.Intent;
import android.content.pm.ActivityInfo;
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

import java.util.ArrayList;

public class HardHsActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private ListView scoreList_dynamic;
    private ArrayList<String> listNavn = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_hs);
        // Tvinger activityen til at være i Portrait orientation mode.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button returnBtn = (Button) findViewById(R.id.returnBtn);
        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference DBnavn = mDatabase.child("highscore");
        DatabaseReference DBnavn_2 = DBnavn.child("highscore_hard");
        DatabaseReference DBnavn_3 = DBnavn_2.child("id1");
        DatabaseReference DBnavn_4 = DBnavn_3.child("navn");
        DatabaseReference DBnavn_5 = DBnavn_3.child("point");

        scoreList_dynamic = (ListView) findViewById(R.id.scoreList_dynamic);


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listNavn);
        scoreList_dynamic.setAdapter(arrayAdapter);

        Query queryRef = DBnavn_2.orderByChild("point").limitToFirst(100);

        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String navn = (String) dataSnapshot.child("navn").getValue()+ "\n"+
                        (String) dataSnapshot.child("point").getValue();
                listNavn.add(navn);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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
                HardHsActivity.super.onBackPressed();
            }
        });
    }
}