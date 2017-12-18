package com.eniserkaya.smsreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = SmsReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        try {
            if (bundle != null) {
                Object[] pdusObj = (Object[]) bundle.get("pdus");
                for (Object aPdusObj : pdusObj) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) aPdusObj);
                    String senderAddress = currentMessage.getDisplayOriginatingAddress();
                    String message = currentMessage.getDisplayMessageBody();

                    Log.e(TAG, "Received SMS: " + message + ", Sender: " + senderAddress);

                    Mesaj mesajObj = new Mesaj(senderAddress,message);
                    ObservableObject.getInstance().updateValue(mesajObj);


                    // if the SMS is not from our gateway, ignore the message
                    if (!senderAddress.contains("554415")) {
                        return;
                    }

                   /* // verification code from sms
                    String verificationCode = getVerificationCode(message);
                    LoginEkrani login = LoginEkrani.instance();
                    login.smsWrite(verificationCode);*/

                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
    }

}
