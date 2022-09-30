package com.example.pa_ctic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class UsingBroadcastReceiver extends BroadcastReceiver {

    String no = "6505551212";
    String message = "Pedido de Emergencia";

    @Override
    public void onReceive(Context context, Intent intent) {
        String address1 = null;
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            SmsMessage[] messages = new SmsMessage[pdus.length];
            for (int i = 0; i < pdus.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                address1 = messages[i].getOriginatingAddress();
            }
            if (address1.equals(no)){
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
