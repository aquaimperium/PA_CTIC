package com.example.pa_ctic;

import static android.app.PendingIntent.getActivity;
import static android.system.Os.remove;

import static androidx.core.location.LocationManagerCompat.removeUpdates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Inicializamos el UsingBroascastReceiver respetar la mayuscula
    UsingBroadcastReceiver usingBroadcastReceiver = new UsingBroadcastReceiver();
    public static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";
    // declaring objects of Button class
    private Button start, stop;
    //Declaramos variales temporales
    int onGPS = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigning ID of startButton
        // to the object start
        start = (Button) findViewById(R.id.startButton);

        // assigning ID of stopButton
        // to the object stop
        stop = (Button) findViewById(R.id.stopButton);

        // declaring listeners for the
        // buttons to make them respond
        // correctly according to the process
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        //Permisos del GPSGoogle
        //ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
        //ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},PackageManager.PERMISSION_GRANTED);
        //ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},PackageManager.PERMISSION_GRANTED);
        //Seguimiento de Variable
        Log.e(null, String.valueOf(onGPS));
    }

    public void onClick(View view) {

        // process to be performed
        // if start button is clicked
        if (view == start) {
            // starting the BroadCast
            //IntentFilter filter = new IntentFilter(SMS_RECEIVED_ACTION);
            //registerReceiver(usingBroadcastReceiver,filter);
            // starting the service
            startService(new Intent(this, NewService.class));
            //GPSGoogle
            onGPS = usingBroadcastReceiver.onGPS;
            Log.e(null, String.valueOf(onGPS));
            Intent intent = new Intent(MainActivity.this, GPSGoogle.class);
            MainActivity.this.startActivity(intent);
        }

        // process to be performed
        // if stop button is clicked
        else if (view == stop) {
            //unregisterReceiver(usingBroadcastReceiver);
            stopService(new Intent(this, NewService.class));
            //Cerrando el GPSGoogle
            finish();// No lo cierra, esto no funciona, es algo visual!!!!
            System.exit(0);//Este si funciona.
        }
    }
}