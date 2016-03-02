package com.udacity.grad.builditbiggerpaid;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.Joker;
import com.udacity.gradle.builditbiggerfree.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button getJokesGCE;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

//        AdView mAdView = (AdView) root.findViewById(R.id.adView);
//        // Create an ad request. Check logcat output for the hashed device ID to
//        // get test ads on a physical device. e.g.
//        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .build();
//        mAdView.loadAd(adRequest);
        TextView textView = (TextView) root.findViewById(R.id.text_view);
        Joker myJoker = new Joker();
        textView.setText(myJoker.getJoke());

        getJokesGCE = (Button) root.findViewById(R.id.getJokes);

        getJokesGCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJokesFromGCE();
            }
        });

        return root;
    }

    public void getJokesFromGCE(){
        new EndpointsAsyncTask().execute(new Pair<Context, String>(getActivity(), "..."));
    }
}
