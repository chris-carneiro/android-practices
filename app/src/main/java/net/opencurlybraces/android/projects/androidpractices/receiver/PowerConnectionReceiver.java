package net.opencurlybraces.android.projects.androidpractices.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

import net.opencurlybraces.android.projects.androidpractices.util.PowerUtils;

/**
 * Receiver that listens to changes in power status changes
 * <p/>
 * Created by chris on 16/01/15.
 */
public class PowerConnectionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = (status == BatteryManager.BATTERY_STATUS_CHARGING || status ==
                BatteryManager.BATTERY_STATUS_FULL);

        PowerUtils.setBatteryCharging(context, isCharging);
    }
}
