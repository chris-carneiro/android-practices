package net.opencurlybraces.android.projects.androidpractices.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * /** Utilities and constants related to app preferences.
 * <p/>
 * Created by chris on 15/01/15.
 */

public class PrefUtils {

    //TODO makeLogTag
    private static final String TAG = "PrefUtils";

    /**
     * Boolean indicating the whether the battery is charging*
     */
    private static final String PREF_BATTERY_CHARGING = "pref_battery_charging";

    /**
     * Check whether the battery status is charging or not
     *
     * @param context
     * @return boolean
     */
    public static boolean isBatteryCharging(final Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_BATTERY_CHARGING, false);
    }

    /**
     * Stores asynchronously the battery charging status in {@link SharedPreferences}.
     *
     * @param context
     * @param isCharging
     */
    public static void setBatteryCharging(Context context, boolean isCharging) {

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_BATTERY_CHARGING, isCharging).apply();
    }

}
