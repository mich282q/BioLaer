package biolaer.dk.biolaer;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question {

   private DatabaseReference mDatabase;

    //Metoder - referencer til forskellige dele af databasen
    public void setmDatabaseEasyQ(DatabaseReference mDatabase) {
        this.mDatabase = mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference().child("questions")
                .child("questions_easy").child("questions_all");
    }

    public void setmDatabaseEasyAnswers(DatabaseReference mDatabase) {
        this.mDatabase = mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference().child("questions")
                .child("questions_easy").child("questions_answers");
    }

    public void setmDatabaseHardQ(DatabaseReference mDatabase) {
        this.mDatabase = mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference().child("questions")
                .child("questions_hard").child("questions_all");

    }

    public void setmDatabaseHardAnswers(DatabaseReference mDatabase) {
        this.mDatabase = mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference().child("questions")
                .child("questions_hard").child("questions_answers");
    }




}
