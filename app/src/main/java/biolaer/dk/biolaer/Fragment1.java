package biolaer.dk.biolaer;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;


public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Random random = new Random();
        int randomQ = random.nextInt(5)+1;

        DatabaseReference mDatabaseq4 = FirebaseDatabase.getInstance().getReference().child("questions").child("questions_easy").child("questions_all").child("q4");
        DatabaseReference mDatabaseq5 = FirebaseDatabase.getInstance().getReference().child("questions").child("questions_easy").child("questions_all").child("q5");
        DatabaseReference mDatabaseq6 = FirebaseDatabase.getInstance().getReference().child("questions").child("questions_easy").child("questions_all").child("q6");
        DatabaseReference mDatabaseq7 = FirebaseDatabase.getInstance().getReference().child("questions").child("questions_easy").child("questions_all").child("q7");
        DatabaseReference mDatabaseq8 = FirebaseDatabase.getInstance().getReference().child("questions").child("questions_easy").child("questions_all").child("q8");


        //DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        Question dbCon = new Question();

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


        if (randomQ == 1){
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

                question_imageView.setImageResource(R.drawable.spm1); //SKAL ÆNDRES

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

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }); }
        else if (randomQ == 2){
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

                    question_imageView.setImageResource(R.drawable.spm2); //SKAL ÆNDRES

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
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        else if (randomQ == 3){
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
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        else if (randomQ == 4){
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
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        else if (randomQ ==5 ){
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
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
