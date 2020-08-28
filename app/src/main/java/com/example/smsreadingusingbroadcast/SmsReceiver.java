package com.example.smsreadingusingbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {
    private static SmsListener mListener;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] pdus = new Object[0];
        if (bundle != null) {
            pdus = (Object[]) bundle.get("pdus");
        }

        for(int i=0 ; i< pdus.length; i++){
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
            String sender = smsMessage.getDisplayOriginatingAddress();
            String messageBody = smsMessage.getMessageBody();
            mListener.messageReceived(messageBody);
        }
    }
    public static void bindListener(SmsListener listener) {
        mListener = listener;
    }
}
