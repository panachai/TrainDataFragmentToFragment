package com.example.killercon.traindatafragmenttofragment;


import android.os.Bundle;

import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class fragment_my extends Fragment {
    private Bus bus = new Bus();

    @Override
    public void onStart() {
        super.onStart();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        BusProvider.getInstance().unregister(this);
    }

    public fragment_my() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment_my, container, false);
    }

    @Subscribe
    public void onObjectSubscribed(ContactsContract.Data data) {

    }

    @Subscribe
    public void onStringSubscribed(String data) {
        Log.d("testbus Event : ",data);
    }

    @Subscribe
    public void findTests(fragment_my event) {
        Log.d("testbus Event : ","complete");
    }


}
