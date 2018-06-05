package biolaer.dk.biolaer;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

    QuestionsActivity testPoint = new QuestionsActivity();
    Random random = new Random();
     int randomQ;

    public  int rollQ(){
        randomQ = random.nextInt(5)+1;
        return randomQ;
    }

    public void wrongAnswer(){
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
        AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(getActivity());
            builder
                .setMessage("Rigtigt svar!")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        rollQ();
                        testPoint.setPoint(50);


                    }
                })
                .show();
    }



    //QuestionsActivity qq = new QuestionsActivity();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

     //   Random random = new Random();
      // final int randomQ = random.nextInt(5)+1;
       // final int randomQ = 1;

       final  FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();

       final QuestionsActivity qq = new QuestionsActivity();
     //  final TextView actualPoint_textView = (TextView) view.findViewById(R.id.actualPoint_textView);


        DatabaseReference mDatabaseq4 = FirebaseDatabase.getInstance().getReference().child("questions").child("questions_easy").child("questions_all").child("q4");
        DatabaseReference mDatabaseq5 = FirebaseDatabase.getInstance().getReference().child("questions").child("questions_easy").child("questions_all").child("q5");
        DatabaseReference mDatabaseq6 = FirebaseDatabase.getInstance().getReference().child("questions").child("questions_easy").child("questions_all").child("q6");
        DatabaseReference mDatabaseq7 = FirebaseDatabase.getInstance().getReference().child("questions").child("questions_easy").child("questions_all").child("q7");
        DatabaseReference mDatabaseq8 = FirebaseDatabase.getInstance().getReference().child("questions").child("questions_easy").child("questions_all").child("q8");


        //DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
      //  Question dbCon = new Question();

        final Button answerBtn1 = (Button) view.findViewById(R.id.answerBtn1);
        final Button answerBtn2 = (Button) view.findViewById(R.id.answerBtn2);
        final Button answerBtn3 = (Button) view.findViewById(R.id.answerBtn3);
        final Button answerBtn4 = (Button) view.findViewById(R.id.answerBtn4);
        final Button infoBtn1 = (Button) view.findViewById(R.id.infoBtn1);
        final Button infoBtn2 = (Button) view.findViewById(R.id.infoBtn2);
        final Button infoBtn3 = (Button) view.findViewById(R.id.infoBtn3);
        final Button infoBtn4 = (Button) view.findViewById(R.id.infoBtn4);
        final TextView question_textView = (TextView) view.findViewById(R.id.question_textView);
        final ImageView question_imageView =(ImageView) view.findViewById(R.id.question_imageView);


        if (rollQ() == 1){
            mDatabaseq4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String question = (String) dataSnapshot.child("question").getValue();
                question_textView.setText(question);

                final String answer1 = (String) dataSnapshot.child("answer1").getValue();
                final String answer2 = (String) dataSnapshot.child("answer2").getValue();
                final String answer3 = (String) dataSnapshot.child("answer3").getValue();
                final String answer4 = (String) dataSnapshot.child("answer4").getValue();

                answerBtn1.setText(answer1);
                answerBtn2.setText(answer2);
                answerBtn3.setText(answer3);
                answerBtn4.setText(answer4);

                question_imageView.setImageResource(R.drawable.elisa_spm4); //SKAL ÆNDRES

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

                       wrongAnswer();
                    }
                });
                answerBtn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        wrongAnswer();
                    }
                });
                answerBtn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        wrongAnswer();
                    }
                });
                answerBtn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // Intent questionsActivity = new Intent(getContext(), QuestionsActivity.class);
                       // startActivity(questionsActivity);

                        /*
                        Fragment1 nextFrag= new Fragment1();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment1, nextFrag,"findThisFragment")
                                .addToBackStack(null)
                                .commit();  */
                        //Fragment1 fragment1 = new Fragment1();
                        //fragmentTransaction.replace(android.R.id.content, fragment1);

                       // FragmentTransaction ft = getFragmentManager().beginTransaction();
                       // ft.detach(Fragment1.this).attach(Fragment1.this).addToBackStack(null).commit();

                        rightAnswer();

                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }); }
        else if (rollQ() == 2){
            mDatabaseq5.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String question = (String) dataSnapshot.child("question").getValue();
                    question_textView.setText(question);

                    final String answer1 = (String) dataSnapshot.child("answer1").getValue();
                    final String answer2 = (String) dataSnapshot.child("answer2").getValue();
                    final String answer3 = (String) dataSnapshot.child("answer3").getValue();
                    final String answer4 = (String) dataSnapshot.child("answer4").getValue();

                    answerBtn1.setText(answer1);
                    answerBtn2.setText(answer2);
                    answerBtn3.setText(answer3);
                    answerBtn4.setText(answer4);

                    question_imageView.setImageResource(R.drawable.elisa_spm5); //SKAL ÆNDRES

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
                            Toast.makeText(getActivity(), answer4, Toast.LENGTH_LONG).show();                  }
                    });
                    answerBtn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wrongAnswer();

                        }
                    });
                    answerBtn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rightAnswer();
                        }
                    });
                    answerBtn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rightAnswer();
                        }
                    });
                    answerBtn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wrongAnswer();
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        else if (rollQ() == 3){
            mDatabaseq6.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String question = (String) dataSnapshot.child("question").getValue();
                    question_textView.setText(question);

                    final String answer1 = (String) dataSnapshot.child("answer1").getValue();
                    final String answer2 = (String) dataSnapshot.child("answer2").getValue();
                    final String answer3 = (String) dataSnapshot.child("answer3").getValue();
                    final String answer4 = (String) dataSnapshot.child("answer4").getValue();

                    answerBtn1.setText(answer1);
                    answerBtn2.setText(answer2);
                    answerBtn3.setText(answer3);
                    answerBtn4.setText(answer4);
                    question_imageView.setImageResource(R.drawable.elisa_spm6); //SKAL ÆNDRES


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
                            Toast.makeText(getActivity(), answer4, Toast.LENGTH_LONG).show();                  }
                    });

                    answerBtn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wrongAnswer();
                        }
                    });
                    answerBtn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wrongAnswer();

                        }
                    });
                    answerBtn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wrongAnswer();

                        }
                    });
                    answerBtn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rightAnswer();
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        else if (rollQ() == 4){
            mDatabaseq7.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String question = (String) dataSnapshot.child("question").getValue();
                    question_textView.setText(question);

                    final String answer1 = (String) dataSnapshot.child("answer1").getValue();
                    final String answer2 = (String) dataSnapshot.child("answer2").getValue();
                    final String answer3 = (String) dataSnapshot.child("answer3").getValue();
                    final String answer4 = (String) dataSnapshot.child("answer4").getValue();

                    answerBtn1.setText(answer1);
                    answerBtn2.setText(answer2);
                    answerBtn3.setText(answer3);
                    answerBtn4.setText(answer4);

                    question_imageView.setImageResource(R.drawable.elisa_spm7); //SKAL ÆNDRES


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
                            Toast.makeText(getActivity(), answer4, Toast.LENGTH_LONG).show();                  }
                    });
                    answerBtn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wrongAnswer();

                        }
                    });
                    answerBtn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wrongAnswer();

                        }
                    });
                    answerBtn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wrongAnswer();

                        }
                    });
                    answerBtn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rightAnswer();
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        else if (rollQ() ==5 ){
            mDatabaseq8.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String question = (String) dataSnapshot.child("question").getValue();
                    question_textView.setText(question);

                    final String answer1 = (String) dataSnapshot.child("answer1").getValue();
                    final String answer2 = (String) dataSnapshot.child("answer2").getValue();
                    final String answer3 = (String) dataSnapshot.child("answer3").getValue();
                    final String answer4 = (String) dataSnapshot.child("answer4").getValue();

                    answerBtn1.setText(answer1);
                    answerBtn2.setText(answer2);
                    answerBtn3.setText(answer3);
                    answerBtn4.setText(answer4);

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
                            Toast.makeText(getActivity(), answer4, Toast.LENGTH_LONG).show();                  }
                    });
                    answerBtn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wrongAnswer();

                        }
                    });
                    answerBtn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rightAnswer();
                        }
                    });
                    answerBtn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wrongAnswer();

                        }
                    });
                    answerBtn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wrongAnswer();

                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
