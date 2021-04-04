package com.example.indoornavigationwithaugmentedreality;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class WifiBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        boolean connected = false;

        if (WifiManager.SUPPLICANT_STATE_CHANGED_ACTION.equals(action)) {
            SupplicantState state = intent.getParcelableExtra(WifiManager.EXTRA_NEW_STATE);

            if (SupplicantState.isValidState(state) && state == SupplicantState.COMPLETED) {
                connected = checkConnectedToDesiredWifi(context);
            }

            if (connected) {
                Toast.makeText(context,"You are connected to home-wifi",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context,"You are not connected to home-wifi",Toast.LENGTH_SHORT).show();
            }
        }

    }

    /** Detect you are connected to a specific network. */
    private boolean checkConnectedToDesiredWifi(Context context) {

        boolean connected = false;
        String desiredMacAddress = "74-B5-7E-1D-CE-28";
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifi = wifiManager.getConnectionInfo();

        if (wifi != null) {
            // get current router Mac address
            String bssid = wifi.getBSSID();
            connected = desiredMacAddress.equals(bssid);
        }

        return connected;
    }


}
