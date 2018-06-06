package biolaer.dk.biolaer;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

/**
 * Denne klasse repræsenterer den lette sværhedsgrad.
 */


public class Fragment1 extends Fragment {

    DatabaseReference mDatabaseX;

    Button answerBtn1;
    Button answerBtn2;
    Button answerBtn3;
    Button answerBtn4;
    Button infoBtn1;
    Button infoBtn2;
    Button infoBtn3;
    Button infoBtn4;
    TextView question_textView;
    ImageView question_imageView;
    MediaPlayer falseSound, correctSound;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        falseSound = MediaPlayer.create(getActivity(), R.raw.falsesound);
        correctSound = MediaPlayer.create(getActivity(), R.raw.correctsound);
    }

    public void wrongAnswer(){
        falseSound.start(); // Afspiller lydeffekt
        AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(getActivity());
            builder
                .setMessage("Du svarede desværre forkert!")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent endActivity = new Intent(getContext(), EndActivity.class);
                        startActivity(endActivity);
                    }
                })
                .show();
    }

    public void rightAnswer(){
        correctSound.start(); // Afspiller lydeffekt
        AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(getActivity());
            builder
                .setMessage("Rigtigt svar!")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                        changeQuestion();
                    }
                })
                .show();
    }

  /* NOTE:
+    ALt det, som er pt inde i onViewCreated()  skal trækkes ud i en metode her, der hedder changeQuestion()
+
+    public changeQuestion() {
+     // Her kommer alt guf fra onViewCreated() -- og husk såp at kalde changeQuestion() fra onViewCreated()
+    }
+    se, hvordan du skifter et fragment med et andet:
+    https://developer.android.com/training/basics/fragments/fragment-ui#Replace
+
+    */
  public void changeQuestion(){
      Random randomx = new Random();
      final int x = randomx.nextInt(5)+4;
      final String questionID = "q" + x;
      mDatabaseX = FirebaseDatabase.getInstance().getReference().child("questions")
              .child("questions_easy").child("questions_all").child(questionID);



      mDatabaseX.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              String question = (String) dataSnapshot.child("question").getValue();
              question_textView.setText(question);

              final Integer correctAnswer =  dataSnapshot.child("correctAnswer").getValue(Integer.class);
              final int correctAnswer2 =  dataSnapshot.child("correctAnswer2").getValue(Integer.class);
              final String answer1 = (String) dataSnapshot.child("answer1").getValue();
              final String answer2 = (String) dataSnapshot.child("answer2").getValue();
              final String answer3 = (String) dataSnapshot.child("answer3").getValue();
              final String answer4 = (String) dataSnapshot.child("answer4").getValue();

              answerBtn1.setText(answer1);
              answerBtn2.setText(answer2);
              answerBtn3.setText(answer3);
              answerBtn4.setText(answer4);

              if (x == 4){
                  question_imageView.setImageResource(R.drawable.elisa_spm4);
              }
              else if (x == 5){
                  question_imageView.setImageResource(R.drawable.elisa_spm5);

              }
              else if (x == 6){
                  question_imageView.setImageResource(R.drawable.elisa_spm6);

              }
              else if (x == 7){
                  question_imageView.setImageResource(R.drawable.elisa_spm7);

              }
              else if (x == 8){
                  question_imageView.setImageResource(R.drawable.elisa_spm8);

              }


              infoBtn1.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Toast.makeText(getActivity(), answer1, Toast.LENGTH_LONG).show();
                  }
              });
              infoBtn2.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Toast.makeText(getActivity(), answer2, Toast.LENGTH_LONG).show();                  }
              });
              infoBtn3.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Toast.makeText(getActivity(), answer3, Toast.LENGTH_LONG).show();                  }
              });
              infoBtn4.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Toast.makeText(getActivity(), answer4, Toast.LENGTH_LONG).show();
                  }
              });

              answerBtn1.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      if (correctAnswer==1 || correctAnswer2==1) {
                          rightAnswer();}
                      else {
                          wrongAnswer();}
                  }
              });
              answerBtn2.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      if (correctAnswer==2 || correctAnswer2 ==2) {
                          rightAnswer();}
                      else {
                          wrongAnswer();}
                  }
              });
              answerBtn3.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      if (correctAnswer==3 ||correctAnswer2==3) {
                          rightAnswer();}
                      else {
                          wrongAnswer();}
                  }
              });
              answerBtn4.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      if (correctAnswer==4 || correctAnswer2==4) {
                          rightAnswer();}
                      else {
                          wrongAnswer();}
                  }
              });

          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError) {

          }
      });
  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Random randomx = new Random();
        final int x = randomx.nextInt(5)+4;
        final String questionID = "q" + x;
        mDatabaseX = FirebaseDatabase.getInstance().getReference().child("questions")
                .child("questions_easy").child("questions_all").child(questionID);


        answerBtn1 = (Button) view.findViewById(R.id.answerBtn1);
        answerBtn2 = (Button) view.findViewById(R.id.answerBtn2);
        answerBtn3 = (Button) view.findViewById(R.id.answerBtn3);
        answerBtn4 = (Button) view.findViewById(R.id.answerBtn4);
        infoBtn1 = (Button) view.findViewById(R.id.infoBtn1);
        infoBtn2 = (Button) view.findViewById(R.id.infoBtn2);
        infoBtn3 = (Button) view.findViewById(R.id.infoBtn3);
        infoBtn4 = (Button) view.findViewById(R.id.infoBtn4);
        question_textView = (TextView) view.findViewById(R.id.question_textView);
        question_imageView =(ImageView) view.findViewById(R.id.question_imageView);

            mDatabaseX.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String question = (String) dataSnapshot.child("question").getValue();
                question_textView.setText(question);

                final Integer correctAnswer =  dataSnapshot.child("correctAnswer").getValue(Integer.class);
                final int correctAnswer2 =  dataSnapshot.child("correctAnswer2").getValue(Integer.class);
                final String answer1 = (String) dataSnapshot.child("answer1").getValue();
                final String answer2 = (String) dataSnapshot.child("answer2").getValue();
                final String answer3 = (String) dataSnapshot.child("answer3").getValue();
                final String answer4 = (String) dataSnapshot.child("answer4").getValue();

                answerBtn1.setText(answer1);
                answerBtn2.setText(answer2);
                answerBtn3.setText(answer3);
                answerBtn4.setText(answer4);

                if (x == 4){
                    question_imageView.setImageResource(R.drawable.elisa_spm4);
                }
                else if (x == 5){
                    question_imageView.setImageResource(R.drawable.elisa_spm5);

                }
                else if (x == 6){
                    question_imageView.setImageResource(R.drawable.elisa_spm6);

                }
                else if (x == 7){
                    question_imageView.setImageResource(R.drawable.elisa_spm7);

                }
                else if (x == 8){
                    question_imageView.setImageResource(R.drawable.elisa_spm8);

                }


                infoBtn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            Toast.makeText(getActivity(), answer1, Toast.LENGTH_LONG).show();
                    }
                    });
                infoBtn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), answer2, Toast.LENGTH_LONG).show();                  }
                });
                infoBtn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), answer3, Toast.LENGTH_LONG).show();                  }
                });
                infoBtn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), answer4, Toast.LENGTH_LONG).show();
                    }
                });

                answerBtn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (correctAnswer==1 || correctAnswer2==1) {
                            rightAnswer();}
                        else {
                            wrongAnswer();}
                    }
                });
                answerBtn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (correctAnswer==2 || correctAnswer2 ==2) {
                            rightAnswer();}
                            else {
                            wrongAnswer();}
                    }
                });
                answerBtn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (correctAnswer==3 ||correctAnswer2==3) {
                            rightAnswer();}
                        else {
                            wrongAnswer();}
                    }
                });
                answerBtn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (correctAnswer==4 || correctAnswer2==4) {
                            rightAnswer();}
                        else {
                            wrongAnswer();}
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
