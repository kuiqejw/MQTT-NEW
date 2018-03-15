package com.frost.mqtttutorial;


import android.telephony.SmsManager;

/**
 * Constants helper class
 */

public class SmsHelper {

    public static final String SMS_CONDITION = "Some condition";

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.charAt(0)== '9' || phoneNumber.charAt(0) == '8'){
            if (phoneNumber.length() == 8 ){
                return true;
            }
        }
        return false;
    }

    public static void sendDebugSms(String number, String smsBody) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, smsBody, null, null);
    }
}