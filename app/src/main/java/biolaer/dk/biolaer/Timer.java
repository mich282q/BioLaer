package biolaer.dk.biolaer;

//Nødvendige imports
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;
import java.util.Locale;

/**
 * Denne klasse styrer business logic i forhold til den timer, der er på besvarelse af spørgsmål.
 */
public class Timer {

    //Variabler der bruges til at definere timerens logik
    private final long COUNTDOWN_IN_MILLIS = 60000;
    private TextView textViewCountDown;
    private ColorStateList textColorDefaultCd; // Sørger for farven skifter til rød under 10 sek
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    /** Jeg føler lige at dette måske bør benyttes i QuestionsActivity klassen,
     *  da onFinish skal vel indholde en funktion som gør at appen siger gameover? /Shrug
     */
    public void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();

            }
        }.start();
    }

    public void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60; // Viser hvad der er tilbage efter /60

        /** Formaterer "minutes" og "seconds" ordenligt, hvis dette ikke er predefineret,
         * vil der opstå tilfælde, hvor at formatering ikke vil se ud som ønsket.
         */
        String timeFormatted = String.format(Locale.getDefault(),
                "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);

        // Når der er under 10 sekunder tilbage skifter, farven til rød.
        if (timeLeftInMillis < 10000) {
            textViewCountDown.setTextColor(Color.RED);
        // Hvis der er mere end 10 sekunder tilbage, beholder timeren den valgte farve fra xml.
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }
}