package net.opencurlybraces.android.projects.androidpractices.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

/**
 * Created by chris on 16/01/15.
 */
public class PowerUtils {


    /**
     * Try to get the battery charging status using the sticky intents {@code android.intent.action
     * .ACTION_POWER_CONNECTED} and {@code android.intent.action .ACTION_POWER_DISCONNECTED} .
     * If there's no sticky intent, get the value from {@link android.content .SharedPreferences}
     *
     * @param context
     * @return boolean
     */
    public static boolean isBatteryCharging(final Context context) {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null,
                ifilter); //Get a sticky intent or null

        if (batteryStatus == null) return PrefUtils.isBatteryCharging(context);

        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

        return (status == BatteryManager.BATTERY_STATUS_CHARGING || status ==
                BatteryManager.BATTERY_STATUS_FULL);

    }
}
