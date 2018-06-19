package biolaer.dk.biolaer.Activities;

//Nødvendige imports
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import biolaer.dk.biolaer.R;

/**
 * Denne klasse er tiltænkt at skulle bruges til det svære niveau.
 * På samme måde som easyFragment bliver brugt til det lette niveau.
 */
public class hardFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hardfragment, container, false);

    }
}
