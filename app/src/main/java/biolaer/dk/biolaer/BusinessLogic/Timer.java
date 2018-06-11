package biolaer.dk.biolaer.BusinessLogic;

//Nødvendige imports
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;
import java.util.Locale;
import biolaer.dk.biolaer.Activities.QuestionsActivity;

/*
 * Denne klasse styrer business logic i forhold til den timer, der er på besvarelse af spørgsmål.
 */
public class Timer {

    //Variabler der bruges til at definere timerens logik
    private static final long START_TIME_IN_MILLIS = 60000;
    public TextView actualTime_textView;
    private CountDownTimer mCountDownTimer;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    public void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
            actualTime_textView.setText("Tiden er gået!");

            }
        }.start();
    }

    public void resetTimer() {
        mCountDownTimer.cancel();
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        startTimer();
    }

    public void stopTimer(){
        mCountDownTimer.cancel();
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
    }

    public void updateCountDownText() {
        actualTime_textView = QuestionsActivity.actualTime_textView;

        //Lokale variabler
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),
                "%02d:%02d", minutes, seconds);

        // Når der er under 10 sekunder tilbage skifter, farven til rød.
        if (mTimeLeftInMillis < 10000) {
            actualTime_textView.setTextColor(Color.RED);
        }
        else {
            actualTime_textView.setTextColor(Color.WHITE);
        }
        actualTime_textView.setText(timeLeftFormatted);
    }
}