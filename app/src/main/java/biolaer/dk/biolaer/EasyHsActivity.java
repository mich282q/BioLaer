package biolaer.dk.biolaer;

import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
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

public class EasyHsActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private ListView scoreList_dynamic;
    private ArrayList<String> listNavn = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_hs);
        // Tvinger activityen til at være i Portrait orientation mode.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button returnBtn = (Button) findViewById(R.id.returnBtn);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference DBnavn = mDatabase.child("highscore");
        DatabaseReference DBnavn_2 = DBnavn.child("highscore_easy");
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

                    String navn = (String) dataSnapshot.child("navn").getValue()+ "\t\t\t\t\t\t\t\t"+
                            (String) dataSnapshot.child("point").getValue();
                    //String point = (String) dataSnapshot.child("point").getValue();
                    listNavn.add(navn);
                    //listNavn.add(point);
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

        //Metode som får returnBtn til at hoppe tilbage til aktiviteten, som var før den nuværende.
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyHsActivity.super.onBackPressed();
            }
        });

    }
}
