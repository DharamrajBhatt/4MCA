package com.example.chinnu.lab12;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int BLUETOOTH_CODE = 1;
    SwitchCompat sc1,sc2;
    SeekBar sb;
    ImageView iv1,iv2,iv3;
    BluetoothAdapter bluetoothAdapter;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sc1 = (SwitchCompat)findViewById(R.id.wifis);
        sc2 = (SwitchCompat)findViewById(R.id.blues);
        //sb = (SeekBar) findViewById(R.id.brights);

        //int cbright = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS,0);
        //sb.setProgress(cbright);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        iv1 = (ImageView)findViewById(R.id.wifi);
        iv2 = (ImageView)findViewById(R.id.blue);
        //iv3 = (ImageView)findViewById(R.id.bright);

        iv1.setImageDrawable((getResources().getDrawable(R.drawable.ic_wifi)));
        iv2.setImageDrawable((getResources().getDrawable(R.drawable.ic_bluetooth)));
      //  iv3.setImageDrawable((getResources().getDrawable(R.drawable.ic_brightness)));

        sc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sc1.isChecked()){
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.ic_wifi_green));
                    wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(true);
                }else{
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.ic_wifi));
                    wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(false);
                }
            }
        });

        sc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sc2.isChecked() && !bluetoothAdapter.isEnabled()) {
                        iv2.setImageDrawable(getResources().getDrawable(R.drawable.ic_bluetooth_green));
                        Intent blueintent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(blueintent, BLUETOOTH_CODE);
                }else{
                    iv2.setImageDrawable((getResources().getDrawable(R.drawable.ic_bluetooth)));
                    bluetoothAdapter.disable();
                }

            }
        });

//        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                Context context = getApplicationContext();
//                boolean canWrite = Settings.System.canWrite(context);
//                if(canWrite){
//                    int sbright = progress*255/255;
//                    Settings.System.putInt(context.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
//                    Settings.System.putInt(context.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS, sbright);
//                }else {
//                    Intent i = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
//                    context.startActivity(i);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//
//
//            }
//        });
    }
}
