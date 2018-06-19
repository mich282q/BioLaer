package biolaer.dk.biolaer.BusinessLogic;

//Importerer nødvendige libraries
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

/**
 * Denne klasse håndterer dele af den business logic, der kommer til udtryk i forbindelse med
 * rigtige og forkerte svar på spørgsmålene i app'en. Eksempelvis står den for tilfældig
 * generering af spørgsmål fra Firebase.
 */
public class Question {

    DatabaseReference mDatabaseX; //Databasereference variabel

    Random randomx = new Random(); //Genererer et Random object
    final int x = randomx.nextInt(5) + 4; //Initialiserer x til at vælge et tal fra 4 til 8
    final String questionID = "q" + x; //q4, q5, q6, q7, q8

    //Metode til at referere til et tilfældigt spørgsmål fra de nemme spørgsmål
    public DatabaseReference randomEasyRef(DatabaseReference databaseReference) {
        //Variabel som refererer til databasen
        mDatabaseX = FirebaseDatabase.getInstance().getReference().child("questions")
                .child("questions_easy").child("questions_all").child(questionID);
        return mDatabaseX;
    }

    //Metoder som henter den random værdi: x
    public int getX() {
        return x;
    }
}