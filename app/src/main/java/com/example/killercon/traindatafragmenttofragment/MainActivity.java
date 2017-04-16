package com.example.killercon.traindatafragmenttofragment;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {
    Bus bus = new Bus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bus.register(this);

    }


    @Override
    protected void onStart() {
        super.onStart();
        //BusProvider.getInstance().register(this);
        BusProvider.getInstance().register(this);

        //BusProvider.getInstance().post(new TestReqEvent());

        Log.d("onstart : ","complete");

        fragment_my blankFragment = new fragment_my();
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        /*เขียนเต็มๆแบบนี้
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
         */
        transaction.replace(R.id.fragment_container, blankFragment);
        transaction.addToBackStack(null); //เพื่อให้กด Back แล้วปิด fragment ก่อน
        transaction.commit();

    }

    @Override
    public void onStop() {
        super.onStop();
        //BusProvider.getInstance().unregister(this);

        BusProvider.getInstance().unregister(this);
    }


    public void OnSettext(View view) {
        String data = "busevent : complete";

        BusProvider.getInstance().post(data);

        Log.d("test Onsettext : ", "complete");



    }


}
