package biolaer.dk.biolaer.BusinessLogic;

//Importerer nødvendige libraries
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;
import biolaer.dk.biolaer.R;

/**
 * Denne klasse starter en service, som er en længerevarende operation, der afspiller musik
 * i baggrunden på tværs af alle activities, så længe at applikationen er åben.
 */
public class MusicService extends Service implements MediaPlayer.OnErrorListener {

    // Definerer interfacet som kommunikerer mellem service og client.
    public final IBinder mBinder = new ServiceBinder(); //Deklarerer og initialiserer
    MediaPlayer mPlayer; //Variabel som bruges i onCreate-metoden
    public int length = 0;

    public class ServiceBinder extends Binder {
       public MusicService getService()
        {
            return MusicService.this;
        }
    }

    @Override
    public IBinder onBind(Intent arg0){ return mBinder; }

    @Override
    public void onCreate () {
        super.onCreate();
        // Peger på hvilken musikfil der skal afspilles. Findes i mappen "raw" under "res"
        mPlayer = MediaPlayer.create(this, R.raw.backgroundmusic);
        mPlayer.setOnErrorListener(this);

        /* Sætter sangen til at loope, og gør at sangen bliver afspillet med fuld styrke,
        afhængig af brugerens egne lydindstillinger. */
        if(mPlayer!= null) {
            mPlayer.setLooping(true);
            mPlayer.setVolume(100,100);
        }

        mPlayer.setOnErrorListener(new OnErrorListener() {
            public boolean onError(MediaPlayer mp, int what, int extra) {
                onError(mPlayer, what, extra);
                return true;
            }
        });
    }

    @Override
    public int onStartCommand (Intent intent, int flags, int startId) {
        mPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy () {
        super.onDestroy();
        if(mPlayer != null) {
            try {
                mPlayer.stop();
                mPlayer.release();
            } finally {
                mPlayer = null;
            }
        }
    }

    // I tilfælde af fejl, vises der en "Toast" på skærmen med en fejlbesked.
    public boolean onError(MediaPlayer mp, int what, int extra) {
        Toast.makeText(this, "FEJL: Baggrundsmusik", Toast.LENGTH_SHORT).show();
        if(mPlayer != null) {
            try {
                mPlayer.stop();
                mPlayer.release();
            } finally {
                mPlayer = null;
            }
        }
        return false;
    }}