package com.example.pa_ctic;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class NewService extends Service {
    String message = "Entro en OnstartCommand";
    String message2 = "Entro en onDestoy";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i(null,message);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(null,message2);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
    return null;
    }
}