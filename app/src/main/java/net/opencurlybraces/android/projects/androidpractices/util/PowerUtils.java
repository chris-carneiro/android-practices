package net.opencurlybraces.android.projects.androidpractices.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.preference.PreferenceManager;

/**
 * Created by chris on 16/01/15.
 */
public class PowerUtils {

    /**
     * Boolean indicating the whether the battery is charging*
     */
    private static final String PREF_BATTERY_CHARGING = "pref_battey_charging";

    /**
     * Try to get the battery charging status using the sticky intents {@code android.intent.action
     * .ACTION_POWER_CONNECTED} and {@code android.intent.action .ACTION_POWER_DISCONNECTED} . If
     * there's no sticky intent, get the cached value from {@link android.content
     * .SharedPreferences}
     *
     * @param context
     * @return boolean
     */
    public static boolean isBatteryCharging(final Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null,
                ifilter); //Get a sticky intent or null

        if (batteryStatus == null) return sp.getBoolean(PREF_BATTERY_CHARGING, false);

        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

        return (status == BatteryManager.BATTERY_STATUS_CHARGING || status ==
                BatteryManager.BATTERY_STATUS_FULL);
    }

    /**
     * Store asynchronously the battery charging status in {@link SharedPreferences}.
     *
     * @param context
     * @param isCharging
     */
    public static void setBatteryCharging(Context context, boolean isCharging) {

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_BATTERY_CHARGING, isCharging).apply();
    }
}
