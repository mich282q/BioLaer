package biolaer.dk.biolaer.BusinessLogic;

//Importerer nødvendige libraries
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question {

    //Klassevariabler
   private DatabaseReference mDatabase; //Variabel til Firebase-connection

    //Metoder - referencer til forskellige dele af databasen
    public void setmDatabaseEasyQ(DatabaseReference mDatabase) {
        this.mDatabase = mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference().child("questions")
                .child("questions_easy").child("questions_all").child("q4");
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

    //Variabler til highscoren
    String point;
    String navn;

    public Question(){
    }

    public Question(String point, String navn) {
        this.point = point;
        this.navn = navn;
    }

    public void setPoint(String point)
    {
        this.point = point;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getPoint() {
        return point;
    }

    public String getNavn() {
        return navn;
    }

}