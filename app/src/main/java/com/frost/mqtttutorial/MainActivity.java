package com.frost.mqtttutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import android.Manifest;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import helpers.MqttHelper;

public class MainActivity extends AppCompatActivity {

    MqttHelper mqttHelper;
    TextView dataReceived;
    Button btn_send;

    private static final String TAG = "MainActivity";
    private static final String PREF_USER_MOBILE_PHONE = "pref_user_mobile_phone";
    private static final int SMS_PERMISSION_CODE = 0;
    private String mUserMobilePhone = "86180278";
    private SharedPreferences mSharedPreferences;
    String SmsMessage = "Hello Laura";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataReceived = (TextView) findViewById(R.id.dataReceived);
        btn_send = (Button) findViewById(R.id.send_sms);
        startMqtt();
        btn_send.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {   checkAndUpdateUserPrefNumber();
                SmsHelper.sendDebugSms(mUserMobilePhone, SmsMessage);
                Toast.makeText(getApplicationContext(), R.string.toast_sending_sms, Toast.LENGTH_SHORT).show();
            }        });
    }

    private void startMqtt(){
        mqttHelper = new MqttHelper(getApplicationContext());
        mqttHelper.mqttAndroidClient.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {
                Log.w("Debug","Connected");
            }

            @Override
            public void connectionLost(Throwable throwable) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
                Log.w("Debug",mqttMessage.toString());
                dataReceived.setText(mqttMessage.toString());
                mUserMobilePhone = mqttMessage.toString().split(" ")[0];
                SmsMessage = mqttMessage.toString().split(" ")[1];

            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

            }
        });
    }
    /**
     * Checks if stored SharedPreferences value needs updating and updates \o/
     */
    private void checkAndUpdateUserPrefNumber() {
        if (TextUtils.isEmpty(mUserMobilePhone)  ) {
            mSharedPreferences
                    .edit()
                    .putString(PREF_USER_MOBILE_PHONE, mUserMobilePhone)
                    .apply();
        }
    }

}
